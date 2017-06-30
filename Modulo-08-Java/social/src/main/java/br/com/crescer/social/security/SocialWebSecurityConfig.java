package br.com.crescer.social.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author carloshenrique
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SocialWebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${social.security.public:/health,/usersocial}")
    private String[] securityPublic;

    @Autowired
    private SocialUserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests().antMatchers(GET, securityPublic).permitAll()
                .and()
                .authorizeRequests().antMatchers(POST, "/usersocial/cadastro").permitAll()
                .and()
                .authorizeRequests().antMatchers(POST, "/usersocial/update").permitAll()
                .and()
                .authorizeRequests().anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .logout().logoutUrl("/logout").deleteCookies("JSESSIONID").permitAll()
                .and()
                .cors().disable()
                .csrf().disable();
    }

    @Autowired
    public void setDetailsService(AuthenticationManagerBuilder auth) throws Exception {
        System.out.println("oi");
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
        System.out.println(auth);
    }
}
