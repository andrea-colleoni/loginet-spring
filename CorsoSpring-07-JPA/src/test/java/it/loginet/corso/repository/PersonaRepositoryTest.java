package it.loginet.corso.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import it.loginet.corso.config.TestConfig;
import it.loginet.corso.entities.Persona;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class })
public class PersonaRepositoryTest {

	@Autowired
	PersonaRepository pr;

	@Test
	public void saveAndFlushTest() {
		Persona p = new Persona();
		p.setCognome("Test Cognome");
		p.setNome("Test Nome");

		pr.saveAndFlush(p);

		Persona s = pr.findById(p.getId()).get();
		assertEquals(p.getNome(), s.getNome());

		pr.delete(s);
	}

}
