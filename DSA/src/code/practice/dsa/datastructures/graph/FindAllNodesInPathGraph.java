package dsa.datastructures.graph;

import java.util.ArrayList;

public class FindAllNodesInPathGraph {
    public static void main(String[] args) {
        FindAllNodesInPathGraph this_class_obj = new FindAllNodesInPathGraph();
        Graph g = this_class_obj.new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(2, 0);
        g.addEdge(2, 1);
        g.addEdge(1, 3);

        // arbitrary source
        int s = 2;

        // arbitrary destination
        int d = 3;

        System.out.println(
                "Following are all different paths from "
                        + s + " to " + d);
        g.printAllPaths(s, d);
    }

    class Graph {
        int vertices;
        ArrayList<Integer>[] adjacencyList;

        public Graph(int vertices) {
            this.vertices = vertices;
            initAdjacencyList();
        }

        private void initAdjacencyList() {

            adjacencyList = new ArrayList[vertices];

            for (int i = 0; i < vertices; i++) {
                adjacencyList[i] = new ArrayList<>();
            }
        }

        public void addEdge(int sourceVertex, int destinationVertex) {
            adjacencyList[sourceVertex].add(destinationVertex);
        }

        public void printAllPaths(int sourceVertex, int destinationVertex) {
            boolean[] isVisited = new boolean[vertices];
            ArrayList<Integer> pathList = new ArrayList<>();
            pathList.add(sourceVertex);
            printAllPathsUtility(sourceVertex, destinationVertex, isVisited, pathList);
        }

        private void printAllPathsUtility(int sourceVertex,
                                          int destinationVertex,
                                          boolean[] isVisited,
                                          ArrayList<Integer> pathList) {

            if (sourceVertex == destinationVertex) {
                System.out.println(pathList);
                return;
            }

            isVisited[sourceVertex] = true;

            for (int i = 0; i < adjacencyList[sourceVertex].size(); i++) {

                int intermediateNode = adjacencyList[sourceVertex].get(i);
                if(!isVisited[intermediateNode]) {
                    pathList.add(intermediateNode);
                    printAllPathsUtility(intermediateNode, destinationVertex, isVisited, pathList);
//                    pathList.remove(intermediateNode);
                }
            }

            isVisited[sourceVertex] = false;
        }
    }
}
