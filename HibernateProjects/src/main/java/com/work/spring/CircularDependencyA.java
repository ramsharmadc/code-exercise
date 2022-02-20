package com.work.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CircularDependencyA {
	public CircularDependencyB circularDependencyB;

	@Autowired
	public CircularDependencyA(CircularDependencyB circularDependencyB) {
		this.circularDependencyB = circularDependencyB;
	}
}
