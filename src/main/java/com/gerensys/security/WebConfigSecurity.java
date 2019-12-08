package com.gerensys.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebConfigSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    private ImplementacaoUserDetailsService implementacaoUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/**").permitAll()
                //.antMatchers(HttpMethod.GET, "/cadastrofuncionarios").hasAnyRole("ADMINISTRATIVO")
                .anyRequest().authenticated()
                .and().formLogin().permitAll()
                .and().logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(implementacaoUserDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder());

        /*auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("gledson")
                .password("$2a$10$R53iHqdNGnKk.2ajlz2HSePmk4DUUI.an0vig4JD55EyBe3spDr46")
                .roles("ADMIN");*/
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**", "/js/**", "/scss/**", "/vendor/**");
    }
}
