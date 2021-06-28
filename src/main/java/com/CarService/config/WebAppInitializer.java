package com.CarService.config;

import javax.servlet.Filter;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@Configuration
@ComponentScan("com.CarService")
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses(){
		
		return new Class[] {AppConfig.class, WebSecurityConfig.class};
		
	}
	@Override
	protected Class<?>[] getServletConfigClasses(){
		
		return new Class[] {WebConfig.class};
		
	}
	@Override
	protected String[] getServletMappings(){
		
		return new String[] {"/"};
	}
	 @Override
     protected Filter[] getServletFilters() {
       CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
       characterEncodingFilter.setEncoding("UTF-8");
       return new Filter[] { characterEncodingFilter};
     }
}
