package it.loginet;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProgrammaSpring {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		//ApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigurazioneSpring.class);
		
		ClasseA a = ctx.getBean(ClasseA.class);
		
		// wiring manuale
//		Interfaccia i = (Interfaccia)ctx.getBean("beanB");
//		a.setB(i);
		
		a.faiQualcosa();
		
	}

}
