package it.loginet;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import it.loginet.config.ConfigurazioneProgetto2;

public class Progetto2 {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigurazioneProgetto2.class);

		ClasseA a = ctx.getBean(ClasseA.class);
		a.faiQualcosa();
	}

}
