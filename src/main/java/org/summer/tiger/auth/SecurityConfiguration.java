package org.summer.tiger.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 *  參考資料: https://medium.com/@yohanesdwikiwitman/spring-boot-3-template-part-4-configuring-spring-security-72572a60d18b
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfiguration {


    /**
     * 初始化 JWT 過濾器.
     *
     * @return
     */
    @Bean
    public JWTFilter securityFilter() {
        return new JWTFilter();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.cors(Customizer.withDefaults());   //跨域設置 使用默認

        // csrf 攻擊
        httpSecurity.csrf(csrf -> csrf.disable());

        // 不通過 session 拿 session context
        httpSecurity.sessionManagement(configurer -> configurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        httpSecurity.authorizeHttpRequests(matcherRegistry -> matcherRegistry.requestMatchers(
                "/security/dont"
        ).permitAll().anyRequest().authenticated());


        //註冊 jwt 過濾器
        httpSecurity.addFilterBefore(new JWTFilter(), UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();
    }
}
