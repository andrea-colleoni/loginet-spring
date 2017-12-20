package it.loginet.corso.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import it.loginet.corso.Programma;
import it.loginet.corso.aspetti.LoggingAspect;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackageClasses = { LoggingAspect.class })
public class Configurazione {

	@Bean
	public Programma programma() {
		return new Programma();
	}
	
//	@Bean
//	public LoggingAspect loggingAspect() {
//		return new LoggingAspect();
//	}

}
