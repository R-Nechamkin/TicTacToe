package playerQueue;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class PlayerQueueTest {
	static PlayerQueue<String> strings;

	@BeforeEach
	void setUp() {
		strings = new PlayerQueue<>(5);
	}
	@Test
	void OfferWorksForOne() {
		strings.offer("1");
		assertEquals(strings.array[0], "1");
	}
	
	@Test
	void OfferWorksForMultiple() {
		strings.offer("1");
		strings.offer("2");

		assertEquals(strings.array[1], "2");
	}

	@Test
	void PollReturnsHeadOnce() {
		strings.offer("1");
		strings.offer("2");
		String x = strings.poll();
		assertNotEquals(x, "2", "Wrong value was returned");
		assertEquals(x, "1","Value was not returned and assigned to variable");
	}
	
	@Test
	void PollReturnsHeadMultipleTimes() {
		strings.offer("1");
		strings.offer("2");
		String x = strings.poll();
		assertNotEquals(x, "2", "Wrong value was returned");
		assertEquals(x, "1","Value was not returned and assigned to variable");
		String y = strings.poll();
		assertEquals(y, "2","Value was not returned and assigned to variable");

	}
	
	@Test
	void PollRemovesHead() {
		strings.offer("1");
		strings.offer("2");
		strings.poll();
		assertNull(strings.array[0], "Value was not removed");
	}

	
	@Test
	void testElement() {
		strings.offer("1");
		strings.offer("2");
		String x = strings.poll();
		assertEquals(x, "1","Value was not returned and assigned to variable");
	}

}
