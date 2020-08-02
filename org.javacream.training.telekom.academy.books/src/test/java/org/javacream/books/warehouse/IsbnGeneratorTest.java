package org.javacream.books.warehouse;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class IsbnGeneratorTest {

	@Autowired IsbnGenerator isbnGenerator;
	
	@Test public void testIsbnGenerator() {
		System.out.println(isbnGenerator.getClass().getName());
	}

}
