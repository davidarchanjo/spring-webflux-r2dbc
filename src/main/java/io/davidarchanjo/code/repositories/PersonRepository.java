package io.davidarchanjo.code.repositories;

import java.util.UUID;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

import io.davidarchanjo.code.model.Person;
import io.davidarchanjo.code.projections.PersonSummary;
import reactor.core.publisher.Flux;

public interface PersonRepository extends R2dbcRepository<Person, UUID> {

	@Query("Select * from Person")
	Flux<PersonSummary> findAllSummary();

}