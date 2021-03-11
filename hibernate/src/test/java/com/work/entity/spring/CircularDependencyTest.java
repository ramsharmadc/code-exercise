package com.work.entity.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.work.spring.CircularDependencyA;

@RunWith(JUnit4.class)
//@ContextConfiguration(classes = { TestConfig.class })
public class CircularDependencyTest {

	@Test
	public void givenCircularDependency_whenConstructorInjection_thenItFails() {
		// Empty test; we just want the context to load

		ApplicationContext context = new ClassPathXmlApplicationContext();
		context.getBean(CircularDependencyA.class);
	}
}