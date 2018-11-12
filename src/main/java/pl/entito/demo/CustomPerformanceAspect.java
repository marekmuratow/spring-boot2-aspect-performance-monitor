package pl.entito.demo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CustomPerformanceAspect {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Pointcut("execution(* pl.entito.demo.GreeterService.greet(..))")
	public void greetPointcut() {
	}

	@Before("greetPointcut()")
	public void before() {

		logger.info("Aspect message BEFORE a method ");
	}

	@After("greetPointcut()")
	public void after() {

		logger.info("Aspect message AFTER a method");
	}

	@Around("greetPointcut()")
	public void around(ProceedingJoinPoint joinPoint) {

		try {
			long startTime = System.currentTimeMillis();
			logger.info("Aspect message AROUND before proceed");
			joinPoint.proceed();
			long endTime = System.currentTimeMillis();
			logger.info("Aspect message AROUND after proceed " + joinPoint.getSignature().toShortString()
					+ " executed in: " + (endTime - startTime) + " ms");
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

}
