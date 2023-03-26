package com.scanbuyTest.Scanbuydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.scanbuyTest.Scanbuydemo.controller")
@ComponentScan("com.scanbuyTest.Scanbuydemo.Service")
@ComponentScan("com.scanbuyTest.Scanbuydemo.Service.UserBookDetailsService")

@SpringBootApplication
public class ScanbuydemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScanbuydemoApplication.class, args);
	}

}
