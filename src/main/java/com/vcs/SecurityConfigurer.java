package com.vcs;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
//@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter{

//	private static final AuthenticationFailureHandler authenticationFailureHandler = null;
//
//	private static final LogoutSuccessHandler LogoutSuccessHandler = null;

	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	DataSource dataSource;
	
	private final String USERS_QUERY = "select user_name, password from customer where customer_key=?";
	
	//Fetching and authenticating user supplied credentials with the ones present in the database
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(userDetailsService);
//	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
	
	//security configuration
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
//		http.cors();
//		http.csrf().disable();
//		http.authorizeRequests().antMatchers("/**").fullyAuthenticated().and().httpBasic().and().rememberMe()
//        .rememberMeCookieName("javasampleapproach-remember-me")
//        .tokenValiditySeconds(24 * 60 * 60) // expired time = 1 day
//        .tokenRepository(persistentTokenRepository())
//        .and()
//        .formLogin()
//        .loginPage("/login.html")
//        .loginProcessingUrl("http://localhost:8080/")
//        .and()
//        .logout()
//        .logoutUrl("/perform_logout")
//        .deleteCookies("JSESSIONID");
        
		http.cors();
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/**").fullyAuthenticated().and().httpBasic().and().rememberMe()
        .rememberMeCookieName("javasampleapproach-remember-me")
        .tokenValiditySeconds(24 * 60 * 60) // expired time = 1 day
        .tokenRepository(persistentTokenRepository());
		
		
	}
	
	@Bean
	  public PersistentTokenRepository persistentTokenRepository() {
	        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
	        tokenRepository.setDataSource((javax.sql.DataSource) dataSource);
	        return tokenRepository;
	    }
	
	//For encoding the password
	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}

	
}
