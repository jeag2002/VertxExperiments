package com.tappx.vertx.adservices.impl;

import java.util.Optional;
import java.util.Random;

import javax.inject.Singleton;

import com.tappx.vertx.adservices.AdvertisementDispatcher;
import com.tappx.vertx.constant.AdConstant;
import com.tappx.vertx.services.AdVertServer;

import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;


@Singleton
public class ConstantAdvertisementDispatcher implements AdvertisementDispatcher{
	
	
	private static final Logger logger = LoggerFactory.getLogger(AdVertServer.class);
	

	

	public Optional<String> returnAdvertisements(String size) {
		
		String bannerExamples[] = {AdConstant.AdvertisementExample_1_320x50, AdConstant.AdvertisementExample_2_320x50};
		String bannerMRECExamples[] = {AdConstant.AdvertisementExample_1_300x250,AdConstant.AdvertisementExample_2_300x250};
		
		Random r = new Random();
		int index = -1;
		
		
		//BANNER 
		if (size.equalsIgnoreCase(AdConstant.BANNER_SIZE)) {
			
			index = r.nextInt(bannerExamples.length);
			logger.info("[ADVERTISEMENTDISPATCHER] get advertisement (" + index + ") size (" + AdConstant.BANNER_SIZE+ ")");
			return Optional.of(bannerExamples[index]);
			
		//BANNER MREC
		}else if (size.equalsIgnoreCase(AdConstant.BANNER_MREC_SIZE)) {
			
			index = r.nextInt(bannerMRECExamples.length);
			logger.info("[ADVERTISEMENTDISPATCHER] get advertisement (" + index + ") size (" + AdConstant.BANNER_MREC_SIZE+ ")");
			return Optional.of(bannerMRECExamples[index]);
		
		//OTHER SIZE	
		}else {
			return Optional.empty();
		}
		
		
	}

}
