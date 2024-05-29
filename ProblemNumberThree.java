package PLATE6;

import java.util.Scanner;

public class ProblemNumberThree {
    int MargateVertices;
    int[][] MargateMatrix;

    ProblemNumberThree(int MargateVertices) { // Constructor
        this.MargateVertices = MargateVertices;
        MargateMatrix = new int[MargateVertices][MargateVertices];
    }
    
    void MargateAddEdge(int source, int destination) { // Method to add an edge
        MargateMatrix[source][destination]++;
    }

    boolean MargateDepthFirstSearch(int vertex, boolean[] MargateVisited, int parent) {
        MargateVisited[vertex] = true;
        for (int i = 0; i < MargateVertices; i++) {
            if (MargateMatrix[vertex][i] > 0) { // Check if there is an edge
                if (!MargateVisited[i]) { // If vertex is not visited
                    if (MargateDepthFirstSearch(i, MargateVisited, vertex)) {
                        return true;
                    }
                } else if (i != parent) { // If an adjacent vertex is visited and not parent
                    return true;
                }
            }
        }
        return false;
    }
    
    void MargateCheckCycle() {
        boolean[] MargateVisited = new boolean[MargateVertices];
        for (int i = 0; i < MargateVertices; i++) {
            if (!MargateVisited[i]) { // If the vertex is not visited
                if (MargateDepthFirstSearch(i, MargateVisited, -1)) {
                    System.out.println("Graph contains a cycle");
                    return;
                }
            }
        }
        System.out.println("Graph does not contain a cycle");
    }
    
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in) {
            System.out.print("Enter number of Vertices: ");
            int MargateVertices = scanner.nextInt();
            ProblemNumberThree graph = new ProblemNumberThree(MargateVertices);
            System.out.print("Enter number of Edges: ");
            int MargateEdges = scanner.nextInt();
            
            for (int i = 0; i < MargateEdges; i++) {
                System.out.print("Enter the source vertex: ");
                int MargateSource = scanner.nextInt();
                System.out.print("Enter the destination vertex: ");
                int MargateDestination = scanner.nextInt();
                
                graph.MargateAddEdge(MargateSource, MargateDestination);
            }
            
            graph.MargateCheckCycle();
     
        }
    }
}
