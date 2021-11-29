package io.davidarchanjo.code.repositories;

import java.util.UUID;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import io.davidarchanjo.code.model.Book;
import reactor.core.publisher.Flux;

@Repository
public interface BookRepository extends R2dbcRepository<Book, UUID> /*OR ReactiveCrudRepository<Book, UUID>*/ {
	
	@Query("SELECT b.*, a.id AS authorId, a.name AS authorName FROM Book b JOIN Author a ON a.id = b.id_author")
	Flux<Book> findAll();

}
