package com.work.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CircularDependencyB {

	public CircularDependencyA circularDependencyA;

	@Autowired
	public CircularDependencyB(CircularDependencyA circularDependencyA) {
		this.circularDependencyA = circularDependencyA;
	}
}
