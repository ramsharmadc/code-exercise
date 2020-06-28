package dsa.datastructure.graph;

import java.util.HashSet;
import java.util.Set;

public class Vertex {

	private Set<Vertex> adjVertices;
	private int key;

	public Vertex() {
		adjVertices = new HashSet<>();
		key = 0;
	}

	public Vertex(int i) {
		adjVertices = new HashSet<>();
		key = i;
	}

	public Vertex(int i, Set<Vertex> adjVertices) {
		this(i);
		this.adjVertices = adjVertices;
	}

	public Set<Vertex> getAdjVertices() {
		return adjVertices;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}
}
