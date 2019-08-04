package com.tappx.vertx.services;



import javax.inject.Inject;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.tappx.vertx.adservices.AdvertisementDispatcher;
import com.tappx.vertx.adservices.impl.AdvertisementException;
import com.tappx.vertx.configuration.AppInjector;
import com.tappx.vertx.constant.AdConstant;

import io.vertx.core.json.JsonObject;


public class AdEventBusServer extends io.vertx.rxjava.core.AbstractVerticle{
	
	@Inject
	private AdvertisementDispatcher aDispatcher;
	
	
	@Override 
	@SuppressWarnings("deprecation")
	public void start() {  
		
		  vertx.eventBus().<String>consumer("size", message -> {        
			  
			  JsonObject json = new JsonObject();   
			  
			  String size = "";
			  String data = "";
			  
			  if (message.body().isEmpty()) {
				 size = AdConstant.BANNER_SIZE;
			  }else {
				  size = message.body();
			  }
			  
			  Injector injector = Guice.createInjector(new AppInjector());		
				
			  aDispatcher = injector.getInstance(AdvertisementDispatcher.class);
			  
			  
			  
			  
			  try {
				  data = aDispatcher.returnAdvertisements(size).orElseThrow(()->new AdvertisementException("size not found"));
			  }catch(Exception e) {
				  data = e.getMessage();
			  }
					  
			  
			  message.reply(json.put("message",data));
			  
			  
			  }
		  ); 
	
	}
	
}
