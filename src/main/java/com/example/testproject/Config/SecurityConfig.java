package com.example.testproject.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity // 해당 파일로 시큐리티 활성화
@Configuration // IoC 등록
public class SecurityConfig{

    private static final String[] WHITE_LIST = {
            "/users/**",
            "/**"
    };

        @Bean
        protected SecurityFilterChain config(HttpSecurity http) throws Exception {
            http.csrf().disable();
            http.headers().frameOptions().disable();
            http.authorizeHttpRequests(authorize -> authorize
                    .requestMatchers(WHITE_LIST).permitAll());
            return http.build();
        }
    /*
     * 비밀번호를 데이터베이스에 그대로 저장했을 경우, 데이터베이스가 해킹당하면 고객의 회원 정보가 그대로 노출 된다.
     * 이를 해결하기 위해  BCryptPasswordEncoder의 해쉬 함수를 이용해 비밀번호를 암호화하여 저장
     * BCryptPasswordEncoder를 빈으로 등록하여 사용
     * */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); //usercontroller에 passwordencoder 오류나서 수정
    }


}

