package it.loginet.corso.beans;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ToyotaAuris extends Automobile {
	
	public ToyotaAuris() {
		super();
		this.marca = "Toyota";
		this.modello = "Auris";
	}
}
