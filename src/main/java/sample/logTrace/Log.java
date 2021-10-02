package sample.logTrace;
/*
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/*
import org.aspectj.lang.*;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


/**
 *  https://gayerie.dev/docs/spring/spring/aop.html
 */

//@Aspect
//@Component 
public class Log {

	
	/*@Pointcut("within(execution (public * sample.*service*..*(..))")
	public void methodCall() {}

	@Before("execution(public * sample..*(..))")
	public void log(JoinPoint joinPoint){
		System.err.println("calling : " + joinPoint.getTarget().getClass().getName() + " -> " + joinPoint.getSignature().getName());  
    }

	/**
	 * @param joinPoint 
	 * @param exception
	 */
/*	@AfterThrowing(pointcut = "methodCall()", throwing = "e")
	public void log(JoinPoint joinPoint, Throwable exception) {
	  System.out.printf("Retour de %s avec une exception %s%n",
						joinPoint.toShortString(),
						exception.getClass().getSimpleName());
	} */
    
}
