
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This is the test file for the CourseDBManager which is implemented from the
 * CourseDBManagerInterface
 * 
 */
public class CourseDBStructureTestStudent {
	CourseDBStructure CDBS, studentStructure;

	@Before
	public void setUp() throws Exception {
		CDBS = new CourseDBStructure(3);
		studentStructure = new CourseDBStructure("Testing", 50);
	}

	@After
	public void tearDown() throws Exception {
		CDBS = studentStructure = null;
	}

	/**
	 * Test the tableSize for CourseDBStructures constructed with both constructors
	 */
	@Test
	public void testGetTableSize() {
		assertEquals(3, CDBS.getTableSize());
		assertEquals(50, studentStructure.getTableSize());
	}

	@Test
	public void testHashTable() {

		//Create a course 
		CourseDBElement cde1 = new CourseDBElement("CMSC204", 33224, 4, "SW217", "Khandan Vahabzadeh-Monshi");
		
		CDBS.add(cde1);  //add to data structure
		CDBS.add(cde1);  // add it again. add method  should  ignore it
	 
		ArrayList<String> courseList = CDBS.showAll(); 
		assertTrue(courseList.size()==1);  
		
		//Create another course
		CourseDBElement cde2 = new CourseDBElement("CMSC207", 33223, 4, "SW211", "David Kuijt");
	 
 		try {
			assertEquals(33224, CDBS.get(cde1.getCRN()).getCRN());  
			CDBS.get(cde2.getCRN()).getCRN(); // should throw exception
		} catch (IOException e) {

			assertTrue("threw Exception successfuly for the course not found", true);
		}
		
 		CDBS.add(cde2);
 		courseList = CDBS.showAll(); 
		assertTrue(courseList.size()==2);  
		
		try {
			assertEquals(33223, CDBS.get(cde2.getCRN()).getCRN());
		} catch (IOException e) {
			 
			fail("Should not throw exception");
		}  
		CourseDBElement cde1Update = new CourseDBElement("CMSC204-updated", 33224, 4, "SW217", "Nima Sichani");
		CDBS.add(cde1Update);  //Same CRN updated information
 		courseList = CDBS.showAll(); 
		assertTrue(courseList.size()==2);  
		
		try {
			assertEquals(33224, CDBS.get(cde1Update.getCRN()).getCRN());
			assertEquals("CMSC204-updated", CDBS.get(cde1Update.getCRN()).getID());
		} catch (IOException e) {
			 
			fail("Should not throw exception");
		}  
		studentStructure.add(cde1); 
		courseList = studentStructure.showAll(); 
		assertTrue(courseList.size()==1); 
	}
}
