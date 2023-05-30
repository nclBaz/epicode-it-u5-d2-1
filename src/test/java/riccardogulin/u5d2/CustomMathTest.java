package riccardogulin.u5d2;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;
import riccardogulin.u5d2.tools.CustomMath;

@Slf4j
class CustomMathTest {
	private CustomMath m = new CustomMath();

	@BeforeAll // Corrispettivo di @BeforeClass in JUnit 4
	static void beforeAll() {
		log.info("Inserisco dati nel db....");

	}

	@AfterAll // Corrispettivo di @AfterClass in JUnit 4
	static void afterAll() {
		log.info("Ripristino il db allo stato iniziale...");
	}

	@BeforeEach // Corrispettivo di @Before in JUnit 4
	void before() {
		log.info("Before");
	}

	@AfterEach // Corrispettivo di @After in JUnit 4
	void after() {
		log.info("After");
	}

	@Test
	void testSum() {
		log.info("test 1");
		assertEquals(6, m.sum(new int[] { 1, 2, 3 }));
	}

	@Test // Obbligatorio, se non annotiamo il test non viene eseguito
	void testIfZero() {
		log.info("test 2");
		assertEquals(0, m.sum(new int[] {}));
	}

	@Test
	@Disabled // Corrispettivo di @Ignore in JUnit 4
	void testVariousAsserts() {
		log.info("test 3");
		List<String> list = Stream.of("Aldo", "Giovanni", "Giacomo").toList();

		// assertTrue(list.contains("Ajeje"));
		assertFalse(list.contains("Ajeje"));
		assertEquals(3, list.size());

		assertArrayEquals(new int[] { 1, 2, 3 }, new int[] { 1, 2, 4 });
	}

}
