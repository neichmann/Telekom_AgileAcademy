package org.javacream.books;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.Comic;
import org.javacream.books.warehouse.api.HistoryBook;
import org.javacream.books.warehouse.api.SchoolBook;
import org.javacream.books.warehouse.api.SpecialistBook;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class BooksTestConfiguration {

	@Bean
	@Qualifier("generatorsMap")
	public Map<Set<String>, Function<Map<String, Object>, Book>> generatorsMap() {
		Map<Set<String>, Function<Map<String, Object>, Book>> generators = new HashMap<>();
		HashSet<String> booksKeySet = new HashSet<>();
		generators.put(booksKeySet, (Map<String, Object> options) -> {
			Book book = new Book();
			return book;
		});

		HashSet<String> schoolBooksKeySet = new HashSet<>(booksKeySet);
		schoolBooksKeySet.add("subject");
		schoolBooksKeySet.add("year");
		generators.put(schoolBooksKeySet, (Map<String, Object> options) -> {
			SchoolBook book = new SchoolBook();
			book.setSubject((String) options.get("subject"));
			book.setYear((Integer) options.get("year"));
			return book;
		});
		HashSet<String> specialistBooksKeySet = new HashSet<>(booksKeySet);
		specialistBooksKeySet.add("topic");
		generators.put(specialistBooksKeySet, (Map<String, Object> options) -> {
			SpecialistBook book = new SpecialistBook();
			book.setTopic((String) options.get("topic"));
			return book;
		});

		HashSet<String> comics = new HashSet<>();
		comics.add("hero");
		Function<Map<String, Object>, Book> generatorForComic = (Map<String, Object> options) -> {
			Comic comic = new Comic();
			comic.setHero((String)options.get("hero"));
			return comic;
		};
		generators.put(comics, generatorForComic);

		HashSet<String> history = new HashSet<>();
		history.add("century");
		Function<Map<String, Object>, Book> generatorForHistoryBook= (Map<String, Object> options) -> {
			HistoryBook book = new HistoryBook();
			book.setCentury((Integer)options.get("century"));
			return book;
		};
		generators.put(history, generatorForHistoryBook);

		return generators;
}


}
