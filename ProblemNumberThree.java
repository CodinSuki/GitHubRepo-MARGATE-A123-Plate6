package PLATE6;
import java.util.Scanner;

public class ProblemNumberThree {
    int vertices;
    int matrix[][];
    //initializes the mtrix	
    ProblemNumberThree(int vertices){ // Constructor; vertices as argument
        this.vertices = vertices; //vertices = number of nodes in the graph
        matrix = new int[vertices][vertices]; //allocate memory, adjacency matrix is a square matrix dimension to the number of nodes e.g 3 x 3 = 3 vertices
    }
    
    void addEdge(int source, int destination) { // Allow multiple edges and loops
        matrix[source][destination]++; //if the link is present then the number is added/incremented 
    }
  
    
    boolean DepthFirstSearch (int vertex, boolean[] visited, int Main) { //
    	visited[vertex] = true;
    	 for (int i = 0; i < vertices; i++) { //code goes throouugh all vertices/edges /cooobnnections	
             if (matrix[vertex][i] > 0) { //vhecks if vertex has an edge and if yes then
                 if (!visited[i]) { // it will check If the vertex is not visited
                     if (DepthFirstSearch(i, visited, vertex)) {//then if it hasnt then it will result in rrepeating  making i as int and marking verrtex as 
                         return true;								//the parent 	
                     }
                 } else if (i != Main) { //iif an adjacent vertex is visited again and not a parent of current vertex there is a cycle
                     return true;
                 }
             }
         }
         return false;
     }
    
    void checkCycle() {
        boolean[] visited = new boolean[vertices]; //initialize an array to know what has been visited or not
        for (int i = 0; i < vertices; i++) { //loops thrrough all vertices
            if (!visited[i]) { //Dont recur for already visited vertices
                if (DepthFirstSearch(i, visited, -1)) { //visited is true, verrtex has been visited, and -1 so that it indicatees starting point 
                    System.out.println("Graph contains a cycle"); // prints if visited is true, through out i has been visited and rresulted into true 
                    return;										  //-1 is initiated to avoid main node/parent confusioon soo its intiatilized as the startign point
                }
            }
        }
        System.out.println("Graph does not contain a cycle");
    }
    
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter number of Vertices: ");
            int vertices = scanner.nextInt();
            ProblemNumberThree graph = new ProblemNumberThree(vertices); //connects the vertices input to prroblem number six constructor so that it knows
            System.out.print("Enter number of Edges: ");		//how many nodes are in the graph
            int edges = scanner.nextInt();
            
            for (int i = 0; i < edges; i++) { //code to looop edges question based on edges input
                System.out.println("Enter the source vertex: ");
                int source = scanner.nextInt();
                System.out.println("Enter the destination vertex: ");
                int destination = scanner.nextInt();
                
                graph.addEdge(source, destination); //calls upon .addEdge for the source and destination 
            }
            
            graph.checkCycle(); 
            
        } catch(Exception e) { // catch method made to catch error if source/destination is overr the vertices given
        	System.out.println("Please enter the proper source/destination: ");
        	e.printStackTrace();
        	
        }
    
     
    }
   
}
