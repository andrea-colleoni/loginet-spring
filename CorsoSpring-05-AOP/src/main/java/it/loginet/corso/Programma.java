package it.loginet.corso;

//import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import it.loginet.corso.config.Configurazione;

public class Programma {
	
//	private Logger log = Logger.getLogger(Programma.class.getName());
	
	private String messaggio;
	
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(Configurazione.class);
		
		Programma p = ctx.getBean(Programma.class);
		p.setMessaggio("messaggio nel programma");
		p.metodo();
		
		ctx.close();
		
	}
	
	public void metodo() {
		System.out.println("do => " + getMessaggio());
		
		Classe c = new Classe();
		c.metodo(0);
//		log.info("messaggio di log");
	}

	public String getMessaggio() {
		return messaggio;
	}

	public void setMessaggio(String messaggio) {
		this.messaggio = messaggio;
	}

}
