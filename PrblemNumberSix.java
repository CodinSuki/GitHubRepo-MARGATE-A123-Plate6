package PLATE6;
import java.util.Scanner;

public class MargatePrblemNumberSix {
    int Margatevertices;
    int matrix[][];
    //initializes the mtrix	
    MargatePrblemNumberSix(int Margatevertices){ // Constructor; vertices as argument
        this.Margatevertices = Margatevertices; // vertices = number of nodes in the graph
        matrix = new int[Margatevertices][Margatevertices]; // allocate memory, adjacency matrix is a square matrix dimension to the number of nodes e.g 3 x 3 = 3 Margatevertices
    }
    
    void addEdge(int source, int destination) { // Allow multiple edges and loops
        matrix[source][destination]++; //if the link is present then the number is added/incremented 
    }
    
    void printGraph() {
        for (int i = 0; i < Margatevertices; i++) { //row oone of the graph
        	for (int j = 0; j < Margatevertices; j++) { //foollowing column of the graph
                System.out.print(matrix[i][j] + " "); //prints out matrix[i][j] which is equal to 0 unless it is 1 then it will increment by 1	 
            } 
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter number of vertices: ");
            int MargateMargatevertices = scanner.nextInt();
            MargatePrblemNumberSix graph = new MargatePrblemNumberSix(Margatevertices); //connects the vertices input to prroblem number six constructor so that it knows
            System.out.print("Enter number of Margateedges: ");		//how many nodes are in the graph
            int Margateedges = scanner.nextInt();
            
            for (int i = 0; i < Margateedges; i++) { //code to looop edges question based on edges input
                System.out.println("Enter the source vertex: ");
                int source = scanner.nextInt();
                System.out.println("Enter the destination vertex: ");
                int destination = scanner.nextInt();
                
                graph.addEdge(source, destination); //calls upon .addEdge for the source and destination 
            }
            
            graph.printGraph();
            
        } catch(Exception e) { // catch method made to catch error if source/destination is overr the vertices given
        	System.out.println("Please enter the proper source/destination: ");
        	e.printStackTrace();
        	
        }
    
     
    }
   
}
