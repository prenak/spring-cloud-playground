package com.xps.stock.fin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class StockYahoonFinApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockYahoonFinApplication.class, args);
	}

}
