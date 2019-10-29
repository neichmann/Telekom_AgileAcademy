package org.javacream.books;

import java.util.HashMap;

import javax.annotation.PostConstruct;

import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class BooksApplication {

	@Autowired BooksService booksService;
	@PostConstruct public void init() {
		try {
			System.out.println(booksService.newBook("Spring", 9.99, new HashMap<String, Object>()));
		} catch (BookException e) {
			e.printStackTrace();
		}
	}
}
