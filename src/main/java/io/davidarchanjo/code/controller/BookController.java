package io.davidarchanjo.code.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import io.davidarchanjo.code.model.Book;
import io.davidarchanjo.code.repositories.BookRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("books")
@RequiredArgsConstructor
public class BookController {
	
	private final BookRepository bookRepository;
	
	@GetMapping
	public Flux<Book> findAllBooks() {
		Flux<Book> body = bookRepository.findAll();
		return body;
	}

	@PostMapping
	public Mono<Book> createNewBook(@RequestBody Book book) {
		return bookRepository.save(book);
	}
}
