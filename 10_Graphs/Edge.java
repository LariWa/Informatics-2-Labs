package graphs;
//@author Franz Lisdat and Larissa Wagnerberger

public class Edge {
	private Vertex target;
	private int weight;

	public Edge(Vertex target, int weight) {
		this.target = target;
		this.weight = weight;
	}

	public String getTarget() {
		return target.getName();
	}

	public Vertex getTargetV() {
		return target;
	}

	public int getWeight() {

		return weight;
	}
}