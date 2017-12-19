package it.loginet.corso.beans;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("pippo") // nome del bean
@Scope(scopeName=ConfigurableBeanFactory.SCOPE_SINGLETON)
public class Bean1 implements BeanNameAware {
	
	@Autowired
	//@Qualifier("pippo") ricerca di un Bean per nome
	private Bean2 b2;
	
	@Autowired(required=false)
	private Bean3 b3;
	
	private String valore;

	public void metodoChiamante() {
		b2.metodoChiamato();
		if (b3 != null)
			b3.metodoBadPractice(b2);
		else 
			System.out.println("attualmente b3 non disponibile");
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
