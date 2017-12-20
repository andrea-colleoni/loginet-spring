package it.loginet.corso.beans;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BmwX5 extends Automobile {
	
	public BmwX5() {
		super();
		this.marca = "BMW";
		this.modello = "X5";
	}

}
