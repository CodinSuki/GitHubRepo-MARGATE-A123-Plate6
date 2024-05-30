package PLATE6;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ProblemNumberFive {
    int MargateVertices;
    int[][] MargateMatrix;
    
    // Initializes the matrix
    ProblemNumberFive(int MargateVertices) { // Constructor; vertices as argument
        this.MargateVertices = MargateVertices; // vertices = number of nodes in the graph
        MargateMatrix = new int[MargateVertices][MargateVertices]; // Allocate memory for the adjacency matrix
    }
    
    // Adds an edge to the graph
    void MargateAddEdge(int MargateSource, int MargateDestination) { // Allow multiple edges and loops
        MargateMatrix[MargateSource][MargateDestination]++; // if the link is present then the number is added/incremented 
        MargateMatrix[MargateDestination][MargateSource]++; // Since the graph is undirected
    }
    
    // Checks if the graph is bipartite
    boolean MargateIsBipartite() {
        int[] MargateColors = new int[MargateVertices]; // Initialize all vertices as uncolored (0)
        for (int i = 0; i < MargateVertices; i++) {
            MargateColors[i] = -1; // -1 represents uncolored
        }
        
        for (int start = 0; start < MargateVertices; start++) {
            if (MargateColors[start] == -1) { // If the vertex is uncolored
                if (!MargateCheckBipartite(start, MargateColors)) {
                    return false; // If any component is not bipartite, return false
                }
            }
        }
        return true;
    }
    
    boolean MargateCheckBipartite(int start, int[] MargateColors) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        MargateColors[start] = 1; // Start coloring with 1
        
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v = 0; v < MargateVertices; v++) {
                if (MargateMatrix[u][v] > 0 && MargateColors[v] == -1) {
                    // If there is an edge and v is not colored
                    MargateColors[v] = 1 - MargateColors[u]; // Assign alternate color to the adjacent vertex
                    queue.add(v);
                } else if (MargateMatrix[u][v] > 0 && MargateColors[v] == MargateColors[u]) {
                    // If there is an edge and v is colored with the same color as u
                    return false;
                }
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
           Scanner scanner = new Scanner(System.in) {
            System.out.print("Enter number of Vertices: ");
            int MargateVertices = scanner.nextInt();
            ProblemNumberFive graph = new ProblemNumberFive(MargateVertices); // Connects the vertices input to ProblemNumberSix constructor
            
            System.out.print("Enter number of Edges: ");
            int MargateEdges = scanner.nextInt();
            
            for (int i = 0; i < MargateEdges; i++) { // Code to loop edges based on edges input
                System.out.println("Enter the Source vertex: ");
                int MargateSource = scanner.nextInt();
                System.out.println("Enter the Destination vertex: ");
                int MargateDestination = scanner.nextInt();
                
                graph.MargateAddEdge(MargateSource, MargateDestination); // Calls upon MargateAddEdge for the source and destination
            }
            
            if (graph.MargateIsBipartite()) {
                System.out.println("The graph is bipartite.");
            } else {
                System.out.println("The graph is not bipartite.");
            }
            
 
        }
    }
}
