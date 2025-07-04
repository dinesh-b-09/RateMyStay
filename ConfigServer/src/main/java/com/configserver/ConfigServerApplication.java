package com.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;


@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApplication.class, args);
	}

    //	http://192.168.31.53:8094/aplication/prod
    // http://192.168.31.53:8094/aplication/default
	// http://192.168.31.53:8094/aplication/dev
}
