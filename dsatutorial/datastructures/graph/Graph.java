package dsatutorial.datastructures.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {

    private int V; // number of vertices in Graph
    private int E; // number of edges in Graph
    private boolean[] visited;
    private Integer[] componentId;
    private int numberOfComponents;
    private LinkedList<Integer>[] adj;

    public Graph(int nodes) {
        this.V = nodes;
        this.E = 0;
        this.adj = new LinkedList[nodes];
        for (int v = 0; v < V ; v++) {
            this.adj[v] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int v) {
        this.adj[u].add(v);
        this.adj[v].add(u);
        E++;
    }

    // Breadth First Search - Level Order Traversal

    public void bfs(int s) {
        Queue<Integer> queue = new LinkedList<>();
        visited = new boolean[this.V];
        visited[s] = true;
        queue.offer(s);
        while (!queue.isEmpty()) {
            int u = queue.poll();
            System.out.print(u + " ");
            for (int v : this.adj[u]) {
                if (!visited[v]) {
                    visited[v] = true;
                    queue.offer(v);
                }
            }
        }
    }

    // Iterative Depth First Search
//    public void dfs(int s) {
//        Stack<Integer> stack = new Stack<>();
//        visited = new boolean[this.V];
//        stack.push(s);
//        while (!stack.isEmpty()) {
//            int u = stack.pop();
//            if (!visited[u]) {
//                visited[u] = true;
//                System.out.print(u + " ");
//                for (int v : adj[u]) {
//                    if (!visited[v]) {
//                        stack.push(v);
//                    }
//                }
//            }
//        }
//    }

    // Recursive Depth First Search
    public void dfs() {
        visited = new boolean[this.V];
        componentId = new Integer[this.V];
        this.numberOfComponents = 0;
        for (int v = 0; v < V; v++) {
            if (!visited[v]) {
                dfs(v, this.numberOfComponents);
                this.numberOfComponents++;
            }
        }
    }

    public void dfs(int v, int count) {
        visited[v] = true;
        componentId[v] = this.numberOfComponents;
        System.out.print(v + " ");
        for (int w : adj[v]) {
            if (!visited[w]) {
                dfs(w, this.numberOfComponents);
            }
        }
    }

    public int getNumberConnectedComponents() { // need to have run dfs() first
        return numberOfComponents;
    }

    public boolean isConnected(int x, int y) {
        return componentId[x] == componentId[y];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(V + " vertices, " + E + " edges " + "\n");
        for (int v = 0; v < V; v++) {
            sb.append(v + ": ");
            for (int w : adj[v]) {
                sb.append(w + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

//    private int[][] adjMatrix;

//    public Graph(int nodes) {
//        this.V = nodes;
//        this.E = 0;
//        this.adjMatrix = new int[nodes][nodes];
//    }
//
//    public void addEdge(int u, int v) {
//        this.adjMatrix[u][v] = 1;
//        this.adjMatrix[v][u] = 1;
//        E++;
//    }

//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append(V + " vertices, " + E + " edges " + "\n");
//        for (int v = 0; v < V; v++) {
//            sb.append(v + ": ");
//            for (int w : adjMatrix[v]) {
//                sb.append(w + " ");
//            }
//            sb.append("\n");
//        }
//        return sb.toString();
//    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(2, 4);
        System.out.println(graph);
        graph.bfs(0);
        System.out.println();
        graph.dfs();
        System.out.println("\nNumber Of Components: " + graph.getNumberConnectedComponents());
        System.out.println(graph.isConnected(2, 4));
    }
}
