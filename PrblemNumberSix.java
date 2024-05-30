package PLATE6;
import java.util.Scanner;

public class ProblemNumberSix {
    int MargateVertices;
    int MargateMatrix[][];
    
    // Initializes the matrix
    ProblemNumberSix(int MargateVertices) { // Constructor; vertices as argument
        this.MargateVertices = MargateVertices; // vertices = number of nodes in the graph
        MargateMatrix = new int[MargateVertices][MargateVertices]; // allocate memory, adjacency matrix is a square matrix dimension to the number of nodes e.g 3 x 3 = 3 vertices
    }
    
    void MargateAddEdge(int MargateSource, int MargateDestination) { // Allow multiple edges and loops
        MargateMatrix[MargateSource][MargateDestination]++; // if the link is present then the number is added/incremented 
    }
    
    void MargatePrintGraph() {
        for (int i = 0; i < MargateVertices; i++) { // row one of the graph
            for (int j = 0; j < MargateVertices; j++) { // following column of the graph
                System.out.print(MargateMatrix[i][j] + " "); // prints out MargateMatrix[i][j] which is equal to 0 unless it is 1 then it will increment by 1	 
            } 
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter number of MargateVertices: ");
            int MargateVertices = scanner.nextInt();
            ProblemNumberSix MargateGraph = new ProblemNumberSix(MargateVertices); // connects the vertices input to ProblemNumberSix constructor so that it knows how many nodes are in the graph
            
            System.out.print("Enter number of MargateEdges: ");
            int MargateEdges = scanner.nextInt();
            
            for (int i = 0; i < MargateEdges; i++) { // code to loop edges question based on edges input
                System.out.println("Enter the MargateSource vertex: ");
                int MargateSource = scanner.nextInt();
                System.out.println("Enter the MargateDestination vertex: ");
                int MargateDestination = scanner.nextInt();
                
                MargateGraph.MargateAddEdge(MargateSource, MargateDestination); // calls upon .MargateAddEdge for the source and destination 
            }
            
            MargateGraph.MargatePrintGraph();
            
        } catch (Exception e) { // catch method made to catch error if source/destination is over the vertices given
            System.out.println("Please enter the proper source/destination: ");
            e.printStackTrace();
        }
    }
}
