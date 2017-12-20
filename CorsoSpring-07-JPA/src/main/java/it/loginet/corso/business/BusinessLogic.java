package it.loginet.corso.business;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.loginet.corso.entities.Persona;
import it.loginet.corso.repository.PersonaRepository;

@Service
public class BusinessLogic {
	
	@Autowired
	PersonaRepository pr;
	
	@Transactional(TxType.NEVER)
	public void metodo() {
		Persona p1 = new Persona();
		p1.setCognome("P1");
		
		pr.saveAndFlush(p1);
		
		if (System.currentTimeMillis() % 2 == 0)
			throw new RuntimeException();
		
		Persona p2 = new Persona();
		p2.setCognome("P2");
		
		pr.saveAndFlush(p2);
	}

}
