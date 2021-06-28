package com.CarService.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private DataSource dataSource;

    @Value("${spring.queries.users-query}")
    private String usersQuery;

    @Value("${spring.queries.roles-query}")
    private String rolesQuery;

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.
                jdbcAuthentication()
                .usersByUsernameQuery(usersQuery)
                .authoritiesByUsernameQuery(rolesQuery)
                .dataSource(dataSource)
                .passwordEncoder(bCryptPasswordEncoder);
    }
  
  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  };
  
  @Bean
  public UserDetailsService userDetailsService() {
      return super.userDetailsService();
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
	  
      http.
      authorizeRequests()
      .antMatchers("/").permitAll()
      .antMatchers("/login").permitAll()
      .antMatchers("/registry").permitAll()
      .antMatchers("/activationLink/**").permitAll()
      .anyRequest().authenticated()
      .and().csrf().disable().formLogin()
      .loginPage("/login").failureUrl("/login?error=true")
      .defaultSuccessUrl("/home")
      .usernameParameter("email")
      .passwordParameter("password")
      .and().exceptionHandling()
      .accessDeniedPage("/login");
                        
  }
  
  @Override
  public void configure(WebSecurity web) throws Exception {
      web
         .ignoring()
         .antMatchers("/static/**","/images/**","/css/**");
  }
}
