package com.cjh.ex25_branch.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

	@Before ("execution(* com.cjh.ex25_branch.service.*.*(..))")
	public void logBefore(JoinPoint jp) {
		log.info("MMMMMMMMM 메서드 실행전: {} MMMMMMMMM", jp.getSignature());
	}
	
	@AfterReturning(pointcut = "execution(* com.cjh.ex25_branch.service.*.*(..))", returning = "result")
	public void logAfter(JoinPoint jp, Object result) {
		log.info("WWWWW 메서드 실행 성공: {} WWWWW \n WWWWW {} WWWWW", jp.getSignature(), result);
	}
	
}
