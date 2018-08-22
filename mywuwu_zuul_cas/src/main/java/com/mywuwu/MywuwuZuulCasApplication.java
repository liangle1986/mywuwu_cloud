package com.mywuwu;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Arrays;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
@RestController
@EnableResourceServer
public class MywuwuZuulCasApplication {
    @GetMapping("/")
    public String welcome() {
        return "welcome";
    }

    @GetMapping("/user")
    public Principal user(Principal user) {
        return user;
    }

    public static void main(String[] args) {
        SpringApplication.run(MywuwuZuulCasApplication.class, args);
    }


    @Component
    @EnableOAuth2Sso // 实现基于OAuth2的单点登录，建议跟踪进代码阅读以下该注解的注释，很有用
    public static class SecurityConfiguration extends WebSecurityConfigurerAdapter {
        @Override
        public void configure(HttpSecurity http) throws Exception {
            http.
                    antMatcher("/**")
                    // 所有请求都得经过认证和授权
                    .authorizeRequests().anyRequest().authenticated()
                     .and().authorizeRequests().antMatchers("/", "/anon").permitAll()
                    .and()
                    // 这里之所以要禁用csrf，是为了方便。
                    // 否则，退出链接必须要发送一个post请求，请求还得带csrf token
                    // 那样我还得写一个界面，发送post请求
                    .csrf().disable()
                    // 退出的URL是/logout
                    .logout().logoutUrl("/logout").permitAll()
                    // 退出成功后，跳转到/路径。
                    .logoutSuccessUrl("/login");
        }

  /*      @Bean
        public OAuth2ProtectedResourceDetails bnetResource() {
            AuthorizationCodeResourceDetails resource = new AuthorizationCodeResourceDetails();
            resource.setId("mywuwu");
            resource.setClientId("8ebb54316fa55103b5f5");
            resource.setClientSecret("f4cb630754022200eadecd7b8c5be7f06bf071c4");
            resource.setAccessTokenUri("https://github.com/login/oauth/access_token");
            resource.setUserAuthorizationUri("https://github.com/login/oauth/access_token");
            resource.setScope(Arrays.asList("https://api.github.com/user"));
            return resource;
        }*/
    }


}
