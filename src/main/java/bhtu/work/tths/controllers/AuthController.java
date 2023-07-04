package bhtu.work.tths.controllers;

import bhtu.work.tths.services.AuthService;
import bhtu.work.tths.models.dto.LoginRequest;
import bhtu.work.tths.models.dto.SignupRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Collections;
import java.util.Map;


@RestController
@RequestMapping("api/auth")
@CrossOrigin(originPatterns = "*", maxAge = 3600)
public class AuthController {
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    private final AuthService authService;

    @Autowired
    public AuthController(@NonNull AuthService authService) {
        this.authService = authService;
    }

    // #region mapping
    @PostMapping("login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        logger.debug("User logging in: Username:" + loginRequest.username() + "; Password:" + loginRequest.password());
        var response = this.authService.authenticateUser(loginRequest);
        logger.debug(response.getHeaders().toString());
        return response;
    }

    @PostMapping("signup")
    public ResponseEntity<?> registerParent(@Valid @RequestBody SignupRequest signUpRequest) {
        return this.authService.registerParent(signUpRequest);
    }

    @RequestMapping("token")
    public Map<String, String> getToken(HttpSession session) {
        return Collections.singletonMap("token", session.getId());
    }

     @RequestMapping("user")
    public Principal user(Principal user) {
        return user;
    }
    // #endregion
}