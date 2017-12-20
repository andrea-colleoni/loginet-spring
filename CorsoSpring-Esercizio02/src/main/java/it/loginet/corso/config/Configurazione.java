package it.loginet.corso.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import it.loginet.corso.Programma;
import it.loginet.corso.SerbatoioFullAspect;
import it.loginet.corso.beans.Automobile;

@Configuration
@ComponentScan(basePackageClasses = { Automobile.class })
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class Configurazione {
	
	@Bean
	public Programma programma() {
		return new Programma();
	}
	
	@Bean
	public SerbatoioFullAspect serbatoioFullAspect() {
		return new SerbatoioFullAspect();
	}

}
