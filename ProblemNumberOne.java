import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProblemNumberOne {
    int vertices;
    List<List<Integer>> adjList;
    
    ProblemNumberOne(int vertices) { // Constructor; vertices as argument
        this.vertices = vertices; // vertices = number of nodes in the graph
        adjList = new ArrayList<>(); // initialize adjacency list
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }
    
    void addEdge(int u, int v) { // Method to add an edge
        adjList.get(u).add(v);
        adjList.get(v).add(u); // Since the graph is undirected
    }

    void inputEdges(Scanner scanner) { // Method to input edges
        System.out.println("Enter number of edges:");
        int edges = scanner.nextInt();
        System.out.println("Enter the edges (u v):");
        for (int i = 0; i < edges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            addEdge(u, v);
        }
    }

    void DFS(int v, boolean[] visited) { // Depth-First Search to mark connected vertices
        visited[v] = true;
        for (int neighbor : adjList.get(v)) {
            if (!visited[neighbor]) {
                DFS(neighbor, visited);
            }
        }
    }
    
    boolean isConnected() { // Method to check if the graph is connected
        boolean[] visited = new boolean[vertices];
        DFS(0, visited); // Start DFS from the first vertex
        for (boolean vertex : visited) {
            if (!vertex) {
                return false; // If any vertex is not visited, graph is not connected
            }
        }
        return true;
    }
    
    int countConnectedComponents() { // Method to count the number of connected components
        boolean[] visited = new boolean[vertices];
        int count = 0;
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                DFS(i, visited); // Start DFS from the unvisited vertex
                count++; // Increment the count of connected components
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter number of vertices: ");
            int vertices = scanner.nextInt();
            ProblemNumberOne graph = new ProblemNumberOne(vertices);
            
            graph.inputEdges(scanner); // Inputting the edges
            
            if (graph.isConnected()) {
                System.out.println("The graph is connected.");
            } else {
                System.out.println("The graph is not connected.");
                int components = graph.countConnectedComponents();
                System.out.println("The number of connected components is: " + components);
            }
        }
    }
}
