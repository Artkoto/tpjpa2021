package fr.istic.taa.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;


@Aspect
@Component
public class ServiceMonitor {
    private static final Logger log = Logger.getLogger(ServiceMonitor.class.getPackage().getName());

    @AfterReturning("execution(* fr.istic.taa.controller.*.*(..))")
    public void logServiceRestAccess(JoinPoint joinPoint) {
        log.info("Completed: "+ joinPoint);
    }
}
