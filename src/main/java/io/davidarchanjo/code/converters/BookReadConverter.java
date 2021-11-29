package io.davidarchanjo.code.converters;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

import io.r2dbc.spi.Row;
import io.davidarchanjo.code.model.Author;
import io.davidarchanjo.code.model.Book;

@ReadingConverter
public class BookReadConverter implements Converter<Row, Book> {

	@Override
	public Book convert(Row source) {
		final Author author = Author.builder()
			.name(source.get("authorName", String.class))
			.id(source.get("authorId", UUID.class))
			.build();
		
		return Book.builder()
			.id(source.get("id", UUID.class))
			.author(author)
			.title(source.get("title", String.class))
			.dateOfParution(source.get("date_of_parution", LocalDate.class))
			.build();
	}

}
