package dsa.graph;

public class TestGraph {

	public static void main(final String[] args) {

		final Graph graph = new Graph();

		final Vertex v1 = new Vertex(12);
		final Vertex v2 = new Vertex(30);
		final Vertex v3 = new Vertex(25);
		final Vertex v4 = new Vertex(30);

		graph.addVertexInGraph(v1);
		graph.addVertexInGraph(v2);
		graph.addVertexInGraph(v3);

		Edge e1 = new Edge(v1, v2);
		e1.setWeight(46);

		Edge e2 = new Edge(v1, v3);
		e2.setWeight(50);

		v1.getAdjVertices().add(v2);
		v2.getAdjVertices().add(v1);
		v1.getAdjVertices().add(v3);

		graph.printGraph();
	}
}
