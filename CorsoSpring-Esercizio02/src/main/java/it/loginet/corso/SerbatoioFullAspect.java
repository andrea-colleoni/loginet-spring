package it.loginet.corso;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import it.loginet.corso.beans.Automobile;

@Aspect
public class SerbatoioFullAspect {

	@Around("execution(** it.loginet.corso.beans.Automobile.rifornisci(int))"
			+ " && args(quantita)")
	public void verificaRifornimento(ProceedingJoinPoint jpc, int quantita) throws Throwable {
		System.out.println("riforminento di => " + quantita);
		Automobile a = (Automobile)jpc.getThis();
		if (a.getCapienza() - a.getContenutoAttuale() < quantita)
			System.err.println("\neccesso di rifornimento");
		else
			jpc.proceed();
	}
}
