package dsalgo.graph;

import java.util.HashSet;
import java.util.Set;

public class UndirectedGraph {

    public static void main(String[] args) {

        Graph g = new UndirectedGraph().new Graph();
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(3, 1);
        g.addEdge(5, 6);
        g.addEdge(5, 7);

        int[] arr = {2, 4, 5};

        for (int a : arr) {
            g.findAllReachableNodesFrom(new UndirectedGraph().new Vertex(a));
        }
    }

    class Graph {
        Set<Vertex> vertices = new HashSet<>();

        void addEdge(int a, int b) {

            Vertex aV = new Vertex(a);
            Vertex bV = new Vertex(b);

            if (vertices.contains(aV)) {
                Vertex node = findVertexFromGraph(aV);
                Set<Vertex> adjVs = node.adjacentVertices;
                if (adjVs != null)
                    for (Vertex v : node.adjacentVertices) {
                        aV.addToAdjacentSet(v);
                    }
                aV.addToAdjacentSet(bV);

                vertices.remove(node);
                vertices.add(aV);

                // aV.addToAdjacentSet(bV);
            } else {
                aV.addToAdjacentSet(bV);
                vertices.add(aV);
            }
        }

        void findAllReachableNodesFrom(Vertex v) {
            System.out.format("\nNodes reachable from %d are :", v.key);
            if (vertices.contains(v)) {

                Vertex node = findVertexFromGraph(v);
                if (node != null) {
                    Set<Vertex> adjVs = node.adjacentVertices;
                    if (adjVs != null)
                        for (Vertex v1 : adjVs) {
                            System.out.print(" " + v1.key + ", ");
                        }
                }
            }
        }

        private Vertex findVertexFromGraph(Vertex v) {
            // TODO Auto-generated method stub
            for (Vertex node : vertices) {
                if (node.equals(v))
                    return node;
            }
            return null;
        }
    }

    class Vertex {
        int key;
        Set<Vertex> adjacentVertices;

        public Vertex(int val) {
            this.key = val;
        }

        public void addToAdjacentSet(Vertex a) {
            if (adjacentVertices == null) {
                adjacentVertices = new HashSet<>();
            }
            adjacentVertices.add(a);
        }

        @Override
        public boolean equals(Object obj) {
            return this.key == ((Vertex) obj).key;
        }

        @Override
        public int hashCode() {
            return key;
        }
    }
}
