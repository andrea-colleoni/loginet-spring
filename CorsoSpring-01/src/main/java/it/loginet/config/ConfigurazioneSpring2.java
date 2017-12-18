package it.loginet.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import it.loginet.ClasseC;

@Configuration
public class ConfigurazioneSpring2 {

	@Bean
	public ClasseC getClasseC() {
		return new ClasseC();
	}
	

}
