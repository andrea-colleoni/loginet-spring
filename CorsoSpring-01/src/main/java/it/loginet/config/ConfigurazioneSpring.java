package it.loginet.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

import it.loginet.ClasseA;
import it.loginet.ClasseB;

@Configuration
//@ImportResource({"beans2.xml", "beans.xml"})
public class ConfigurazioneSpring {
	
	@Bean
	@Qualifier("beanB")
	public ClasseB getBeanB() {
		return new ClasseB();
	}
	
	@Bean
	public ClasseA getClasseA() {
		return new ClasseA(getBeanB());
	}
}
