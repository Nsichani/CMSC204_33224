import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class MorseCodeTreeTestStudent
{
	// Creating an object of the MorseCodeTree class
	
    private MorseCodeTree tree;

    // Setting the object up
    
    @Before
    public void setUp() {
        tree = new MorseCodeTree();
    }
    
    @Test
    public void testGetRoot() {
        assertNotNull("Root should not be null after tree is built", tree.getRoot());
        assertEquals("Root data should be empty string", "", tree.getRoot().getData());
    }

    @Test
    public void testFetchKnownValues() {
        assertEquals("Should fetch 'e' for '.'", "e", tree.fetch("."));
        assertEquals("Should fetch 't' for '-'", "t", tree.fetch("-"));
        assertEquals("Should fetch 'm' for '--'", "m", tree.fetch("--"));
        assertEquals("Should fetch 'h' for '....'", "h", tree.fetch("...."));
    }

    @Test
    public void testInsertAndFetchCustomValue() {
        tree.insert("----", "#");
        assertEquals("Should fetch '#' for '----'", "#", tree.fetch("----"));
    }

    @Test
    public void testToArrayListIncludesLetters() {
        ArrayList<String> list = tree.toArrayList();
        assertTrue("List should contain 'e'", list.contains("e"));
        assertTrue("List should contain 's'", list.contains("s"));
        assertTrue("List should contain 'z'", list.contains("z"));
        assertTrue("List should contain 'o'", list.contains("o"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testDeleteUnsupported() {
        tree.delete("e");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testUpdateUnsupported() {
        tree.update();
    }
}
