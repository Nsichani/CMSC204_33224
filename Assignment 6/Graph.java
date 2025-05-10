import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Graph implements GraphInterface<Town, Road>{
	
	// Private variables for this class
	
	private Set<Town> t;
	private Set<Road> r;
	private Map<Town, Set<Road>> mapAdj;
	private Map<Town, Integer> mapWeight;
	private Map<Town, Town> mapHist;
	
	// Constructor
	
	public Graph()
	{
		t = new HashSet<>();
		r = new HashSet<>();
		mapAdj = new HashMap<>();
	}

	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) {

		if(!containsVertex(sourceVertex) || !containsVertex(destinationVertex))
		{
			return null;
		}
		
		Set<Road> edges = mapAdj.get(sourceVertex);
		if(edges == null)
		{
			return null;
		}
		
		List<Road> edge = new ArrayList<>(edges);
		for(int i =0; i < edge.size(); i++)
		{
			Road r = edge.get(i);
			Town t1 = r.getSource();
			Town t2 = r.getDestination();
			
			if(t1.equals(sourceVertex) && t2.equals(destinationVertex) || t1.equals(destinationVertex) && t2.equals(sourceVertex))
			{
				return r;
			}
		}
		
		return null;
	}

	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		
		if(sourceVertex == null || destinationVertex == null)
		{
			return null;
		}
		
		Road road = new Road(sourceVertex, destinationVertex, weight, description);
		
		if(r.contains(road))
		{
			return null;
		}
		
		r.add(road);
		mapAdj.get(sourceVertex).add(road);
		mapAdj.get(destinationVertex).add(road);
		
		return road;
		
	}

	@Override
	public boolean addVertex(Town v) {
		
		if(v == null || t.contains(v))
		{
			return false;
		}
		
		t.add(v);
		mapAdj.put(v, new HashSet<>());
		return true;
	}

	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
		
		if(sourceVertex == null || destinationVertex == null)
		{
			return false;
		}
		
		Road[] roadArray = r.toArray(new Road[0]);
		for(int i = 0; i < roadArray.length; i++)
		{
			Road road = roadArray[i];
			if(road.getSource().equals(sourceVertex) && road.getDestination().equals(destinationVertex) || road.getSource().equals(destinationVertex) && road.getDestination().equals(sourceVertex))
			{
				return true;
			}
		}
		
		return false;
	}

	@Override
	public boolean containsVertex(Town v) {
		
		return t.contains(v);
	}

	@Override
	public Set<Road> edgeSet() {
		
		return r;
	}

	@Override
	public Set<Road> edgesOf(Town vertex) {
		
		return mapAdj.getOrDefault(vertex, Collections.emptySet());
	}

	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) { 
		
		if(sourceVertex == null || destinationVertex == null || description == null)
		{
			return null;
		}
		
		Road[] roads = r.toArray(new Road[0]);
		
		for(int i = 0; i < roads.length; i++)
		{
			Road road = roads[i];
			
			if(road.contains(sourceVertex) && road.contains(destinationVertex) && road.getWeight() == weight && road.getName().equals(description)) 
			{
				r.remove(road);
				
				// Claud AI helped me find out that the TownGraph Manager testDeleteRoadConnections wasnt working since i forgot to update adjaceny matrix right here.
				
				if(mapAdj.containsKey(sourceVertex)) {
	                mapAdj.get(sourceVertex).remove(road);
	            }
	            if(mapAdj.containsKey(destinationVertex)) {
	                mapAdj.get(destinationVertex).remove(road);
	            }
				
				return road;
			}
		}
		
		return null;

	}

	@Override
	public boolean removeVertex(Town v) {
		
		return t.remove(v);
	}

	@Override
	public Set<Town> vertexSet() {
		
		return t;
	}

	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
		
		dijkstraShortestPath(sourceVertex);
		
		ArrayList<String> path = new ArrayList<>();
		Town curr = destinationVertex;
		
		if(!mapHist.containsKey(curr))
		{
			return path;
		}
		
		while(curr != null && mapHist.get(curr) != null)
		{
			Town prev = mapHist.get(curr);
			Road road = getEdge(prev,curr);
			
			if(road != null)
			{
				path.add(0, prev.getName() + " via " + road.getName() + " to " + curr.getName() + " " + road.getWeight() + " mi");
			}
			
			curr = prev;
		}
		
		return path;
	}

	@Override
	public void dijkstraShortestPath(Town sourceVertex) { // used this: https://teams.microsoft.com/l/message/19:a801f183664b4a55a666e2f4027d0f40@thread.v2/1746662746867?context=%7B%22contextType%22%3A%22chat%22%7D to help me with this method
		
		if(sourceVertex == null || !t.contains(sourceVertex))
		{
			return;
		}
		
		mapWeight = new HashMap<>();
		mapHist = new HashMap<>();
		
		Town[] townArr = t.toArray(new Town[0]);
		
		for(int i = 0; i < townArr.length; i++)
		{
			mapWeight.put(townArr[i], Integer.MAX_VALUE);
			mapHist.put(townArr[i], null);
		}
		
		mapWeight.put(sourceVertex, 0);
		PriorityQueue<Town> queue = new PriorityQueue<>(Comparator.comparingInt(mapWeight::get));
		queue.add(sourceVertex);
		
		while(!queue.isEmpty())
		{
			Town curr = queue.poll();
			
			Set<Road> road = edgesOf(curr);
			Road[] roadArr = road.toArray(new Road[0]);
			
			for(int i = 0; i < roadArr.length; i++)
			{
				Road r = roadArr[i];
				Town t1 = r.getSource().equals(curr) ? r.getDestination() : r.getSource();
				int alt = mapWeight.get(curr) + r.getWeight();
				
				if(alt < mapWeight.get(t1))
				{
					mapWeight.put(t1, alt);
					mapHist.put(t1, curr);
					queue.add(t1);
				}
			}
		}
		
		
		
	}

}
