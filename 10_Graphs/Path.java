package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

//@author Franz Lisdat and Larissa Wagnerberger
public class Path {

	public static String findShortestPath(WeightedGraph graph, Vertex start, Vertex goal) {
		LinkedList<Vertex> l = new LinkedList<Vertex>();
		Set<Vertex> visited = new HashSet<>();
		HashMap spath = new HashMap();
		spath.put(start, start.getName());
		l.add(start);
		while (!l.isEmpty()) {
			Vertex current = l.remove();

			if (current.equals(goal)) {
				return (String) spath.get(current);
			} else {
				ArrayList<Edge> edges = graph.getEdges(current);
				for (int i = 0; i < edges.size(); i++) {
					Vertex next = edges.get(i).getTargetV();
					if (!visited.contains(next)) {
						l.add(next);
						String newValue = spath.get(current) + " - " + next.getName();
						if (spath.containsKey(next)) {
							String in = (String) spath.get(next);
							if (in.length() > newValue.length()) {
								spath.put(next, newValue);
							}
						} else
							spath.put(next, newValue);
					}
					if (next.equals(goal)) {
						return (String) spath.get(next);
					}
				}
			}
			visited.add(current);
		}
		return "Path not found";
	}

	public static String findCheapestPath(WeightedGraph graph, Vertex start, Vertex goal) {
		Set<Vertex> visited = new HashSet<Vertex>();
		HashMap cpath = new HashMap();
		ArrayList<Vertex> vertices = graph.getVertexList();
		cpath.put(start, start.getName());
		start.setPathCost(0);
		Queue<Vertex> pq = new PriorityQueue<>();
		pq.add(start);
		while (!pq.isEmpty()) {
			Vertex current = pq.remove();
			ArrayList<Edge> edges = graph.getEdges(current);
			for (int i = 0; i < edges.size(); i++) {
				Vertex next = edges.get(i).getTargetV();
				if (!visited.contains(next)) {
					pq.add(next);
					int newPathCost = edges.get(i).getWeight() + current.getPathCost();
					if (next.getPathCost() > newPathCost) {
						next.setPathCost(newPathCost);
						String newValue = cpath.get(current) + " - " + next.getName();
						cpath.put(next, newValue);
					}
				}
			}
			visited.add(current);
		}
		String result;
		if (!(cpath.get(goal) == null))
			result = cpath.get(goal) + " cost: " + goal.getPathCost();
		else
			result = "Path not found";
		return result;
	}
}