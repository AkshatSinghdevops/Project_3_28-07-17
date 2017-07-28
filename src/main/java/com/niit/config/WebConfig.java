package com.niit.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.niit")
public class WebConfig extends WebMvcConfigurerAdapter    {
	
	
	public void addResourceHandlers(ResourceHandlerRegistry registry)
	{
		 registry.addResourceHandler("/resources/**")
				 .addResourceLocations("/WEB-INF/resources/");
	}
	

}
