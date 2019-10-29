package org.javacream.books.warehouse;

import java.util.HashMap;

import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksService;
import org.javacream.books.warehouse.api.SchoolBook;
import org.javacream.books.warehouse.api.SpecialistBook;
import org.javacream.util.Ordering;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class BooksServiceOperationsTest {
	@Autowired
	private BooksService booksService;
	@Value("${isbn}") private String isbn;
	@Value("${title}") private String title;
	@Value("${price}") private double price;
	private double NEW_PRICE = 19.99;

	private final String WRONG_ISBN = "##ISBN##";


	@Test
	public void deleteBookByIsbnOk() throws BookException {
		Book book = booksService.findBookByIsbn(isbn);
		booksService.deleteBookByIsbn(isbn);
		Assert.assertFalse(booksService.findAllBooks().contains(book));
	}

	@Test(expected = BookException.class)
	public void deleteBookByIsbnWrong() throws BookException {
		booksService.deleteBookByIsbn(WRONG_ISBN);
	}

	@Test
	public void findBookByIsbnOk() throws BookException {
		Book book = booksService.findBookByIsbn(isbn);
		Assert.assertNotNull(book);
	}

	@Test(expected = BookException.class)
	public void findBookByIsbnWrong() throws BookException {
		booksService.findBookByIsbn(WRONG_ISBN);
	}

	@Test
	public void findBookAllBooks() {
		Assert.assertNotNull(booksService.findAllBooks());
	}

	@Test
	public void updateBookOk() throws BookException {
		final String NEW_TITLE = "CHANGED";
		Book book = booksService.findBookByIsbn(isbn);
		book.setTitle(NEW_TITLE);
		book.setPrice(NEW_PRICE);
		Book book2 = booksService.updateBook(book);
		Assert.assertTrue(NEW_TITLE.equals(book2.getTitle()));
	}

	@Test(expected = Exception.class)
	public void updateBookWrong() throws BookException {
		Book book = new Book();
		book.setIsbn(WRONG_ISBN);
		book.setPrice(NEW_PRICE);
		booksService.updateBook(book);
	}

	@Test(expected = Exception.class)
	public void updateBookPriceNotGreaterZeroFails() throws BookException {
		Book book = booksService.findBookByIsbn(isbn);
		book.setPrice(-NEW_PRICE);
		booksService.updateBook(book);
	}

	@Test
	public void createBook() throws BookException {
		String isbn = booksService.newBook("TEST", price, new HashMap<String, Object>());
		Book book = booksService.findBookByIsbn(isbn);
		Assert.assertTrue(book.getClass() == Book.class);

	}

	@Test
	public void createSchoolBook() throws BookException {
		HashMap<String, Object> options = new HashMap<String, Object>();
		options.put("subject", "Physics");
		options.put("year", 10);
		String isbn = booksService.newBook("TEST", price, options);
		Book book = booksService.findBookByIsbn(isbn);
		Assert.assertTrue(book.getClass() == SchoolBook.class);

	}

	@Test
	public void createSpecialistBook() throws BookException {
		HashMap<String, Object> options = new HashMap<String, Object>();
		options.put("topic", "Very Special");
		String isbn = booksService.newBook("TEST", price, options);
		Book book = booksService.findBookByIsbn(isbn);
		Assert.assertTrue(book.getClass() == SpecialistBook.class);

	}

	@Test(expected = Exception.class)
	public void createBookFailsNullOptions() throws BookException {
		booksService.newBook("TEST", price, null);

	}

	@Test
	public void listBooks() {
		Assert.assertNotNull(booksService.booksList());
	}

	@Test
	public void listBooksAscending() {
		Assert.assertNotNull(booksService.booksList(Ordering.ASCENDING));
	}

	@Test
	public void listBooksDescending() {
		Assert.assertNotNull(booksService.booksList(Ordering.DESCENDING));
	}

	@Test
	public void listBooksPriceRange() {
		Assert.assertNotNull(booksService.findBooksByPriceRange(12.5, 33.40));
	}

}
