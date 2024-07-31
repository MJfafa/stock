package com.kakaopay.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Around("execution(* com.kakaopay.controller..*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("Entering in Method :  " + joinPoint.getSignature().getName());
        logger.info("Class Name :  " + joinPoint.getSignature().getDeclaringTypeName());
        logger.info("Arguments :  " + java.util.Arrays.toString(joinPoint.getArgs()));
        logger.info("Target class : " + joinPoint.getTarget().getClass().getName());

        Object result = null;
        try {
            result = joinPoint.proceed();
            logger.info("Method Return value : " + result);
        } catch (IllegalArgumentException e) {
            logger.error("Illegal argument: " + java.util.Arrays.toString(joinPoint.getArgs()) + " in " + joinPoint.getSignature().getName());
            throw e;
        }
        return result;
    }
}
