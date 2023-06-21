package bhtu.work.tths.security;

import bhtu.work.tths.security.jwt.AuthEntryPointJwt;
import bhtu.work.tths.security.jwt.AuthTokenFilter;
import bhtu.work.tths.security.services.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableMethodSecurity
@EnableWebSecurity
// @Order(SecurityProperties.IGNORED_ORDER)
public class ApiSecurityConfig {
    /**
     * define how to encrypt password
     * @return BCryptPasswordEncoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    private final MyUserDetailsService myUserDetailsService;
    private final AuthEntryPointJwt unauthorizedHandler;
    private final AuthTokenFilter authenticationJwtTokenFilter;

    @Autowired
    public ApiSecurityConfig(MyUserDetailsService myUserDetailsService, AuthEntryPointJwt unauthorizedHandler, AuthTokenFilter authenticationJwtTokenFilter) {
        this.myUserDetailsService = myUserDetailsService;
        this.unauthorizedHandler = unauthorizedHandler;
        this.authenticationJwtTokenFilter = authenticationJwtTokenFilter;
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(myUserDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager() {
        var provider = this.authenticationProvider();
        return new ProviderManager(provider);
    }


    @Bean
    @Autowired
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .cors(Customizer.withDefaults()) // allow all diff ports access
                .csrf((httpSecurityCsrfConfigurer) -> httpSecurityCsrfConfigurer.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
                .exceptionHandling((x) -> x.authenticationEntryPoint(unauthorizedHandler))
                .sessionManagement((x) -> x.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests((requests) -> {
                    requests
                            .requestMatchers("/api/open/**", "/api/auth/login", "/api/auth/signup").permitAll() // open, auth apis are for all
                            .requestMatchers("/api/**").authenticated() // any other request to /api must be authenticated first
                            .anyRequest().permitAll(); // non api prefix is not in our control, pass it
                });
//                .formLogin((form) -> form
//                        .loginPage("/login") // map to login page when user want to see something
//                        .permitAll() // Everyone can see login
//                )
//                .httpBasic(Customizer.withDefaults())
//                .userDetailsService(myUserDetailsService) // set in authenticationProvider
//                .logout(LogoutConfigurer::permitAll); // everyone can log out

        http.authenticationProvider(authenticationProvider());

        http.addFilterBefore(authenticationJwtTokenFilter, UsernamePasswordAuthenticationFilter.class);

        return http/*.headers(headers -> {headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin);})*/.build();
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails userDetails =
//                User.withDefaultPasswordEncoder()
//                        .username("user")
//                        .password("password")
//                        .roles("USER")
//                        .build();
//
//        return new InMemoryUserDetailsManager(userDetails);
//    }*/
}
