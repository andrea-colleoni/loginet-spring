package it.loginet.corso.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import it.loginet.corso.beans.Bean1;

@Configuration
@ComponentScan(basePackageClasses={Bean1.class})
public class Configurazione {
	

}
