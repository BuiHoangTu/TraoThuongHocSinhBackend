package bhtu.work.tths.controllers;

import bhtu.work.tths.services.AuthService;
import bhtu.work.tths.models.dto.LoginRequest;
import bhtu.work.tths.models.dto.SignupRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/auth")
public class AuthController {
    private final AuthService authService;

    @Autowired
    public AuthController(@NonNull AuthService authService) {
        this.authService = authService;
    }

    // #region mapping
    @PostMapping("sign-in")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        return this.authService.authenticateUser(loginRequest);
    }

    @PostMapping("signup")
    public ResponseEntity<?> registerParent(@Valid @RequestBody SignupRequest signUpRequest) {
        return this.authService.registerParent(signUpRequest);
    }
    // #endregion
}