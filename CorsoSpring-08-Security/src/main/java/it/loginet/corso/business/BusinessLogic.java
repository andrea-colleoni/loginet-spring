package it.loginet.corso.business;

import org.springframework.context.annotation.Role;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

@Service
public class BusinessLogic {
	
	@Secured({ "ROLE_ADMIN" })
	public void metodoSicuro() {
		System.out.println("sei arrivato qui!");
	}

}
