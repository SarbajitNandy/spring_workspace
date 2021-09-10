package com.infy.utility;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	public static final Log LOGGER = LogFactory.getLog(LoggingAspect.class);
	
	@Autowired
	Environment environment ;

	@AfterThrowing(pointcut = "execution(* com.infy.service.*Impl.*(..))", throwing = "exception")
	public void logServiceException(Exception exception) {
		LOGGER.error(environment.getProperty(exception.getMessage()), exception);
	}

	@AfterThrowing(pointcut = "execution(* com.infy.repository.*Impl.*(..))", throwing = "exception")
	public void logRepositoryException(Exception exception) {
		LOGGER.error(environment.getProperty(exception.getMessage()), exception);
	}
}
