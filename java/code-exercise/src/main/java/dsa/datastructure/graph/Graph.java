package dsa.datastructure.graph;

import java.util.LinkedHashSet;
import java.util.Set;

import static java.util.Optional.ofNullable;

public class Graph {
	private final Set<Vertex> vertices = new LinkedHashSet<>();

	private void addVertex(final Vertex node) {
		vertices.add(node);
	}

	public void addVertexInGraph(final Vertex node) {
		addVertex(node);
	}

	private void findShortestPath() {
	}

	public void findShortestPathInGraph() {
		findShortestPath();
	}

	private void findVertex() {
	}

	public void findVertexInGraph() {
		findVertex();
	}

	public void printGraph() {

		for (final Vertex node : vertices) {
			System.out.print(node.getKey() + " -> [");

			ofNullable(node.getAdjVertices()).ifPresent(vl -> {
				vl.forEach(v -> System.out.print(v.getKey() + " "));
			});

			System.out.println("]");
		}
	}

	private void search() {
	}

	public void searchInGraph() {
		search();
	}
}
