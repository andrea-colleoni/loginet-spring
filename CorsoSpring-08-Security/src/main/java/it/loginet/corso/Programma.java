package it.loginet.corso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

import it.loginet.corso.business.BusinessLogic;
import it.loginet.corso.config.Config;

public class Programma {
	
	@Autowired
	BusinessLogic bl;
	
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		ctx.getBean(Programma.class).avvia();
		ctx.close();
	}

	private void avvia() {
	    // Create new auth token
	    UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken("user", "bbb");

		SecurityContextHolder.getContext().setAuthentication(token);
		
		bl.metodoSicuro();
	}

}
