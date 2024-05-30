import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProblemNumberOne {
    int MargateVertices;
    List<List<Integer>> MargateAdjList;
    
    ProblemNumberOne(int MargateVertices) { // Constructor; vertices as argument
        this.MargateVertices = MargateVertices; // vertices = number of nodes in the graph
        MargateAdjList = new ArrayList<>(); // initialize adjacency list
        for (int i = 0; i < MargateVertices; i++) {
            MargateAdjList.add(new ArrayList<>());
        }
    }
    
    void MargateAddEdge(int u, int v) { // Method to add an edge
        MargateAdjList.get(u).add(v);
        MargateAdjList.get(v).add(u); // Since the graph is undirected
    }

    void MargateInputEdges(Scanner scanner) { // Method to input edges
        System.out.println("Enter number of Edges:");
        int MargateEdges = scanner.nextInt();
        System.out.println("Enter the edges (u v):");
        for (int i = 0; i < MargateEdges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            MargateAddEdge(u, v);
        }
    }

    void MargateDFS(int v, boolean[] MargateVisited) { // Depth-First Search to mark connected vertices
        MargateVisited[v] = true;
        for (int neighbor : MargateAdjList.get(v)) {
            if (!MargateVisited[neighbor]) {
                MargateDFS(neighbor, MargateVisited);
            }
        }
    }
    
    boolean MargateIsConnected() { // Method to check if the graph is connected
        boolean[] MargateVisited = new boolean[MargateVertices];
        MargateDFS(0, MargateVisited); // Start DFS from the first vertex
        for (boolean vertex : MargateVisited) {
            if (!vertex) {
                return false; // If any vertex is not visited, graph is not connected
            }
        }
        return true;
    }
    
    int MargateCountConnectedComponents() { // Method to count the number of connected components
        boolean[] MargateVisited = new boolean[MargateVertices];
        int MargateCount = 0;
        for (int i = 0; i < MargateVertices; i++) {
            if (!MargateVisited[i]) {
                MargateDFS(i, MargateVisited); // Start DFS from the unvisited vertex
                MargateCount++; // Increment the count of connected components
            }
        }
        return MargateCount;
    }
    
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter number of Vertices: ");
            int MargateVertices = scanner.nextInt();
            ProblemNumberOne graph = new ProblemNumberOne(MargateVertices);
            
            graph.MargateInputEdges(scanner); // Inputting the edges
            
            if (graph.MargateIsConnected()) {
                System.out.println("The graph is connected.");
            } else {
                System.out.println("The graph is not connected.");
                int MargateComponents = graph.MargateCountConnectedComponents();
                System.out.println("The number of connected components is: " + MargateComponents);
            }
        }
    }
}
