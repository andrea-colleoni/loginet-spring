package it.loginet.corso;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import it.loginet.corso.beans.Bean1;
import it.loginet.corso.beans.Bean2;
import it.loginet.corso.beans.Bean3;
import it.loginet.corso.config.Configurazione;

public class ProgrammaScope {
	
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(Configurazione.class);
		
		Bean1 b1_1 = ctx.getBean(Bean1.class);
		Bean1 b1_2 = ctx.getBean(Bean1.class);
		
		b1_1.setValore("1_1");
		b1_2.setValore("1_2");
		
		Bean2 b2_1 = ctx.getBean(Bean2.class);
		Bean2 b2_2 = ctx.getBean(Bean2.class);
		
		b2_1.setValore("2_1");
		b2_2.setValore("2_2");
		
		Bean3 b3_1 = ctx.getBean(Bean3.class);
		Bean3 b3_2 = ctx.getBean(Bean3.class);
		
		b3_1.setValore("3_1");
		b3_2.setValore("3_2");
		
		System.out.println("b1_1: " + b1_1.getValore() + 
				"\nb1_2: " + b1_2.getValore() + 
				"\nb2_1: " + b2_1.getValore() + 
				"\nb2_2: " + b2_2.getValore() + 
				"\nb3_1: " + b3_1.getValore() + 
				"\nb3_2: " + b3_2.getValore());
		
		ctx.close();
	}

}
