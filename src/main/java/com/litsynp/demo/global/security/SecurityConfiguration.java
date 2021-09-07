package com.litsynp.demo.global.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.headers().frameOptions().sameOrigin(); // x-frame-options 동일 출처일경우만

    http.authorizeRequests().antMatchers("/h2-console/*").permitAll();// H2 URI에 대한 권한 허가

    // CSRF Token 비활성화
    http.csrf().disable();
  }
}
