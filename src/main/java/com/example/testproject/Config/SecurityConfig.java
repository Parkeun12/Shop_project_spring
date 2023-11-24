package com.example.testproject.Config;

import com.example.testproject.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity // 해당 파일로 시큐리티 활성화
@Configuration // IoC 등록
@RequiredArgsConstructor
public class SecurityConfig {
    @Autowired
    UserService userService;

//    resouces를 접근할수 있도록 빈 추가
//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return (web) -> web.ignoring()
//                .requestMatchers(PathRequest.toStaticResources().atCommonLocations());
//    }
    //회원가입 시 필요한 bean
    //    csrf : 로컬에서 확인을 위해 csrf를 비활성화
    //    /(홈), /users/login(로그인 페이지), /users/new(회원가입 페이지)는 로그인 없이 접근하도록 셋팅
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .httpBasic().disable()//기본 ui 사용, 사용하지 않을 시 disable()
                .csrf().disable()//REST API에서 csrf 보안이 필요없기 때문에 비활성화,
                .cors().and()
                .authorizeRequests()// 요청에 대한 사용 권한을 체크

                //css나 img 적용 안될 때 확인하기
                //antMatchers 파라미터로 설정한 리소스 접근을 인증절차 없이 허용
                .requestMatchers("/","/users/login","/users/new","/js/**", "/css/**", "/img/**").permitAll()

                .anyRequest().authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)//STATELESS로 설정함으로서 인증 정보를 서버에 담아두지 않음,JWT 토큰을 사용할 것이기 때문
                .and()
                .build();
    }
    //로그인 시 필요한 bean
    //    formLogin : /users/login 페이지를 커스터마이징 하여 로그인 체크를 할때 해당 url을 타도록 셋팅하고 로그인 성공시 /(메인페이지)로 페이지 이동, 로그인 실패시 /user/login/error
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.formLogin()
                .loginPage("/users/login") //로그인페이지 URL
                .defaultSuccessUrl("/",true) //로그인 성공시 이동할 페이지
                .usernameParameter("userId") // 로그인시 사용할 파라미터 이름 설정
                .failureUrl("/user/login/error") // 로그인 실패시 이동할 URL
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))//로그아웃 URL
                .logoutSuccessUrl("/"); //로그아웃 성공시 URL

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

