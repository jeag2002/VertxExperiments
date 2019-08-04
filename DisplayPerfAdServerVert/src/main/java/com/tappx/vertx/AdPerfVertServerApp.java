package com.tappx.vertx;

import com.tappx.vertx.services.AdEventBusServer;
import com.tappx.vertx.services.AdVertServer;

import io.vertx.core.Vertx;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

public class AdPerfVertServerApp {
	
		private static final Logger logger = LoggerFactory.getLogger(AdPerfVertServerApp.class);
	
		private static Vertx vertx;
		private  AdPerfVertServerApp() {}
		

		public static void main(String[] args) {
			
			
			
			vertx = Vertx.vertx();
			vertx.deployVerticle(AdVertServer.class.getName());
			vertx.deployVerticle(AdEventBusServer.class.getName());
			
			logger.info("[ADPERFVERTSERVERAPP] server launch listening at 8080 port");
		}

}
