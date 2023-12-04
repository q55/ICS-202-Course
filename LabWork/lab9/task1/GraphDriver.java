package lab9.task1;

public class GraphDriver{
    public static void main(String[] args){
    // Create an undirected graph with 4 vertices
        Graph g = new Graph(4);
        // To be completed by students
    
    // Add the 5 edges of the graph
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(0, 1);
        g.addEdge(2, 3);
        g.addEdge(1, 3);
        // To be completed by students
    
    // Display the graph before deleting edge 2---3

    System.out.println("Before deleting edge 2---3 the graph is: \n");
    // To be completed by students
        g.displayGraph();
    
    // Display the graph after deleting edge 2---3

    // To be completed by students
        g.removeEdge(2,3);
    System.out.println("\nAfter deleting edge 2---3 the graph is: \n");
    // To be completed by students
        g.displayGraph();


    }
}