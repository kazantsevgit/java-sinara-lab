package com.example.start;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LimitAspect {

    @Autowired
    private AspectConfig aspectConfig;

    @Autowired
    private RequestCounter requestCounter;

    @Pointcut("execution(* com.example.start.controller.ApiController.*(..)))")
    public void apiMethods() {
    }

    @Around("apiMethods()")
    public Object checkLimit(ProceedingJoinPoint joinPoint) throws Throwable {

        String methodName = joinPoint.getSignature().toShortString();
        int currentCount = requestCounter.getCount(methodName);
        requestCounter.increment(methodName);

        if (currentCount >= aspectConfig.getMaxRequests()) {
            log.info("Лимит для метода: ", methodName);
            return null;
        }
        return joinPoint.proceed();
    }
}