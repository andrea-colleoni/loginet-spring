package it.loginet.corso.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

import it.loginet.corso.Programma;
import it.loginet.corso.business.BusinessLogic;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
@ComponentScan(basePackageClasses = { BusinessLogic.class })
public class Config extends GlobalMethodSecurityConfiguration {

	@Bean
	public Programma programma() {
		return new Programma();
	}

	@Bean
	public static PasswordEncoder passwordEncoder() {
		String idForEncode = "bcrypt";
		Map encoders = new HashMap<>();
		encoders.put(idForEncode, new BCryptPasswordEncoder());
		encoders.put("pbkdf2", new Pbkdf2PasswordEncoder());
		encoders.put("scrypt", new SCryptPasswordEncoder());

		PasswordEncoder passwordEncoder = new DelegatingPasswordEncoder(idForEncode, encoders);
		return passwordEncoder;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
		grantedAuths.add(new SimpleGrantedAuthority("ROLE_UTENTE"));

	    String result = passwordEncoder().encode("bbb");
	    
		User user = new User("user", result, grantedAuths);

		auth.inMemoryAuthentication().passwordEncoder(passwordEncoder()).withUser(user);
		//auth.jdbcAuthentication().usersByUsernameQuery("select username, password from user where username=?");
	}

}
