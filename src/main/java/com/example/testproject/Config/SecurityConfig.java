package com.example.testproject.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity // 해당 파일로 시큐리티 활성화
@Configuration // IoC 등록
public class SecurityConfig{

}

