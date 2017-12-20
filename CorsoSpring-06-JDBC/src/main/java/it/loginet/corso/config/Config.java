package it.loginet.corso.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import it.loginet.corso.Programma;

@Configuration
public class Config {
	
	@Bean
	public Programma programma() {
		return new Programma();
	}
	
	//@Bean
	public DataSource dataSource() {
//		BasicDataSource bds = new BasicDataSource();
//		bds.setDriverClassName("org.apache.derby.jdbc.EmbeddedDriver");
//		bds.setUrl("jdbc:derby:C:/db/miodb?create=true");
//		
//		// pool
//		bds.setMaxTotal(1);
//		bds.setInitialSize(1);
//		return bds;
		
		DriverManagerDataSource dmds = new DriverManagerDataSource();
		dmds.setDriverClassName("org.apache.derby.jdbc.EmbeddedDriver");
		dmds.setUrl("jdbc:derby:C:/db/miodb");
		
		Properties connectionProperties = new Properties();
		connectionProperties.setProperty("create", "true");
		dmds.setConnectionProperties(connectionProperties );
		return dmds;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}
}
