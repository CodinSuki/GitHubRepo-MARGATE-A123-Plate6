package PLATE6;
import java.util.Scanner;

public class ProblemNumberFour {
    int vertices;
    int matrix[][];
    
    // Initializes the matrix
    ProblemNumberFour(int vertices){  // Constructor; vertices as argument
        this.vertices = vertices; // vertices = number of nodes in the graph
        matrix = new int[vertices][vertices]; // Allocate memory for the adjacency matrix
    }
    
    // Adds an edge to the undirected graph
    void addEdge(int source, int destination) {  // Constructor; int source and int destination as arguments
        matrix[source][destination]++; 
        matrix[destination][source]++; //for undirected graph aadd the edge in both directions
    }
    
    // Calculates and prints the degree of each vertex
    void printDegrees() {
        for (int i = 0; i < vertices; i++) {
            int degree = 0; //initialize degreee as 0 in the for loop so that it also iterates with the
            for (int j = 0; j < vertices; j++) { // loop so that its value is kept after it has been added
                degree += matrix[i][j]; // Sum of row elements gives the degree of the vertex
            }
            System.out.println("Degree of vertex " + i + " is: " + degree);
        }
    }
    
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter number of Vertices: ");
            int vertices = scanner.nextInt();
            ProblemNumberFour graph = new ProblemNumberFour(vertices); 
            
            System.out.print("Enter number of Edges: ");
            int edges = scanner.nextInt();
            
            for (int i = 0; i < edges; i++) {
                System.out.println("Ent	er the source vertex: ");
                int source = scanner.nextInt();
                System.out.println("Enter the destination vertex: ");
                int destination = scanner.nextInt();
                
                graph.addEdge(source, destination); 
            }
           
            graph.printDegrees(); 
            
        } catch(Exception e) {
            System.out.println("Please enter the proper source/destination: ");
            e.printStackTrace();
        }
    }
}
