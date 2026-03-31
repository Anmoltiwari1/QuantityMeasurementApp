package com.example.UC18.Authentication.security;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
 
@Configuration
@EnableWebSecurity
public class SecurityConfig {
 
    private final JwtAuthFilter jwtAuthFilter;
    private final UserDetailsServiceImpl userDetailsService;
    private final OAuth2SuccessHandler oAuth2SuccessHandler;
 
    public SecurityConfig(
            JwtAuthFilter jwtAuthFilter,
            UserDetailsServiceImpl userDetailsService,
            OAuth2SuccessHandler oAuth2SuccessHandler
    ) {
        this.jwtAuthFilter = jwtAuthFilter;
        this.userDetailsService = userDetailsService;
        this.oAuth2SuccessHandler = oAuth2SuccessHandler;
    }
 
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // ── CSRF: disable for stateless REST API ─────────────────────────
            .csrf(csrf -> csrf.disable())
 
            // ── H2 console needs frames (dev only — remove in prod) ──────────
            .headers(headers -> headers.frameOptions(fo -> fo.disable()))
 
            // ── Route permissions ─────────────────────────────────────────────
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                		"/auth/**",
                        "/login",
                        "/oauth2/**",                    // ← add this
                        "/login/oauth2/code/**",         // ← add this
                        "/h2-console/**"   // H2 browser (dev only)
                ).permitAll()
                .requestMatchers("/api/**").authenticated()
                .anyRequest().authenticated()
            )
 
            // ── Return 401 JSON for /api/** instead of redirecting to Google ──
            // Without this, Spring Security's default behavior redirects any
            // unauthenticated request to the OAuth2 login page (Google).
            // This entry point intercepts that and returns a clean JSON 401
            // so Postman/React/mobile clients get a proper error, not HTML.
            .exceptionHandling(ex -> ex
            	    .authenticationEntryPoint((request, response, authException) -> {
            	        String path = request.getRequestURI();

            	        // Only return JSON 401 for API calls
            	        // For everything else (OAuth2 flow), let Spring handle it normally
            	        if (path.startsWith("/api/")) {
            	            response.setContentType("application/json");
            	            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            	            response.getWriter().write(
            	                "{\"error\": \"Unauthorized - provide a valid Bearer token\"}"
            	            );
            	        } else {
            	            // Let Spring Security's default handling take over
            	            // This allows the OAuth2 redirect flow to work normally
            	            response.sendRedirect("/oauth2/authorization/github");
            	        }
            	    })
            	)
 
            // ── Session: STATELESS — no HttpSession, token carries the state ──
            .sessionManagement(session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )
 
            // ── OAuth2 Login (Google) ─────────────────────────────────────────
            .oauth2Login(oauth2 -> oauth2
                .successHandler(oAuth2SuccessHandler)
            )
 
            // ── Plug in our JWT filter BEFORE Spring's default auth filter ────
            .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
 
        return http.build();
    }
 
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
 
    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration config
    ) throws Exception {
        return config.getAuthenticationManager();
    }
}