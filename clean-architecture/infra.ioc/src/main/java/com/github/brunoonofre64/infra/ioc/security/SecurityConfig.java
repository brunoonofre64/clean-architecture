package com.github.brunoonofre64.infra.ioc.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@PropertySource("classpath:application-infraioc.properties")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String ADMIN = "ROLE_ADMIN";
    private static final String CATEGORY_END_POINT = "*/category/**";
    private static final String USER_END_POINT = "*/user/**";
    private static final String PRODUCT_END_POINT = "*/product/**";

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;
    @Value("${jwt.secret}")
    private String jwtSecret;

    public SecurityConfig(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    private static final String[] AUTH_WHITELIST = {
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**",
            "/v3/api-docs/**",
            "/swagger-ui/**",
            "*/h2-console/**",
            "/login"
    };

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(STATELESS);

        http.authorizeHttpRequests()
                .antMatchers(AUTH_WHITELIST).permitAll()
                .and()
                .authorizeHttpRequests()
                .antMatchers(HttpMethod.GET, CATEGORY_END_POINT).permitAll()
                .antMatchers(CATEGORY_END_POINT).hasRole(ADMIN)
                .and()
                .authorizeHttpRequests()
                .antMatchers(HttpMethod.GET, PRODUCT_END_POINT).permitAll()
                .antMatchers(PRODUCT_END_POINT).hasRole(ADMIN)
                .and()
                .authorizeHttpRequests()
                .antMatchers(USER_END_POINT).hasRole(ADMIN);

        http.addFilter(new CustomAuthenticationFilterConfig(this.authenticationManagerBean(), jwtSecret));
        http.addFilterBefore(new CustomAuthorizationFilterConfig(jwtSecret), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
