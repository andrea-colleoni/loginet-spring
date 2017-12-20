package it.loginet.corso.repository;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.loginet.corso.entities.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {
	
	List<Persona> findByCognome(String cognome);
	
	@Query("select p from Persona p where p.cognome LIKE ?1%")
	List<Persona> customQueryPersona(String cognome);
	
	@Query("select p from Persona p")
	Stream<Persona> findAllByCustomQueryAndStream();

}
