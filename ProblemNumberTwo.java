package PLATE6;

import java.util.Scanner;

public class ProblemNumberTwo {
    int vertices;
    int matrix[][];
    
    ProblemNumberTwo(int vertices){ // Constructor; vertices as argument
        this.vertices = vertices; // vertices = number of nodes in the graph
        matrix = new int[vertices][vertices]; // allocate memory
    }
    
    void inputMatrix(Scanner scanner) { // Method to input the adjacency matrix
        System.out.println("Enter the adjacency matrix:"); //since vertices = nodes therefore nodes = number of rows and columns in the graph
        for (int i = 0; i < vertices; i++) { // so in this code we input matrix depending on the number of vertices
            for (int j = 0; j < vertices; j++) { // so the loop goes on depending on the number we input say 3 will = 3 x 3 
                matrix[i][j] = scanner.nextInt();  //stoores it in matrix [i][j] // number 	1 represents an edge
            }
        }
    }
    
    void listEdges() {// counts the times each edge appears 
        System.out.println("Edges and their counts:");
        for (int i = 0; i < vertices; i++) { 
            for (int j = 0; j < vertices; j++) {
                if (matrix[i][j] > 0) { //checks if the numberr in matrix i and j is greater than 0, therefore it has an edge and prints that number
                    System.out.println("Edge from " + i + " to " + j + " appears " + matrix[i][j] + " times");
                }
            }
        }
    }
    
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter number of Vertices: ");
            int vertices = scanner.nextInt();
            ProblemNumberTwo graph = new ProblemNumberTwo(vertices);
            
            graph.inputMatrix(scanner); //inputting the matrix of the scannerr 
            graph.listEdges(); //listing the edges
        }
    }
}
