package com.CarService.config;


import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


@Configuration
@EnableWebMvc
@EnableAsync
@ComponentScan(basePackages = "com.CarService")
public class WebConfig implements WebMvcConfigurer {

	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("/static/").setCachePeriod(31556926);
	}

	@Bean
	public InternalResourceViewResolver resolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setContentType("text/html;charset=UTF-8");
		return resolver;
	}
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}
	@Bean
	  public SimpleMailMessage templateSimpleMessage() {
	      SimpleMailMessage message = new SimpleMailMessage();
	      message.setText("Template for email:\n%s\n");
	      return message;
	  }
	  @Bean
	  public JavaMailSender getJavaMailSender() {
	      JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	      mailSender.setHost("smtp.gmail.com");
	      mailSender.setPort(587);
	       
	      mailSender.setUsername("email z którego ma być wysyłana wiadomość");
	      mailSender.setPassword("hasło do podanego wyżej emailu");
	       
	      Properties props = mailSender.getJavaMailProperties();
	      props.put("mail.transport.protocol", "smtp");
	      props.put("mail.smtp.auth", "true");
	      props.put("mail.smtp.starttls.enable", "true");
	      props.put("mail.debug", "true");
	       
	      return mailSender;
	  }
	
}
