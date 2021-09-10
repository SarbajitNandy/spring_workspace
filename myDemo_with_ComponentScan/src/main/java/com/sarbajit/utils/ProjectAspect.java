package com.sarbajit.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ProjectAspect {
	
	private static Logger logger = LoggerFactory.getLogger(ProjectAspect.class);
	
//	@AfterReturning(pointcut = "execution( int com.sarbajit.service.EmployeeService.remove(..))", returning="rval")
//	public void checkRemoveFromService(JoinPoint j, int rval) {
//		if (rval<0) {
//			logger.info("Employee Id " + (-rval) + " doesn't exists");
//		} else {
//			logger.info("Employee Id " + (+rval) + " sucessfully removed");
//		}
//	}
//	
//	@AfterReturning(pointcut = "execution( int com.sarbajit.service.EmployeeService.insert(..))", returning="rval")
//	public void checkInsertFromService(JoinPoint j, int rval) {
//		logger.info("Employee Id " + rval + " sucessfully inserted");
//	}
	
	@AfterReturning(pointcut="execution( * com.sarbajit.service.EmployeeService.*(..))", returning="rval")
	public void loggingAdvice(JoinPoint j, int rval) {
		logger.info("Getting Return value" + rval);
	}
}
