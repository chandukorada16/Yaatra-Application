package com.WebClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.WebClient.service.YaatraServiceImpl;

@SpringBootApplication
public class YantraApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(YantraApplication.class, args);
		YaatraServiceImpl bean = context.getBean(YaatraServiceImpl.class);
		bean.getAllTicket();
	}

}
