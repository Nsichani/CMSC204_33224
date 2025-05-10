import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TownTestStudent {

    private Town town1;
    private Town town2;
    private Town town3;
    private Town townCopy;

    @Before
    public void setUp() {
        town1 = new Town("Springfield");
        town2 = new Town("Rivertown");
        town3 = new Town("Springfield"); // same name as town1
        townCopy = new Town(town1); // copy constructor
    }

    @Test
    public void testConstructor() {
        assertEquals("Springfield", town1.getName());
        assertEquals("Rivertown", town2.getName());
    }

    @Test
    public void testCopyConstructor() {
        assertEquals("Springfield", townCopy.getName());
        assertNotSame(town1, townCopy); // should be different instances
        assertTrue(town1.equals(townCopy));
    }

    @Test
    public void testGetName() {
        assertEquals("Springfield", town1.getName());
    }

    @Test
    public void testToString() {
        assertEquals("Springfield", town1.toString());
    }

    @Test
    public void testCompareTo() {
        assertTrue(town1.compareTo(town2) > 0);  // "Springfield" > "Rivertown"
        assertEquals(0, town1.compareTo(town3)); // same name
    }

    @Test
    public void testEquals() {
        assertTrue(town1.equals(town3)); // same name
        assertTrue(town1.equals(townCopy)); // copy
        assertFalse(town1.equals(town2));
    }

    @Test(expected = ClassCastException.class)
    public void testEqualsWrongType() {
        Object notATown = new Object();
        town1.equals(notATown); // should throw ClassCastException due to direct cast
    }

    @Test
    public void testHashCodeConsistency() {
        assertEquals(town1.hashCode(), town3.hashCode());
        assertEquals(town1.hashCode(), townCopy.hashCode());
    }
}
