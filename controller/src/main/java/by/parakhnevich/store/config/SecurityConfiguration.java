package by.parakhnevich.store.config;

import by.parakhnevich.store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .authorizeHttpRequests((requests) ->
                        requests
                                .requestMatchers("/", "/home", "/login", "/css/**", "/resources/**", "/templates/**")
                                .permitAll()
                                .anyRequest()
                                .authenticated())
                .logout((logout) -> logout
                        .permitAll()
                        .logoutSuccessUrl("/home"))
                .formLogin(formLogin -> formLogin
                                .loginPage("/login")
                                .permitAll()
                                .defaultSuccessUrl("/home"))
                .build();
    }

//    @Bean
//    public LogoutSuccessHandler logoutSuccessHandler() {
//        return new RefererRedirectionLogoutSuccessHandler();
//    }

//    @Bean
//    public AuthenticationSuccessHandler authenticationSuccessHandler() {
//        return new RefererRedirectionAuthenticationSuccessHandler();
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
