package it.loginet;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import it.loginet.config.Configurazione;
import it.loginet.config.English;
import it.loginet.config.Italiano;
import it.loginet.greet.Saluta;

public class Programma {
	
	
	@Autowired
	@English
	private Saluta s;

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(Configurazione.class);
		
		//Saluta s = ctx.getBean("saluta" + Locale.getDefault().getLanguage(), Saluta.class);
		ctx.getBean(Programma.class).avvia();
		
		ctx.close();
	}
	
	void avvia() {
		System.out.println(s.saluta());
	}
}
