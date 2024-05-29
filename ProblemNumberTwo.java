package PLATE6;

import java.util.Scanner;

public class ProblemNumberTwo {
    int MargateVertices;
    int[][] MargateMatrix;
    
    ProblemNumberTwo(int MargateVertices) { // Constructor; vertices as argument
        this.MargateVertices = MargateVertices; // vertices = number of nodes in the graph
        MargateMatrix = new int[MargateVertices][MargateVertices]; // allocate memory
    }
    
    void MargateInputMatrix(Scanner scanner) { // Method to input the adjacency matrix
        System.out.println("Enter the adjacency matrix:");
        for (int i = 0; i < MargateVertices; i++) {
            for (int j = 0; j < MargateVertices; j++) {
                MargateMatrix[i][j] = scanner.nextInt();
            }
        }
    }
    
    void MargateListEdges() { // counts the times each edge appears
        System.out.println("Edges and their counts:");
        for (int i = 0; i < MargateVertices; i++) {
            for (int j = 0; j < MargateVertices; j++) {
                if (MargateMatrix[i][j] > 0) { // checks if the number in MargateMatrix[i][j] is greater than 0
                    System.out.println("Edge from " + i + " to " + j + " appears " + MargateMatrix[i][j] + " times");
                }
            }
        }
    }
    
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter number of MargateVertices: ");
            int MargateVertices = scanner.nextInt();
            ProblemNumberTwo graph = new ProblemNumberTwo(MargateVertices);
            
            graph.MargateInputMatrix(scanner); // inputting the matrix using the scanner
            graph.MargateListEdges(); // listing the edges
        }
    }
}
