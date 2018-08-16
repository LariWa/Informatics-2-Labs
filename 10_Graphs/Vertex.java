package graphs;

//@author Franz Lisdat and Larissa Wagnerberger
public class Vertex implements Comparable<Vertex> {
	private String name;
	public int pathCost = Integer.MAX_VALUE;

	public Vertex(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public boolean equals(Vertex v) {
		if (name == v.getName())
			return true;
		return false;
	}

	public void setPathCost(int cost) {
		pathCost = cost;
	}

	public int getPathCost() {
		return pathCost;
	}

	public int compareTo(Vertex v2) {

		if (this.pathCost < v2.getPathCost())
			return -1;
		if (this.pathCost > v2.getPathCost())
			return 1;
		return 0;
	}
}
