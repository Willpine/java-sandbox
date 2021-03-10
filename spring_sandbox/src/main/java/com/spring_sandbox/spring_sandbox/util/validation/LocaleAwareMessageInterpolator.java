package com.spring_sandbox.spring_sandbox.util.validation;

import java.util.Locale;

import org.hibernate.validator.messageinterpolation.ResourceBundleMessageInterpolator;

import lombok.Getter;

@Getter
public class LocaleAwareMessageInterpolator extends ResourceBundleMessageInterpolator{
    private Locale defaultLocale = Locale.getDefault();
	
	public void setDefaultLocale(Locale defaultLocale) {
		this.defaultLocale = defaultLocale;
		
	}
}
