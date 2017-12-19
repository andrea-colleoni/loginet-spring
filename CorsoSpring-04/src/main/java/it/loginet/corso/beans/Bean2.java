package it.loginet.corso.beans;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Bean2 implements BeanNameAware {
	
	private String valore;

	public void metodoChiamato() {
		System.out.println("chiamato");
	}

	public void setBeanName(String name) {
		System.out.println(name + " caricato");
	}

	public String getValore() {
		return valore;
	}

	public void setValore(String valore) {
		this.valore = valore;
	}
}
