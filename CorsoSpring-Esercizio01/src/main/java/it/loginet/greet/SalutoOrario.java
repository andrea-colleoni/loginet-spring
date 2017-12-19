package it.loginet.greet;

public interface SalutoOrario {

	public static int SOGLIA_MATTINO_POMERIGGIO = 12;
	public static int SOGLIA_POMERIGGIO_SERA = 18;
	public static int SOGLIA_NOTTE_MATTINO = 6;
	public static int SOGLIA_SERA_NOTTE = 24;

	String mattino();

	String pomeriggio();

	String sera();
	
	String notte();

}
