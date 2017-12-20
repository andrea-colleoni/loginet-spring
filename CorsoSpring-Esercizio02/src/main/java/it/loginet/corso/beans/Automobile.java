package it.loginet.corso.beans;

import org.springframework.beans.factory.BeanNameAware;

public abstract class Automobile implements Rifornibile, BeanNameAware {
	
	private int capienza;
	private int contenutoAttuale;
	
	protected String marca;
	protected String modello;
	
	public Automobile() {
		super();
	}

	public int getCapienza() {
		return this.capienza;
	}

	public int getContenutoAttuale() {
		return this.contenutoAttuale;
	}

	public void rifornisci(int quantita) {
		this.contenutoAttuale += quantita;
	}
	
	public void setBeanName(String name) {
		System.out.println(name + " => caricato.");
	}

	public void setCapienza(int capienza) {
		this.capienza = capienza;
	}

	public void setContenutoAttuale(int contenutoAttuale) {
		this.contenutoAttuale = contenutoAttuale;
	}

	@Override
	public String toString() {
		return "Automobile [capienza=" + capienza + ", contenutoAttuale=" + contenutoAttuale + ", marca=" + marca
				+ ", modello=" + modello + "]";
	}

}
