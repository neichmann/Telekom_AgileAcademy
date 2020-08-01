package org.javacream.store;

import org.javacream.store.api.StoreService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class StoreServiceTest {

	private static final String CATEGORY = "TEST_CATEGORY";
	private static final String ID = "TEST_ID";
	private static final String NEW_ID = "NEW_TEST_ID";
	private static final int STORE = 42;
	
	@Autowired private StoreService storeService;
	
	@Test public void testInsertValidStoreEntry() {
		storeService.setStock(CATEGORY, NEW_ID, STORE);
	}
	@Test public void testReadValidStoreEntry() {
		int actualStock = storeService.getStock(CATEGORY, ID);
		Assert.assertEquals(STORE, actualStock);
	}
}
