package io.davidarchanjo.code.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.davidarchanjo.code.model.Author;
import io.davidarchanjo.code.repositories.AuthorRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("authors")
@RequiredArgsConstructor
public class AuthorController {
	
	private final AuthorRepository authorRepository;
	
	@GetMapping
	public Flux<Author> findAll() {
		return authorRepository.findAll();
	}

	@PostMapping
	public Mono<Author> create(@RequestBody Author author) {
		return authorRepository.save(author);
	}

}
