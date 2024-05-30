package PLATE6;

import java.util.Scanner;

public class ProblemNumberFour {
    int MargateVertices;
    int[][] MargateMatrix;
    
    // Initializes the matrix
    ProblemNumberFour(int MargateVertices) {  // Constructor; vertices as argument
        this.MargateVertices = MargateVertices; // vertices = number of nodes in the graph
        MargateMatrix = new int[MargateVertices][MargateVertices]; // Allocate memory for the adjacency matrix
    }
    
    // Adds an edge to the undirected graph
    void MargateAddEdge(int MargateSource, int MargateDestination) {  // Method to add an edge
        MargateMatrix[MargateSource][MargateDestination]++;
        MargateMatrix[MargateDestination][MargateSource]++; // For undirected graph add the edge in both directions
    }
    
    // Calculates and prints the degree of each vertex
    void MargatePrintDegrees() {
        for (int i = 0; i < MargateVertices; i++) {
            int MargateDegree = 0; // Initialize degree as 0
            for (int j = 0; j < MargateVertices; j++) {
                MargateDegree += MargateMatrix[i][j]; // Sum of row elements gives the degree of the vertex
            }
            System.out.println("Degree of vertex " + i + " is: " + MargateDegree);
        }
    }
    
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in) {
            System.out.print("Enter number of MargateVertices: ");
            int MargateVertices = scanner.nextInt();
            ProblemNumberFour graph = new ProblemNumberFour(MargateVertices); 
            
            System.out.print("Enter number of MargateEdges: ");
            int MargateEdges = scanner.nextInt();
            
            for (int i = 0; i < MargateEdges; i++) {
                System.out.print("Enter the MargateSource vertex: ");
                int MargateSource = scanner.nextInt();
                System.out.print("Enter the MargateDestination vertex: ");
                int MargateDestination = scanner.nextInt();
                
                graph.MargateAddEdge(MargateSource, MargateDestination); 
            }
           
            graph.MargatePrintDegrees(); 
            
       
        }
    }
}
