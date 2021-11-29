package io.davidarchanjo.code.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.davidarchanjo.code.model.Book;
import io.davidarchanjo.code.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("books")
@RequiredArgsConstructor
public class BookController {
	
	private final BookRepository bookRepository;
	
	@GetMapping
	public Flux<Book> findAllBooks() {
		return bookRepository.findAll();
	}

	@PostMapping
	public Mono<Book> createNewBook(@RequestBody Book book) {
		return bookRepository.save(book);
	}
}
