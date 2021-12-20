
public class WeightedGraph {
     private final int numOfNodes;
    private int[][] matrix;
  

    public WeightedGraph(int numOfNodes) {
        this.numOfNodes = numOfNodes;
        matrix = new int [numOfNodes][numOfNodes];
    }
    
    public int Length(){
        return numOfNodes;
    }
    
    
    public int[][] Graphmatrix(){
        return matrix;
    }
    
    
    /**method  allows to add edges in weighted and directed graph
     * 
     * @param source
     * @param destination
     * @param weight 
     */
   public void addEdge(int source, int destination, int weight) {

    int valueToAdd = weight;

    matrix[source][destination] = valueToAdd;
  
}
   //print out the adjacency matrix
   public void printMatrix() {
    for (int i = 0; i < numOfNodes; i++) {
        for (int j = 0; j < numOfNodes; j++) {
         
                System.out.format("%8s", String.valueOf(matrix[i][j]));
        
        }
        System.out.println();
    }
}
}
