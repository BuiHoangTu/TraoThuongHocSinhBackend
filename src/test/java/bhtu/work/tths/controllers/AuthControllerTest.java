package bhtu.work.tths.controllers;

import bhtu.work.tths.models.dto.LoginRequest;
import bhtu.work.tths.repositories.mongo.UserRepo;
import bhtu.work.tths.security.jwt.IJwtService;
import bhtu.work.tths.security.services.MyUserDetailsService;
import bhtu.work.tths.services.AuthService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class AuthControllerTest {
    @Container
    private static MongoDBContainer dbContainer = new MongoDBContainer("mongo:4.4.2");

    @Autowired
    private MockMvc mock;
    @Autowired
    private ObjectMapper mapper;
    @MockBean
    private UserRepo userRepo;


    @DynamicPropertySource
    private static void setProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.data.mongodb.uri", dbContainer::getReplicaSetUrl);

    }

    @BeforeEach
    void setUp() {
        try (var x = MockitoAnnotations.openMocks(this)) {

        } catch (Exception e) {
            e.printStackTrace();
        };

        // authService = new AuthService(authenticationManager, userRepo, new BCryptPasswordEncoder(), csrf, new JwtUtils());
    }

    @Test
    void authenticateUser() throws Exception {
        LoginRequest loginReq = new LoginRequest("admin", "admin2");

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