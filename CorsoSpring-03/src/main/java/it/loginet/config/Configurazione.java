package it.loginet.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import it.loginet.beans.Pojo;

@Configuration
public class Configurazione {
	
	@Bean(name= {"nomePojo", "nome2", "nome3"}, initMethod="personalizzato", destroyMethod="distruzione")
	@Qualifier("pojo")
	public Pojo getPojo() {
		Pojo p = new Pojo();
		p.setProprieta("nuova proprietà");
		return p;
	}

}
