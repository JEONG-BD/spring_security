package com.eazy.springsection2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.password.CompromisedPasswordChecker;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.password.HaveIBeenPwnedRestApiPasswordChecker;

import javax.sql.DataSource;

@Configuration
public class ProjectSecurityConfig {


    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
    /* http.authorizeHttpRequests((request)-> request.anyRequest().permitAll());*/
    /* http.authorizeHttpRequests((request)-> request.anyRequest().denyAll());*/
    /* http.authorizeHttpRequests((request)-> request.anyRequest().authenticated());*/
        http.authorizeHttpRequests((request)-> request
                .requestMatchers("/myAccount", "/myBalance", "/myLoans", "myCards").authenticated()
                .requestMatchers("/notices", "/contact", "/error", "/welcome").permitAll());
        /*http.formLogin(httpSecurityFormLoginConfigurer -> httpSecurityFormLoginConfigurer.disable());*/
        /*http.httpBasic(httpSecurityFormLoginConfigurer -> httpSecurityFormLoginConfigurer.disable());*/

        http.formLogin(Customizer.withDefaults());
        http.httpBasic(Customizer.withDefaults());

        return http.build();
    }


//    @Bean
//    public UserDetailsService userDetailsService(){
//       UserDetails user = User.withUsername("user").password("{noop}User@12345").authorities("read").build();
//       //UserDetails admin = User.withUsername("admin").password("{noop}12345").authorities("admin").build();
//       //eazy@54321
//      b UserDetails admin = User.withUsername("admin").password("$2a$12$9RbTyFkznZaMk5sU3MDuJe5vewdUd.jI/hYq5GUY80NBzgcvHWeNW").authorities("admin").build();
//       return new InMemoryUserDetailsManager(user, admin);
//    }


    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public CompromisedPasswordChecker compromisedPasswordChecker(){
        return new HaveIBeenPwnedRestApiPasswordChecker();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
