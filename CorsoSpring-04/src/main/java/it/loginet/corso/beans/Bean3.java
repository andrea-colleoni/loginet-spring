package it.loginet.corso.beans;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

@Component
public class Bean3 implements BeanNameAware {
	
	private String valore;
	
	public String getValore() {
		return valore;
	}

	public void setValore(String valore) {
		this.valore = valore;
	}

	public void metodoBadPractice(Bean2 b2) {
		b2.metodoChiamato();
	}

	public void setBeanName(String name) {
		System.out.println(name + " caricato");
	}


}
