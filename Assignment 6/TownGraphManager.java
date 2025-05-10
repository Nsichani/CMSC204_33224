import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TownGraphManager implements TownGraphManagerInterface{
	
	// Making a graph private variable and apporiate constructor
	
	Graph g;
	
	public TownGraphManager() {
		g = new Graph();
	}

	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadName) {
		
		Town t1 = new Town(town1);
		Town t2 = new Town(town2);
		g.addEdge(t1, t2, weight, roadName);
		return true;
	}

	@Override
	public String getRoad(String town1, String town2) {
		
		Town from = new Town(town1);
		Town to = new Town(town2);
		return g.getEdge(from, to).getName();
	}

	@Override
	public boolean addTown(String v) {
		
		Town newTown = new Town(v);
		return g.addVertex(newTown);
	}

	@Override
	public Town getTown(String name) {
		
		return containsTown(name) ? new Town(name) : null;
	}

	@Override
	public boolean containsTown(String v) {
		
		return g.vertexSet().contains(new Town(v));
	}

	@Override
	public boolean containsRoadConnection(String town1, String town2) {
		
		Town a = new Town(town1);
		Town b = new Town(town2);
		return g.getEdge(a, b) != null;
				
	}

	@Override
	public ArrayList<String> allRoads() {
		ArrayList<String> allR = new ArrayList<>();
		for (Road r : g.edgeSet())
		{
			allR.add(r.toString());
		}
		Collections.sort(allR);
		return allR;
	}

	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		
		Town start = new Town(town1);
	    Town end = new Town(town2);
	    
	    // Try to get the edge directly
	    Road r = g.getEdge(start, end);
	    
	    // If edge exists and has the correct name, remove it
	    if(r != null && r.getName().equals(road)) {
	        return g.removeEdge(start, end, r.getWeight(), road) != null;
	    }
	    
	    return false;
		
//		int weight = 0;
//		List<Road> roads = new ArrayList<>(g.edgeSet());
//		
//		for(int i =0; i < roads.size(); i++)
//		{
//			Road r = roads.get(i);
//			
//			if(r.getName().equals(getRoad(town1, town2)))
//			{
//				weight = r.getWeight();
//				break;
//			}
//		}
//		
//		return g.removeEdge(new Town(town1), new Town(town2), weight, road) != null;
		
//		Town start = new Town(town1);
//		Town end = new Town(town2);
//		Road r = g.getEdge(start, end);
//		
//		if(r != null && r.getName().equals(road))
//		{
//			g.removeEdge(start, end, r.getWeight(), r.getName());
//			return true;
//		}
//		
//		return false;
	}

	@Override
	public boolean deleteTown(String v) {
		
		return g.removeVertex(new Town(v));
	}

	@Override
	public ArrayList<String> allTowns() {
		
		ArrayList<String> allT = new ArrayList<>();
		for(Town t : g.vertexSet())
		{
			allT.add(t.toString());
		}
		Collections.sort(allT);
		return allT;
	}

	@Override
	public ArrayList<String> getPath(String town1, String town2) {
		Town t1 = new Town(town1);
		Town t2 = new Town(town2);
		return g.shortestPath(t1, t2);
	}

}
