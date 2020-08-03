package com.example.userservice.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Configuration
@Slf4j
public class LoggingAspect {

	@Pointcut("execution(* com.example.userservice.service..*.* (..)) || execution(* com.example.userservice.controller.*.* (..)) || execution(* com.example.userservice.dao..*.* (..))")
	protected void loggingOperation() {
	}

	@Around("loggingOperation()")
	public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		log.info("Entering..." + joinPoint.getSignature().getDeclaringTypeName() + "."
				+ joinPoint.getSignature().getName());
		try {
			return joinPoint.proceed();
		} finally {
			log.info("Exiting..." + joinPoint.getSignature().getDeclaringTypeName() + "."
					+ joinPoint.getSignature().getName());
		}

	}

}