package com.mallycrip.rank.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {
    private final JwtProvider jwtProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .sessionManagement().disable()
                .formLogin().disable()
                .cors().and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST,"/account").permitAll()
                .antMatchers(HttpMethod.POST,"/account/email").permitAll()
                .antMatchers(HttpMethod.GET, "/rank").permitAll()
                .antMatchers(HttpMethod.POST, "/auth").permitAll()
                .antMatchers(HttpMethod.GET, "/account").permitAll()
                .and()
                .apply(new JwtConfigure(jwtProvider));
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*");
    }
}
