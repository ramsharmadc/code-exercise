package com.work.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan(basePackages = { "com.work.spring" })
public class MainClass {
	
	@Autowired
	CircularDependencyA circA;

	public static void main(String[] args) {
		System.out.println("Hello");
	}
}
