package io.davidarchanjo.code.repositories;

import java.util.UUID;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import io.davidarchanjo.code.model.Author;
import reactor.core.publisher.Flux;

@Repository
public interface AuthorRepository extends R2dbcRepository<Author, UUID> {

    @Query("SELECT a.*, b.id AS bookId, b.title AS bookTitle, b.date_of_parution AS bookDateOfParution FROM Author a JOIN Book b ON b.id_author = a.id")
    Flux<Author> findAll();

}
