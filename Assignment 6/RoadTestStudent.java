import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class RoadTestStudent {

    private Town townA;
    private Town townB;
    private Town townC;
    private Road road1;
    private Road road2;
    private Road road3;
    private Road roadDefaultWeight;

    @Before
    public void setUp() {
        townA = new Town("Springfield");
        townB = new Town("Rivertown");
        townC = new Town("Oakville");

        road1 = new Road(townA, townB, 5, "Main Street");
        road2 = new Road(townA, townB, 5, "Main Street");  // Same as road1
        road3 = new Road(townB, townA, 5, "Main Street");  // Reverse direction
        roadDefaultWeight = new Road(townA, townC, "Oak Road");  // Uses default weight
    }

    @Test
    public void testConstructorWithWeight() {
        assertEquals(townA, road1.getSource());
        assertEquals(townB, road1.getDestination());
        assertEquals("Main Street", road1.getName());
        assertEquals(5, road1.getWeight());
    }

    @Test
    public void testConstructorDefaultWeight() {
        assertEquals(1, roadDefaultWeight.getWeight());
        assertEquals("Oak Road", roadDefaultWeight.getName());
    }

    @Test
    public void testContains() {
        assertTrue(road1.contains(townA));
        assertTrue(road1.contains(townB));
        assertFalse(road1.contains(townC));
    }

    @Test
    public void testToString() {
        assertEquals("Main Street", road1.toString());
    }

    @Test
    public void testGetters() {
        assertEquals(townA, road1.getSource());
        assertEquals(townB, road1.getDestination());
        assertEquals("Main Street", road1.getName());
        assertEquals(5, road1.getWeight());
    }

    @Test
    public void testCompareTo() {
        Road anotherRoad = new Road(townB, townC, 3, "Broadway");
        assertTrue(road1.compareTo(anotherRoad) > 0);  // "Main Street" > "Broadway"
        assertEquals(0, road1.compareTo(road2));       // same name
    }

    @Test
    public void testEquals() {
        assertTrue(road1.equals(road2)); // same source and destination
        assertTrue(road1.equals(road3)); // reverse direction should still be equal
        assertFalse(road1.equals(roadDefaultWeight));
    }

    @Test(expected = ClassCastException.class)
    public void testEqualsWrongType() {
        Object notARoad = new Object();
        road1.equals(notARoad);  // Should throw ClassCastException
    }
}
