package graphs;

import java.util.ArrayList;
import java.util.Random;

//@author Franz Lisdat and Larissa Wagnerberger
public class Main {

	public static void main(String[] args) {
		WeightedGraph graph = new WeightedGraph(10, 15);
		graph.printEverything();
		ArrayList<Vertex> vertices = graph.getVertexList();
		Random random = new Random();
		Vertex start = vertices.get((random.nextInt(vertices.size())));
		Vertex goal = vertices.get((random.nextInt(vertices.size())));
		while (start == goal)
			goal = vertices.get((random.nextInt(vertices.size())));
		System.out.println("start: " + start.getName() + " goal: " + goal.getName());
		System.out.println("shortest path: " + Path.findShortestPath(graph, start, goal));
		System.out.println("cheapest path: " + Path.findCheapestPath(graph, start, goal));
	}
}