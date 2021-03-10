package com.spring_sandbox.spring_sandbox.util.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer{
    @Override
	public void addArgumentResolvers(
		List<HandlerMethodArgumentResolver> resolvers) {
		
		PageableHandlerMethodArgumentResolver pageableResolver =
				new PageableHandlerMethodArgumentResolver();
		
		pageableResolver
			.setFallbackPageable(PageRequest.of(0,  10));
		
		resolvers.add(pageableResolver);
	}
}
