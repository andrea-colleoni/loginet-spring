package it.loginet.corso;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import it.loginet.corso.beans.Bean1;
import it.loginet.corso.beans.Bean2;
import it.loginet.corso.beans.Bean3;
import it.loginet.corso.config.Configurazione;

public class Programma {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(Configurazione.class);
		
		ctx.getBean(Bean1.class).metodoChiamante();
		
//		Bean1 b1 = new Bean1();
//		b1.metodoChiamante();
		
		Bean3 b3 = new Bean3();
		b3.metodoBadPractice(new Bean2());
		
		ctx.close();
	}

}
