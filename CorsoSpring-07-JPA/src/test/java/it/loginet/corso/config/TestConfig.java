package it.loginet.corso.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import it.loginet.corso.config.Config;

@Configuration
@Import({ Config.class })
public class TestConfig {

}
