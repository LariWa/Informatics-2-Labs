package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.*;

//@author Franz Lisdat and Larissa Wagnerberger
public class WeightedGraph {
	public HashMap<Vertex, List<Edge>> adjacenyList = new HashMap<>();

	public static void main(String[] args) {
		WeightedGraph graph = new WeightedGraph(10, 10);
		graph.printEverything();
	}

	public WeightedGraph(int verticesNumber, int edgesNumber) {

		for (int i = 0; i < verticesNumber; i++) {
			adjacenyList.put(new Vertex("V" + i), new ArrayList<Edge>());
		}

		int edgesN = 0;

		while (edgesN != edgesNumber) {
			ArrayList<Vertex> vertexList = new ArrayList<Vertex>(adjacenyList.keySet());
			Random random = new Random();
			Vertex von;
			Vertex zu;

			von = vertexList.get((random.nextInt(verticesNumber)));

			zu = vertexList.get((random.nextInt(verticesNumber)));

			while (zu == von) {
				zu = vertexList.get((random.nextInt(verticesNumber)));
			}

			int weight = random.nextInt(99) + 1;
			Edge vonZu = new Edge(zu, weight);
			Edge zuVon = new Edge(von, weight);
			ArrayList<Edge> edgesVon = new ArrayList<Edge>();
			ArrayList<Edge> edgesZu = new ArrayList<Edge>();

			edgesVon = (ArrayList<Edge>) adjacenyList.get(von);
			edgesZu = (ArrayList<Edge>) adjacenyList.get(zu);

			if (!(edgeContains(edgesVon, vonZu))) {
				edgesVon.add(vonZu);
				edgesZu.add(zuVon);
				edgesN++;
			}
		}
	}

	private boolean edgeContains(ArrayList<Edge> edges, Edge vonZu) {
		for (int j = 0; j < edges.size(); j++) {
			if (edges.get(j).getTarget() == vonZu.getTarget())
				return true;
		}
		return false;
	}

	public void printEverything() {
		ArrayList<Vertex> vertexList = new ArrayList<Vertex>(adjacenyList.keySet());
		ArrayList<Edge> edges = new ArrayList<Edge>();
		for (int i = 0; i < adjacenyList.size(); i++) {
			System.out.println("-----------------");
			System.out.println("Vertex");
			System.out.println(vertexList.get(i).getName());
			edges = (ArrayList<Edge>) adjacenyList.get(vertexList.get(i));
			System.out.println("Edges: " + edges.size());

			for (Edge edge : edges) {
				System.out.println(edge.getTarget() + " Weight:" + edge.getWeight());
			}
		}
	}

	public ArrayList getVertexList() {
		ArrayList<Vertex> vertexList = new ArrayList<Vertex>(adjacenyList.keySet());
		return vertexList;
	}

	public ArrayList getEdges(Vertex v) {
		return (ArrayList<Edge>) adjacenyList.get(v);
	}
}
