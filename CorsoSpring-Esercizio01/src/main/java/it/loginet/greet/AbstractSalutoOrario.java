package it.loginet.greet;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.BeanNameAware;

public abstract class AbstractSalutoOrario implements Saluta, SalutoOrario, BeanNameAware {

	public String saluta() {
		Calendar c = new GregorianCalendar();
		int h = c.get(Calendar.HOUR_OF_DAY);
		
		if (h >= SOGLIA_MATTINO_POMERIGGIO && h < SOGLIA_POMERIGGIO_SERA) {
			return pomeriggio();
		} else if (h >= SOGLIA_SERA_NOTTE && h < SOGLIA_NOTTE_MATTINO) {
			return notte();
		} else if (h >= SOGLIA_NOTTE_MATTINO && h < SOGLIA_MATTINO_POMERIGGIO) {
			return mattino();
		} else {
			return sera();
		}
	}

	public void setBeanName(String name) {
		System.out.println(name + " caricato.");
	}
	
}
