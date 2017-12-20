package it.loginet.corso.aspetti;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import it.loginet.corso.Programma;

@Aspect
@Component
public class LoggingAspect implements ApplicationContextAware {
	
	private Logger log = Logger.getLogger(LoggingAspect.class.getName());

	@Around("execution(** it.loginet.corso.Programma.metodo(..))")
	public void faiQualcosa(ProceedingJoinPoint joinPoint) throws Throwable {
		Programma p = (Programma)joinPoint.getThis();
		p.setMessaggio(p.getMessaggio() + " => sei passato dall'aspetto!!");
		//log.info("messaggio di log da => " + joinPoint.getSignature().toLongString() + "\n" + p.getMessaggio());
		joinPoint.proceed();
	}
	
	@AfterThrowing(pointcut = "execution(** it.loginet.corso.*.*(..))", throwing= "error")
	public void logEccezione(JoinPoint joinPoint, Throwable error) {
		log.log(Level.SEVERE, "Si è verificata un'eccezione", error);
	}
	

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("caricato aspetto");
		
	}
	
}
