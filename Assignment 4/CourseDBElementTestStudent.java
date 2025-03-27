

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This is the test file for the CourseDBManager
 * which is implemented from the CourseDBManagerInterface
 * 
 */
public class CourseDBElementTestStudent {
	private CourseDBManagerInterface student = new CourseDBManager();

	/**
	 * Create an instance of CourseDBManager
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		student = new CourseDBManager();
	}

	/**
	 * Set dataMgr reference to null
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		student = null;
	}

	/**
	 * Test for the add method
	 */
	@Test
	public void testAddToDB() {
		try {
			student.add("CMSC204",333224, 4,"SW217","Khandan Vahabzadeh-Monshi");
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}
	}
	
	/**
	 * Test for the showAll method
	 */
	@Test
	public void testShowAll() {
		student.add("CMSC204",33224, 4,"SW217","Khandan Vahabzadeh-Monshi");
		student.add("CMSC207",33223, 4,"SW211","David Kuijt");
		student.add("CHEM135",34210, 4,"SC359","Orlando Genovese-Stewart");
		ArrayList<String> list = student.showAll();
	 	assertEquals(list.get(0),"\nCourse:CMSC207 CRN:33223 Credits:4 Instructor:David Kuijt Room:SW211");
	 	assertEquals(list.get(1),"\nCourse:CMSC204 CRN:33224 Credits:4 Instructor:Khandan Vahabzadeh-Monshi Room:SW217");
		assertEquals(list.get(2),"\nCourse:CHEM135 CRN:34210 Credits:4 Instructor:Orlando Genovese-Stewart Room:SC359");
	}
	
	/**
	 * Test for the read method
	 */
	@Test
	public void testRead() {
		try {
			File inputFile = new File("Test1.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.println("CMSC204 33224 4 SW217 Khandan Vahabzadeh-Monshi");
			inFile.print("CMSC207 33223 4 SW211 David Kuijt");
			
			inFile.close();
			student.readFile(inputFile);
			assertEquals("CMSC204",student.get(33224).getID());
			assertEquals("CMSC207",student.get(33223).getID());
			assertEquals("SW211",student.get(33223).getRoomNum());
		} catch (Exception e) {
			fail("Should not have thrown an exception");
		}
	}
}
