package it.loginet.greet;

import org.springframework.beans.factory.BeanNameAware;

public class SalutoOrarioEng extends AbstractSalutoOrario {

	public String mattino() {
		return "Good morning";
	}

	public String pomeriggio() {
		return "Good afternoon";
	}

	public String sera() {
		return "Good evening";
	}

	public String notte() {
		return "Good night";
	}

}
