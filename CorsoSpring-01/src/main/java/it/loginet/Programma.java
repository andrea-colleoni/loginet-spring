package it.loginet;

public class Programma {

	public static void main(String[] args) {
		ClasseA a = new ClasseA();
		a.setB(new ClasseB());  // wiring
		a.faiQualcosa();
	}

}
