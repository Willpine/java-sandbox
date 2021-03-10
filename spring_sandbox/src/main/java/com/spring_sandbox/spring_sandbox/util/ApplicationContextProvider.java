package com.spring_sandbox.spring_sandbox.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.validation.beanvalidation.SpringConstraintValidatorFactory;
//@SuppressWarnings("all")
@Component
public class ApplicationContextProvider implements ApplicationContextAware {

    private static ApplicationContext context;

	@Override
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		ApplicationContextProvider.context = context;
	}
	
	public static SpringConstraintValidatorFactory getValidatorFactory() {
		
		AutowireCapableBeanFactory autowiredCapable =
				ApplicationContextProvider
				.context
				.getAutowireCapableBeanFactory();
		
		return new SpringConstraintValidatorFactory(autowiredCapable);
	}
    
}
