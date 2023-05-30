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
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

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

		assertArrayEquals(new int[] { 1, 2, 3 }, new int[] { 1, 2, 3 });
	}

	@ParameterizedTest // Dichiarazione che questo sarà un test parametrico
	@MethodSource("sumParameters") // I parametri verranno forniti dal metodo statico "sumParameters"
	void testWithDifferentParameters(int expected, int first, int second) { // ogni esecuzione del test avrà bisogno di
																			// 3 parametri
		assertEquals(expected, first + second);
	}

	static Stream<Arguments> sumParameters() {
		// Metodo che fornisce i parametri, ogni test avrà bisogno di 3 parametri, qua
		// dichiarati nella forma
		// Arguments.arguments(risultato atteso, primo addendo, secondo addendo)
		return Stream.of(Arguments.arguments(5, 2, 3), Arguments.arguments(7, 3, 4), Arguments.arguments(101, 90, 10));
	}

}
