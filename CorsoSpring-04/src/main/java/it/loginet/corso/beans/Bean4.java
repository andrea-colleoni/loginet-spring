package it.loginet.corso.beans;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

import it.loginet.corso.config.Condizione;

@Component
@Conditional(Condizione.class)
public class Bean4 implements BeanNameAware {

	public void setBeanName(String name) {
		System.out.println(name + " caricato");
	}


}
