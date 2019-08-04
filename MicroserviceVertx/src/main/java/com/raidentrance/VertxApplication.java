/**
 * 
 */
package com.raidentrance;

import com.raidentrance.resources.UserResource;

import io.vertx.core.Vertx;

/**
 * @author raidentrance
 *
 */
public class VertxApplication {
	private VertxApplication() {
	}

	public static void main(String[] args) {
		Vertx vertx = Vertx.vertx();
		vertx.deployVerticle(UserResource.class.getName());
	}
}
