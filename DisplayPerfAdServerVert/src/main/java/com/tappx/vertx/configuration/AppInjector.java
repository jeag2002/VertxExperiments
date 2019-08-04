package com.tappx.vertx.configuration;

import com.google.inject.AbstractModule;
import com.tappx.vertx.adservices.AdvertisementDispatcher;
import com.tappx.vertx.adservices.impl.ConstantAdvertisementDispatcher;

public class AppInjector extends AbstractModule {

	@Override
	protected void configure() {
		//bind the service to implementation class
		//bind(MessageService.class).to(EmailService.class);
		
		//bind MessageService to Facebook Message implementation
		bind(AdvertisementDispatcher.class).to(ConstantAdvertisementDispatcher.class);
		
	}

}