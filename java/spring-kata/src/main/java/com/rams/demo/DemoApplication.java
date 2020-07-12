package com.rams.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.CountDownLatch;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);

		keepAlive();
	}

	private static void keepAlive() {
		CountDownLatch countDownLatch = new CountDownLatch(1);
		while(countDownLatch.getCount()!=0){

		}
	}

}
