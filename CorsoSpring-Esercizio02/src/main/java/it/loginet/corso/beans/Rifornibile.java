package it.loginet.corso.beans;

public interface Rifornibile {
	
	int getCapienza();
	
	int getContenutoAttuale();
	
	void rifornisci(int quantita);

}
