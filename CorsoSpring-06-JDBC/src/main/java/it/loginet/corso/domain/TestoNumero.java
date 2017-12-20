package it.loginet.corso.domain;

public class TestoNumero {
	
	private int id;
	private String testo;
	private float numero;
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTesto() {
		return testo;
	}
	public void setTesto(String testo) {
		this.testo = testo;
	}
	public float getNumero() {
		return numero;
	}
	public void setNumero(float numero) {
		this.numero = numero;
	}
	@Override
	public String toString() {
		return "TestoNumero [id=" + id + ", testo=" + testo + ", numero=" + numero + "]";
	} 

}
