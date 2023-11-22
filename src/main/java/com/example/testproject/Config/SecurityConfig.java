package com.example.testproject.Config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity // 해당 파일로 시큐리티 활성화
@Configuration // IoC 등록
@RequiredArgsConstructor
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .httpBasic().disable()//기본 ui 사용, 사용하지 않을 시 disable()
                .csrf().disable()//REST API에서 csrf 보안이 필요없기 때문에 비활성화,
                .cors().and()
                .authorizeRequests()// 요청에 대한 사용 권한을 체크
                .requestMatchers("/api/**").permitAll()//antMatchers 파라미터로 설정한 리소스 접근을 인증절차 없이 허용
                .requestMatchers("/users/join", "/users/login").permitAll()//requestMatchers 파라미터로 설정한 리소스 접근을 인증절차 없이 허용
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)//STATELESS로 설정함으로서 인증 정보를 서버에 담아두지 않음,JWT 토큰을 사용할 것이기 때문
                .and()
                .build();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{


        return http.build();
    }


    /*
     * 비밀번호를 데이터베이스에 그대로 저장했을 경우, 데이터베이스가 해킹당하면 고객의 회원 정보가 그대로 노출 된다.
     * 이를 해결하기 위해  BCryptPasswordEncoder의 해쉬 함수를 이용해 비밀번호를 암호화하여 저장
     * BCryptPasswordEncoder를 빈으로 등록하여 사용
     * */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();

    }

}

