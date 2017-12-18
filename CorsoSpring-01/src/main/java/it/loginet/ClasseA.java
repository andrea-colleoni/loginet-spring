package it.loginet;

public class ClasseA {
	
	private Interfaccia b;


	public ClasseA() {
		super();
	}

	public ClasseA(Interfaccia b) {
		super();
		this.b = b;
	}

	public Interfaccia getB() {
		return b;
	}

	public void setB(Interfaccia b) {
		this.b = b;
	}
	
	public void faiQualcosa() {
		b.mB();
	}

}
