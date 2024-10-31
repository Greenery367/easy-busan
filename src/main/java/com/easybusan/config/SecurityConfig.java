package com.easybusan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorize -> authorize
                .anyRequest().permitAll() // 모든 요청에 대해 인증을 요구하지 않음
            )
            .formLogin(form -> form
                .loginPage("/user/login") // 커스텀 로그인 페이지 경로 설정
                .defaultSuccessUrl("/main")
                .permitAll() // 로그인 페이지 접근에 대해 허용
            )
            .csrf(csrf -> csrf.disable()); // CSRF 보호 비활성화 (개발 중일 때만)

        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
