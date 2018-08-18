package com.example.demo;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.interceptor.PerformanceMonitorInterceptor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PerformanceMonitorConfiguration {

	@Pointcut("execution(* com.example.demo.Greeter.greet(..))")
	public void monitor() {
	}

	@Bean
	public PerformanceMonitorInterceptor performanceMonitorInterceptor() {
		return new PerformanceMonitorInterceptor();
	}

	@Bean
	public Advisor performanceMonitorAdvisor() {
		AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
		pointcut.setExpression("com.example.demo.PerformanceMonitorConfiguration.monitor()");
		return new DefaultPointcutAdvisor(pointcut, performanceMonitorInterceptor());
	}

}