import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TownGraphManagerTestStudent {
    private TownGraphManagerInterface graph;
    private String[] towns;

    @Before
    public void setUp() throws Exception {
        graph = new TownGraphManager();
        towns = new String[12];

        // Assign custom names to each town
        String[] townNames = {
            null, // index 0 unused
            "Springfield", "Rivertown", "Oakville", "Mapleton",
            "Lakeside", "Hillcrest", "Brookfield", "Fairview",
            "Cedarville", "Greenville", "Pinehill"
        };

        for (int i = 1; i < towns.length; i++) {
            towns[i] = townNames[i];
            graph.addTown(towns[i]);
        }

        // Connect towns with named roads
        graph.addRoad(towns[1], towns[2], 2, "Main Street");
        graph.addRoad(towns[1], towns[3], 4, "Oak Road");
        graph.addRoad(towns[1], towns[5], 6, "Lakeside Drive");
        graph.addRoad(towns[3], towns[7], 1, "Brook Lane");
        graph.addRoad(towns[3], towns[8], 2, "Fairview Path");
        graph.addRoad(towns[4], towns[8], 3, "Maple Trail");
        graph.addRoad(towns[6], towns[9], 3, "Cedar Route");
        graph.addRoad(towns[9], towns[10], 4, "Greenway");
        graph.addRoad(towns[8], towns[10], 2, "Riverwalk");
        graph.addRoad(towns[5], towns[10], 5, "Hill Drive");
        graph.addRoad(towns[10], towns[11], 3, "Pine Loop");
        graph.addRoad(towns[2], towns[11], 6, "Ridge Road");
    }

    @After
    public void tearDown() throws Exception {
        graph = null;
    }

    @Test
    public void testAddRoad() {
        ArrayList<String> roads = graph.allRoads();
        assertEquals("Brook Lane", roads.get(0));
        assertEquals("Cedar Route", roads.get(1));
        assertEquals("Fairview Path", roads.get(2));
        assertEquals("Greenway", roads.get(3));
        graph.addRoad(towns[4], towns[11], 1, "Sunset Boulevard");
        roads = graph.allRoads();
        assertTrue(roads.contains("Sunset Boulevard"));
    }

    @Test
    public void testGetRoad() {
        assertEquals("Ridge Road", graph.getRoad(towns[2], towns[11]));
        assertEquals("Brook Lane", graph.getRoad(towns[3], towns[7]));
    }

    @Test
    public void testAddTown() {
        assertFalse(graph.containsTown("Sunset Bay"));
        graph.addTown("Sunset Bay");
        assertTrue(graph.containsTown("Sunset Bay"));
    }

    @Test
    public void testDisjointGraph() {
        graph.addTown("Sunset Bay");
        ArrayList<String> path = graph.getPath(towns[1], "Sunset Bay");
        assertNotNull(path);
        assertEquals(0, path.size());
    }

    @Test
    public void testContainsTown() {
        assertTrue(graph.containsTown("Rivertown"));
        assertFalse(graph.containsTown("Sunset Bay"));
    }

    @Test
    public void testContainsRoadConnection() {
        assertTrue(graph.containsRoadConnection(towns[2], towns[11]));
        assertFalse(graph.containsRoadConnection(towns[3], towns[5]));
    }

    @Test
    public void testAllRoads() {
        ArrayList<String> roads = graph.allRoads();
        assertTrue(roads.contains("Main Street"));
        assertTrue(roads.contains("Greenway"));
        assertTrue(roads.contains("Riverwalk"));
    }

    @Test
    public void testDeleteRoadConnection() {
        assertTrue(graph.containsRoadConnection(towns[2], towns[11]));
        graph.deleteRoadConnection(towns[2], towns[11], "Ridge Road");
        assertFalse(graph.containsRoadConnection(towns[2], towns[11]));
    }

    @Test
    public void testDeleteTown() {
        assertTrue(graph.containsTown("Rivertown"));
        graph.deleteTown("Rivertown");
        assertFalse(graph.containsTown("Rivertown"));
    }

    @Test
    public void testAllTowns() {
        ArrayList<String> allTowns = graph.allTowns();
        assertTrue(allTowns.contains("Springfield"));
        assertTrue(allTowns.contains("Greenville"));
        assertTrue(allTowns.contains("Pinehill"));
    }

    @Test
    public void testGetPath_SpringfieldToPinehill() {
        ArrayList<String> path = graph.getPath(towns[1], towns[11]);
        assertNotNull(path);
        assertEquals(2, path.size());
        assertEquals("Springfield via Main Street to Rivertown 2 mi", path.get(0).trim());
        assertEquals("Rivertown via Ridge Road to Pinehill 6 mi", path.get(1).trim());
    }

    @Test
    public void testGetPath_SpringfieldToGreenville() {
        ArrayList<String> path = graph.getPath(towns[1], towns[10]);
        assertNotNull(path);
        assertEquals(3, path.size());
        assertEquals("Springfield via Oak Road to Oakville 4 mi", path.get(0).trim());
        assertEquals("Oakville via Fairview Path to Fairview 2 mi", path.get(1).trim());
        assertEquals("Fairview via Riverwalk to Greenville 2 mi", path.get(2).trim());
    }

    @Test
    public void testGetPath_SpringfieldToHillcrest() {
        ArrayList<String> path = graph.getPath(towns[1], towns[6]);
        assertNotNull(path);
        assertEquals(5, path.size());
        assertEquals("Springfield via Oak Road to Oakville 4 mi", path.get(0).trim());
        assertEquals("Oakville via Fairview Path to Fairview 2 mi", path.get(1).trim());
        assertEquals("Fairview via Riverwalk to Greenville 2 mi", path.get(2).trim());
        assertEquals("Greenville via Greenway to Cedarville 4 mi", path.get(3).trim());
        assertEquals("Cedarville via Cedar Route to Hillcrest 3 mi", path.get(4).trim());
    }
}
