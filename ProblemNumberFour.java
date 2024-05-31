package PLATE6;

import java.util.Scanner;

public class ProblemNumberFour {
    int MargateVertices;
    int[][] MargateMatrix;

    // Initializes the matrix
    ProblemNumberFour(int MargateVertices) {
        this.MargateVertices = MargateVertices;
        MargateMatrix = new int[MargateVertices][MargateVertices];
    }

    // Adds an edge to the undirected graph
    void MargateAddEdge(int MargateSource, int MargateDestination) {
        MargateMatrix[MargateSource][MargateDestination]++;
        MargateMatrix[MargateDestination][MargateSource]++;
    }

    // Calculates and prints the degree of each vertex
    void MargatePrintDegrees() {
        for (int i = 0; i < MargateVertices; i++) {
            int MargateDegree = 0;
            for (int j = 0; j < MargateVertices; j++) {
                MargateDegree += MargateMatrix[i][j];
            }
            System.out.println("Degree of vertex " + i + " is: " + MargateDegree);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of Vertices: ");
        int MargateVertices = scanner.nextInt();
        ProblemNumberFour graph = new ProblemNumberFour(MargateVertices);

        System.out.print("Enter number of Edges: ");
        int MargateEdges = scanner.nextInt();

        for (int i = 0; i < MargateEdges; i++) {
            System.out.print("Enter the Source vertex: ");
            int MargateSource = scanner.nextInt();
            System.out.print("Enter the Destination vertex: ");
            int MargateDestination = scanner.nextInt();

            graph.MargateAddEdge(MargateSource, MargateDestination);
        }

        graph.MargatePrintDegrees();
        scanner.close();
    }
}
