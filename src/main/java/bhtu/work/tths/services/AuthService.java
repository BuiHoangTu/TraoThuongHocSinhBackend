package bhtu.work.tths.services;

import bhtu.work.tths.security.jwt.JwtUtils;
import bhtu.work.tths.security.services.MyUserDetails;
import bhtu.work.tths.models.User;
import bhtu.work.tths.models.UserAcess;
import bhtu.work.tths.models.dto.LoginRequest;
import bhtu.work.tths.models.dto.LoginResponse;
import bhtu.work.tths.models.dto.SignupRequest;
import bhtu.work.tths.models.enums.EUserAccess;
import bhtu.work.tths.repositories.mongo.UserAccessRepo;
import bhtu.work.tths.repositories.mongo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;

    @Autowired
    public AuthService(AuthenticationManager authenticationManager, UserRepo userRepo, PasswordEncoder passwordEncoder, JwtUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtils = jwtUtils;
    }

    public ResponseEntity<?> authenticateUser(LoginRequest loginRequest) {
        // TODO: get user from own repo 
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.username(), loginRequest.password()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();

        ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);

        List<String> accesses = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .toList();

        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
                .body(new LoginResponse(userDetails.getUsername(), accesses));
    }

    public ResponseEntity<?> registerParent(SignupRequest signUpRequest) {
        if (this.userRepo.existsByUsername(signUpRequest.username())) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: Username is already taken!");
        }

        // with parent, AccessRegion is household number, 1 family should only have 1 account
        if (this.userRepo.existsByAccessRegion(signUpRequest.householdNumber())) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: This household already have an account!");
        }

        // Create new user's account
        User user = new User(
                null,
                signUpRequest.username(),
                passwordEncoder.encode(signUpRequest.password()),
                signUpRequest.householdNumber()
        );

        Set<UserAcess> userAccesses = UserAcess.build(EUserAccess.READ_A_STUDENT, EUserAccess.FIX_A_STUDENT_DETAIL);

        user.setAccesses(userAccesses);
        userRepo.insert(user);

        return authenticateUser(new LoginRequest(user.getUsername(), user.getPassword()));
    }

}
