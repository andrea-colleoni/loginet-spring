package it.loginet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import it.loginet.Programma;
import it.loginet.greet.Saluta;
import it.loginet.greet.SalutoOrarioEng;
import it.loginet.greet.SalutoOrarioEsp;
import it.loginet.greet.SalutoOrarioFra;
import it.loginet.greet.SalutoOrarioIta;

@Configuration
//@Profile("dev")
public class Configurazione {
	
	@Bean
	public Programma programma() {
		return new Programma();
	}
	
	@Bean(name="salutait")
	//@Conditional(CondizioneLingua.class)
	@Italiano
	public Saluta salutaIta() {
		return new SalutoOrarioIta();
	}
	
	@Bean(name="salutaen")
	//@Conditional(CondizioneLingua.class)
	//@Primary
	@English
	public Saluta salutaEng() {
		return new SalutoOrarioEng();
	}
	
	@Bean(name="salutafr") 
	//@Profile("dev")
	public Saluta salutaFra() {
		return new SalutoOrarioFra();
	}
	
	@Bean(name="salutaes")
	//@Profile({"prod", "dev"})
	public Saluta salutaEsp() {
		return new SalutoOrarioEsp();
	}	
	
}
