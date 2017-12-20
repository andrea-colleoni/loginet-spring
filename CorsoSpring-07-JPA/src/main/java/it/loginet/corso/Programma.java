package it.loginet.corso;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import it.loginet.corso.business.BusinessLogic;
import it.loginet.corso.config.Config;
import it.loginet.corso.entities.Persona;
import it.loginet.corso.repository.PersonaRepository;

public class Programma {

	@Autowired
	PersonaRepository pr;
	
	@Autowired
	private BusinessLogic bl;
	
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		ctx.getBean(Programma.class).streaming();
		ctx.close();
	}
	
	private void streaming() {
		boolean qualcheR = pr.findAllByCustomQueryAndStream().anyMatch(p -> p.getCognome().startsWith("R"));
		System.out.println(qualcheR);
	}

	
	private void transazione() {
		bl.metodo();
	}
	
	private void salva() {
//		Persona p = new Persona();
//		p.setNome("Mario");
//		p.setCognome("Rossi");
//		pr.saveAndFlush(p);
		for(Persona pp : pr.customQueryPersona("Ro"))
			System.out.println(pp);
	}
}
