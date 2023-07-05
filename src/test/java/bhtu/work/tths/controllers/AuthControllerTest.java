package bhtu.work.tths.controllers;

import bhtu.work.tths.models.User;
import bhtu.work.tths.models.dto.LoginRequest;
import bhtu.work.tths.repositories.mongo.UserRepo;
import bhtu.work.tths.security.jwt.IJwtService;
import bhtu.work.tths.security.jwt.JwtUtils;
import bhtu.work.tths.security.services.MyUserDetailsService;
import bhtu.work.tths.services.AuthService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseCookie;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.Duration;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AuthController.class)
//@Import({AuthService.class})
class AuthControllerTest {
    private static final ResponseCookie jwtCookies = ResponseCookie.from(
                    "tths",
                    "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTY4ODQ2MTg1MiwiZXhwIjoxNjg4NTQ4MjUyfQ.3gv5lCop0PJxLXkxXYHA-q2o8_rFbgBZTn-IF1h-1KfpQ5D46KYCNn7ey6jvEwVjB8mzO6_W8o-qpwp6mb71zQ"
            )
            .maxAge(Duration.ofSeconds(86400))
            .domain(null)
            .path("/api")
            .secure(false)
            .httpOnly(true)
            .sameSite(null)
            .build();


    @Autowired
    private MockMvc mock;
    @Autowired
    private ObjectMapper mapper;
    @MockBean
    private UserRepo userRepo;
    @MockBean
    private AuthService authService;
    @MockBean
    private AuthenticationManager authenticationManager;
    @MockBean
    private PasswordEncoder passwordEncoder;
    @MockBean
    private IJwtService jwtService;
    @MockBean
    private MyUserDetailsService myUserDetailsService;
    @MockBean
    private CsrfTokenRepository csrf;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // authService = new AuthService(authenticationManager, userRepo, new BCryptPasswordEncoder(), csrf, new JwtUtils());
    }

    @Test
    void authenticateUser() throws Exception {
        LoginRequest loginReq = new LoginRequest("admin", "admin2");
        User u = new User("1", "admin", "admin2", "VN");

        Class<String> str = null;
        Mockito
                .when(userRepo.findByUsername("admin"))
                .thenReturn(Optional.of(u));

        MockHttpServletRequestBuilder req = MockMvcRequestBuilders
                .post("/api/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(loginReq));

        mock.perform(req)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.name", is("admin")));

    }
}