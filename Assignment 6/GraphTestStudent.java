


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class GraphTestStudent {
	private GraphInterface<Town, Road> graph;
	private Town[] towns;

	@Before
	public void setUp() throws Exception {
	    graph = new Graph();
	    towns = new Town[12];

	    // Assign custom names to each town
	    String[] townNames = {
	        null, // Skip index 0 for simplicity
	        "Springfield", "Rivertown", "Oakville", "Mapleton",
	        "Lakeside", "Hillcrest", "Brookfield", "Fairview",
	        "Cedarville", "Greenville", "Pinehill"
	    };

	    for (int i = 1; i < towns.length; i++) {
	        towns[i] = new Town(townNames[i]);
	        graph.addVertex(towns[i]);
	    }

	    // Create roads with meaningful names
	    graph.addEdge(towns[1], towns[2], 2, "Main Street");
	    graph.addEdge(towns[1], towns[3], 4, "Oak Road");
	    graph.addEdge(towns[1], towns[5], 6, "Lakeside Drive");
	    graph.addEdge(towns[3], towns[7], 1, "Brook Lane");
	    graph.addEdge(towns[3], towns[8], 2, "Fairview Path");
	    graph.addEdge(towns[4], towns[8], 3, "Maple Trail");
	    graph.addEdge(towns[6], towns[9], 3, "Cedar Route");
	    graph.addEdge(towns[9], towns[10], 4, "Greenway");
	    graph.addEdge(towns[8], towns[10], 2, "Riverwalk");
	    graph.addEdge(towns[5], towns[10], 5, "Hill Drive");
	    graph.addEdge(towns[10], towns[11], 3, "Pine Loop");
	    graph.addEdge(towns[2], towns[11], 6, "Ridge Road");
	}

	@After
	public void tearDown() throws Exception {
	    graph = null;
	}

	@Test
	public void testGetEdge() {
	    assertEquals(new Road(towns[2], towns[11], 6, "Ridge Road"), graph.getEdge(towns[2], towns[11]));
	    assertEquals(new Road(towns[3], towns[7], 1, "Brook Lane"), graph.getEdge(towns[3], towns[7]));
	}

	@Test
	public void testAddEdge() {
	    assertFalse(graph.containsEdge(towns[3], towns[5]));
	    graph.addEdge(towns[3], towns[5], 1, "Shortcut Road");
	    assertTrue(graph.containsEdge(towns[3], towns[5]));
	}

	@Test
	public void testAddVertex() {
	    Town newTown = new Town("New Haven");
	    assertFalse(graph.containsVertex(newTown));
	    graph.addVertex(newTown);
	    assertTrue(graph.containsVertex(newTown));
	}

	@Test
	public void testContainsEdge() {
	    assertTrue(graph.containsEdge(towns[2], towns[11]));
	    assertFalse(graph.containsEdge(towns[3], towns[5]));
	}

	@Test
	public void testContainsVertex() {
	    assertTrue(graph.containsVertex(new Town("Rivertown")));
	    assertFalse(graph.containsVertex(new Town("Sunset Bay")));
	}

	@Test
	public void testEdgeSet() {
	    Set<Road> roads = graph.edgeSet();
	    List<String> roadNames = roads.stream().map(Road::getName).sorted().toList();

	    assertEquals("Brook Lane", roadNames.get(0));
	    assertEquals("Cedar Route", roadNames.get(1));
	    assertEquals("Fairview Path", roadNames.get(2));
	    assertEquals("Greenway", roadNames.get(3));
	    assertEquals("Hill Drive", roadNames.get(4));
	    assertEquals("Pine Loop", roadNames.get(9));
	}

	@Test
	public void testEdgesOf() {
	    Set<Road> roads = graph.edgesOf(towns[1]);
	    List<String> roadNames = roads.stream().map(Road::getName).sorted().toList();

	    assertEquals("Lakeside Drive", roadNames.get(0));
	    assertEquals("Main Street", roadNames.get(1));
	    assertEquals("Oak Road", roadNames.get(2));
	}

	@Test
	public void testRemoveEdge() {
	    assertTrue(graph.containsEdge(towns[2], towns[11]));
	    graph.removeEdge(towns[2], towns[11], 6, "Ridge Road");
	    assertFalse(graph.containsEdge(towns[2], towns[11]));
	}

	@Test
	public void testRemoveVertex() {
	    assertTrue(graph.containsVertex(towns[2]));
	    graph.removeVertex(towns[2]);
	    assertFalse(graph.containsVertex(towns[2]));
	}

	@Test
	public void testVertexSet() {
	    Set<Town> vertices = graph.vertexSet();
	    assertTrue(vertices.contains(towns[1]));
	    assertTrue(vertices.contains(towns[10]));
	    assertTrue(vertices.contains(towns[11]));
	    assertTrue(vertices.contains(towns[2]));
	    assertTrue(vertices.contains(towns[3]));
	}

	@Test
	public void testPath_SpringfieldToPinehill() {
	    verifyShortestPath("Springfield", "Pinehill", List.of(
	        "Springfield via Main Street to Rivertown 2 mi",
	        "Rivertown via Ridge Road to Pinehill 6 mi"
	    ));
	}

	@Test
	public void testPath_SpringfieldToGreenville() {
	    verifyShortestPath("Springfield", "Greenville", List.of(
	        "Springfield via Oak Road to Oakville 4 mi",
	        "Oakville via Fairview Path to Fairview 2 mi",
	        "Fairview via Riverwalk to Greenville 2 mi"
	    ));
	}

	@Test
	public void testPath_MapletonToPinehill() {
	    verifyShortestPath("Mapleton", "Pinehill", List.of(
	        "Mapleton via Maple Trail to Fairview 3 mi",
	        "Fairview via Riverwalk to Greenville 2 mi",
	        "Greenville via Pine Loop to Pinehill 3 mi"
	    ));
	}

	private void verifyShortestPath(String startName, String endName, List<String> expectedPath) {
	    Town start = null, end = null;
	    for (Town town : graph.vertexSet()) {
	        if (town.getName().equals(startName)) start = town;
	        if (town.getName().equals(endName)) end = town;
	    }

	    assertNotNull("Start town not found", start);
	    assertNotNull("End town not found", end);

	    List<String> path = graph.shortestPath(start, end);
	    assertNotNull(path);
	    assertEquals(expectedPath.size(), path.size());

	    for (int i = 0; i < expectedPath.size(); i++) {
	        assertEquals(expectedPath.get(i), path.get(i).trim());
	    }
	}
}