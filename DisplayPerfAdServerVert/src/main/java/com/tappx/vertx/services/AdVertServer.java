package com.tappx.vertx.services;

import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.rxjava.core.eventbus.EventBus;
import io.vertx.rxjava.core.eventbus.Message;
import io.vertx.core.json.JsonObject;
import io.vertx.rxjava.ext.web.Router;
import io.vertx.rxjava.ext.web.handler.ErrorHandler;
import io.vertx.rxjava.ext.web.handler.StaticHandler;

import rx.Single; 



public class AdVertServer extends io.vertx.rxjava.core.AbstractVerticle{
	
	private static final Logger logger = LoggerFactory.getLogger(AdVertServer.class);
	
	
	@Override 
	@SuppressWarnings("deprecation")
	public void start() {
		
		Router router = Router.router(vertx);
		router.route("/adv/:id").handler(
					req->{
						EventBus bus = vertx.eventBus();
						String sizeAdv = (String)req.request().getParam("id");
						
						logger.info("[ADVERTSERVER] query advertisement of size (" + sizeAdv + ")");
						
						Single<JsonObject> obs1 = 
								bus.<JsonObject>rxSend("size", sizeAdv)         
								.map(Message::body);   
						
						obs1.subscribe(response -> req.response().end(response.getString("message")));
					}
				);
		
		router.route().handler(staticHandler());
		router.route().failureHandler(errorHandler());
		
		vertx.createHttpServer().requestHandler(router::accept).listen(8080);
		
	}
	
	
	private ErrorHandler errorHandler() {
        return ErrorHandler.create(true);
    }
	
	private StaticHandler staticHandler() {
        return StaticHandler.create()
            .setCachingEnabled(false);
    }
	

}
