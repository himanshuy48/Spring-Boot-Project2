package com.digi.uniprr.security;

	

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
	@Autowired
    UserDetailsService userDetailsService;
	
	@Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
        auth.authenticationProvider(authenticationProvider());
    }
     
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
     
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }
    
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*");
            }
        };
    }
	
	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * 
	 * http .authorizeRequests() .antMatchers("/login").permitAll()
	 * .antMatchers("/loginByUser").permitAll()
	 * .antMatchers("/sendMailForPassword").permitAll()
	 * .antMatchers("/resources/**").permitAll() //
	 * .antMatchers("/dashboard").access("hasRole('ROLE_Admin')")
	 * //.anyRequest().authenticated() .and() .formLogin() .loginPage("/login") //
	 * .defaultSuccessUrl("/dashboard").permitAll() .and() .logout().permitAll()
	 * .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	 * .invalidateHttpSession(true) .deleteCookies("JSESSIONID") .permitAll() .and()
	 * .csrf().disable(); }
	 */
    
protected void configure(HttpSecurity http) throws Exception {
        
    	http
        	.authorizeRequests()
        		.antMatchers("/login").permitAll()
        		.antMatchers("/loginAuthenticate").permitAll()
        		.antMatchers("/sendMailForPassword").permitAll()
        		.antMatchers("/resources/**").permitAll()
        		//.anyRequest().authenticated()
        	.and()
        	.formLogin()
            	.loginPage("/login")
            	.defaultSuccessUrl("/dashboard").permitAll()
            .and()
            	.logout().permitAll()
                 .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                 .invalidateHttpSession(true)
                 .deleteCookies("JSESSIONID")
                 .permitAll()
            	.and()
            	.csrf().disable();
    }
}
