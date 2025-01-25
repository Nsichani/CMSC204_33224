import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class GradebookTest {

	// Creating two private members of the Gradebook class to use in my tests.
	
	static Gradebook g1;
	static Gradebook g2;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		// Creating two objects of the Gradebook class and assigning both to a size of 5.
		
		g1 = new Gradebook(5);
		g2 = new Gradebook(5);
		
		// Calling the addScore method 3 times for g1
		
		g1.addScore(9);
		g1.addScore(13);
		g1.addScore(26);
		
		// Calling the addScore method 2 times for g2
		
		g2.addScore(50);
		g2.addScore(100);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		
		// Setting both objects to null
		
		g1 = null;
		g2 = null;
	}

	@Test
	void testAddScore() {
		
		// Checking to see if the contents in the array are the correct values.
		
		assertTrue(g1.toString().equals("9.0 13.0 26.0"));
		assertTrue(g2.toString().equals("50.0 100.0"));
	}

	@Test
	void testSum() {
		
		// Checking to see if the expected sum of the scores in the array is correctly calculated or not.
		
		assertEquals(48, g1.sum(), .0001);
		assertEquals(150, g2.sum(), .0001);
	}

	@Test
	void testMinimum() {
		
		// Checking to see if the expected minimum of the array is accurately located.
		
		assertEquals(9, g1.minimum(), .001);
		assertEquals(50, g2.minimum(), .001);
	}

	@Test
	void testFinalScore() {
		
		// Checking to see if the final score with the lowest score being dropped since both cases have 2+ values is correctly calculated.
		
		assertEquals(39, g1.finalScore());
		assertEquals(100, g2.finalScore());
	}

}
