package it.loginet.corso.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import it.loginet.corso.Programma;

@EnableTransactionManagement
@Configuration
@EnableJpaRepositories(basePackages = { "it.loginet.corso.repository" })
@ComponentScan(basePackages = { "it.loginet.corso.business" })
public class Config {

	@Bean
	public Programma programma() {
		return new Programma();
	}

	// @Bean
	public DataSource dataSource() {
		DriverManagerDataSource dmds = new DriverManagerDataSource();
		dmds.setDriverClassName("org.apache.derby.jdbc.EmbeddedDriver");
		dmds.setUrl("jdbc:derby:C:/db/miodb");

		Properties connectionProperties = new Properties();
		connectionProperties.setProperty("create", "true");
		dmds.setConnectionProperties(connectionProperties);
		return dmds;
	}

	@Bean(name = "entityManagerFactory") // il nome è importante per far funzionare JpaRepository
	public LocalContainerEntityManagerFactoryBean emf() {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(dataSource());
		emf.setJpaVendorAdapter(jpaVendorAdapter());
		emf.setPackagesToScan("it.loginet.corso.entities");
		return emf;
	}

	private JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter ja = new HibernateJpaVendorAdapter();
		ja.setDatabase(Database.DERBY);
		ja.setGenerateDdl(true);
		ja.setShowSql(true);
		return ja;
	}

	@Bean(name = "transactionManager") // il nome è importante per far funzionare JpaRepository
	public PlatformTransactionManager jpaTM() {
		JpaTransactionManager jt = new JpaTransactionManager();
		jt.setDataSource(dataSource());
		jt.setEntityManagerFactory(emf().getObject());
		return jt;
	}

}
