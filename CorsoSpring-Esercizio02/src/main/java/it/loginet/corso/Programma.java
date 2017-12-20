package it.loginet.corso;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import it.loginet.corso.beans.Automobile;
import it.loginet.corso.config.Configurazione;

public class Programma implements ApplicationContextAware {
	
	private ApplicationContext applicationContext;
	private List<Automobile> automobili;

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(Configurazione.class);
		
		ctx.getBean(Programma.class).avvia();
		
		ctx.close();
	}

	private void avvia() {
		automobili = new ArrayList<Automobile>();
		String[] beanNames = applicationContext.getBeanNamesForType(Automobile.class);
		Random r = new Random();
		int numAutomobili = r.nextInt(20);
		for(int i = 0; i < numAutomobili; i++) {
			int rndIndex = r.nextInt(beanNames.length);
			System.out.println("rndIndex => " + rndIndex);
			Automobile a = applicationContext.getBean(beanNames[rndIndex], Automobile.class);
			a.setCapienza(r.nextInt(80));
			a.setContenutoAttuale(r.nextInt(Math.min(a.getCapienza(), 30)));
			automobili.add(a);
		}
		rifornisci();
	}

	private void rifornisci() {
		Random r = new Random();
		for(Automobile a : automobili) {
			a.rifornisci(r.nextInt(a.getCapienza()));
		}
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

}
