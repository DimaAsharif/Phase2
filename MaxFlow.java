/**
 *Question 2 Task 1
 * This program is designed to find the maximum flow and the Corresponding minimum cut
 * of a given graph represented by its adjacency matrix
 *
 */

import java.util.LinkedList;

  /** the weighted directed graph :{ {0, 2, 7, 0, 0, 0},
                                     {0, 0, 0, 3, 4, 0},
                                     {0, 0, 0, 4, 2, 0},
                                     {0, 0, 0, 0, 0, 1},
                                     {0, 0, 0, 0, 0, 5},
                                     {0, 0, 0, 0, 0, 0}
                                   };**/
        


public class MaxFlow {
        WeightedGraph graph = new WeightedGraph(6);
       int V = graph.Length();
      int rgraph[][]=graph.Graphmatrix();
      
    /** We will use BFS as supporting method to find the max-flow 
     * 
     * @param rgraph
     * @param source
     * @param sink
     * @param parent
     * @return true if we reached sink in BFS starting from source, or false otherwise 
    */
    public boolean bfs(int rgraph[][], int source, int sink, int parent[]) {
         
          //Create a visited array and mark all vertices as not visited
         
        boolean visited[] = new boolean[V];
        for(int i=0; i<V; ++i)
            visited[i]=false;
        // Create a queue, and add source vertex to it  and mark
         // source vertex as visited
         
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source] = true;
        parent[source]=-1;
        // Standard BFS Loop
        while (!queue.isEmpty())
        {
            int u = queue.poll();
            for (int v=0; v<V; v++)
            {
                if (visited[v]==false && rgraph[u][v] > 0)
                {
                    queue.add(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            }
        }
        //If we reached sink in BFS starting from source, then return true, else false
         
        return (visited[sink] == true);
    }
      /**We use EdmondsKarp algorithm which is implementation of Ford-Fulkerson method
       *  for computing maximum flow and the Corresponding minimum cut and print it
       * 
       * @param rgraph
       * @param source
       * @param sink 
       */  
    public void EdmondsKarp( int rgraph[][], int source, int sink)
    {
        System.out.println("\n------------------------------ EDMONDS-KARP ALGORITHM --------------------------\n");

        System.out.println("\t\t Maximum flow");
        System.out.println("--------------------------------------------\n");
        System.out.println("\t   Augiminting paths:\n");
        int u, v;
        
        
        // We Create a residual graph and fill the residual graph
         // with given capacities in the original graph as
         // residual capacities in residual graph
 		
       
        int Residual_Graph[][] = new int[V][V];// Residual graph indicates
        for (u = 0; u < V; u++)
            for (v = 0; v < V; v++)
                Residual_Graph[u][v] = rgraph[u][v];
        // This array is filled by BFS and to store path
        int parent[] = new int[V];
        int max_flow = 0;  // There is no flow initially
     
        
        while (bfs(Residual_Graph, source, sink, parent))
        {
            String path = "";
            
           
             //find the maximum flow through the path found.
             
            int pathFlow = Integer.MAX_VALUE;
            for (v=sink; v!=source; v=parent[v])
            {
                String direction="←";
                u = parent[v];
                pathFlow =  Math.min(pathFlow ,Residual_Graph[u][v]);
                if(rgraph[u][v]!=0) direction="→";
                path=direction+(v+1)+path;
            }
            path=(v+1)+path;
            System.out.printf("%-17s %s %d \n",path,"flow: ",pathFlow);
            
            //update residual capacities of the edges and reverse edges along the path
            
            for (v=sink; v != source; v=parent[v])
            {
                u = parent[v];
                Residual_Graph[u][v] -= pathFlow;
                Residual_Graph[v][u] += pathFlow;
            }
            // Add path flow to overall flow
            max_flow += pathFlow;
            System.out.println("Updated flow: "+max_flow+"\n");
            
        }
        
        // print max-flow
        System.out.println("\t  The maximum flow is " + max_flow);
        System.out.println("\n\n\t\t Minimum cut");
        System.out.println("--------------------------------------------");
        // print min-cut edges
        System.out.println("\n\t Edges included in the min-cut");
        boolean[] isVisited = new boolean[graph.Length()];      
        dfs(Residual_Graph, source, isVisited); 
          
        // Print all edges that are from a reachable vertex to 
        // non-reachable vertex in the original graph
        int total_cut=0;
        for (int i = 0; i < graph.Length(); i++) { 
            for (int j = 0; j < graph.Length(); j++) { 
                if (rgraph[i][j] > 0 && isVisited[i] && !isVisited[j]) { 
                    System.out.print("\nEdge: "+(i+1) + "-" + (j+1)); 
                    System.out.println(" , capacity = "+rgraph[i][j]);
                    total_cut+=rgraph[i][j];
                    System.out.println("Updated min-cut capicity: "+total_cut);
                } 
            } 
        }
        System.out.println("\n\tThe total min-cut capacity is " + total_cut + "\n");
    }
    
    /**DFS supporting method to find the min-cut
     * 
     * @param graph
     * @param s
     * @param visited 
     */
    public void dfs(int [][] graph, int s, boolean[]visited){
        visited[s]=true;
        for (int i = 0; i < graph.length; i++) {
            if(graph[s][i]>0&&!visited[i])
                dfs(graph,i,visited);
        }
    } 
}

