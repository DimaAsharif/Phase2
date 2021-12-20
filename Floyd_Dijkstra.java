
/*
 *Question 1 Task 1 & 2
 * This program is designed to find the shortest path
 * of a given graph represented by its adjacency matrix
 */

public class Floyd_Dijkstra {
    
    /**
    *
    * @author Dima Almagayshi 
    */
    
    static final int INF = Integer.MAX_VALUE;
    
                         //  A    B    C    D    E    F    G    H    I    J    K    L    M    N    O    P    Q    R    S    T    U    V    W    X    Y
    static int[][] matrix={{ 0 , 10 , INF, INF, INF,  5 , INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF},  // A
                           {INF,  0 ,  3 , INF,  3 , INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF},  // B
                           {INF, INF,  0 ,  4 , INF, INF, INF,  5 , INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF},  // C
                           {INF, INF, INF,  0 , INF, INF, INF, INF,  4 , INF, INF, INF,  7 , INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF},  // D
                           {INF, INF,  4 , INF,  0 , INF,  2 , INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF},  // E
                           {INF,  3 , INF, INF, INF,  0 , INF, INF, INF,  2 , INF, INF, INF, INF, INF, INF,  5 ,  2 , INF, INF, INF, INF, INF, INF, INF},  // F
                           {INF, INF, INF,  7 , INF, INF,  0 , INF, INF, INF,  6 ,  3 , INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF},  // G
                           {INF, INF, INF,  4 , INF, INF, INF,  0 ,  3 , INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF},  // H
                           {INF, INF, INF, INF, INF, INF, INF, INF,  0 , INF, INF, INF,  4 , INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF,  5 },  // I
                           {INF,  6 , INF, INF, INF, INF,  8 , INF, INF,  0 , INF, INF, INF, INF,  5 ,  9 , INF, INF, INF, INF, INF, INF, INF, INF, INF},  // J    
                           {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF,  0 , INF, INF,  5 ,  6 , INF, INF, INF, INF, INF, INF, INF,  2 , INF, INF},  // K
                           {INF, INF, INF,  4 , INF, INF, INF, INF, INF, INF,  5 ,  0 ,  2 , INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF},  // L
                           {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF,  0 ,  3 , INF, INF, INF, INF, INF, INF, INF, INF, INF,  4 , INF},  // M
                           {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF,  0 , INF, INF, INF, INF, INF, INF, INF, INF, INF,  7 , INF},  // N
                           {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF,  0 ,  4 , INF, INF, INF, INF, INF,  2 , INF, INF, INF},  // O
                           {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF,  0 ,  8 , INF, INF, INF,  7 , INF, INF, INF, INF},  // P
                           {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF,  0 , INF,  5 ,  7 , INF, INF, INF, INF, INF},  // Q
                           {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF,  3 ,  0 ,  6 , INF, INF, INF, INF, INF, INF},  // R
                           {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF,  0 ,  6 , INF, INF, INF, INF, INF},  // S
                           {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF,  0 ,  2 , INF, INF, INF, INF},  // T
                           {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF,  0 ,  3 , INF, INF, INF},  // U
                           {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF,  0 ,  8 , INF, INF},  // V
                           {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF,  5 , INF, INF, INF, INF, INF, INF, INF, INF,  0 , INF, INF},  // W
                           {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF,  0 ,  6 },  // X
                           {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF,  0 },  // Y
    };
    
    static String[] label = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L" , "M" , "N", "O" , "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y"};
    
    
    //---------------------------------------------------------------------------------------------------------------------
    
    
    /** This method performs Floyd alg
     *
     * @param vertices (number of vertices)
     */
    public static void Floyd_alg(int vertices) {
        
        System.out.println("------------------------------ FLOYD-WARSHALL ALGORITHM --------------------------");
        
        // printing D(0) which is equivalent to the adj matrix
        System.out.print("\t\t\t\t    D(0)\n\n\t");
        
        // printing the vertices labels 
        for (int character = 0; character < vertices; character++) {
            System.out.print(label[character] + "\t");
        }
        System.out.println();
        for (int i = 0; i < vertices; i++) {
            // printing the vertices labels
            System.out.print(label[i] + "\t");
            // print cost of each edge 
            for (int j = 0; j < vertices; j++) {
                System.out.print((matrix[i][j] == INF ? "∞" : matrix[i][j]));
                System.out.print((vertices - 1 == j ? "\n" : "\t"));
            }
        }
        System.out.println("-------------------------------------------------------------------------------------\n");
        
        
        //start time
        double startTime = System.currentTimeMillis();
        
        // FLOYD ALGORITHM
        for (int i = 0; i < vertices; i++) {
            
            System.out.print("\t\t\t\t    D(" + (i + 1) + ")\n\n\t");
            // To print the vertices labels
            for (int character = 0; character < vertices; character++) {
                System.out.print(label[character] + "\t");
            }
            System.out.println();
            
            for (int j = 0; j < vertices; j++) {
                
                System.out.print(label[j] + "\t");
                for (int k = 0; k < vertices; k++) {
                    
                    // update matrix
                    if ((matrix[j][k] > matrix[j][i] + matrix[i][k]) && (matrix[j][i] != INF && matrix[i][k] != INF)){
                        matrix[j][k] = matrix[j][i] + matrix[i][k];
                    }
                    
                    System.out.print((matrix[j][k] == INF ? "∞" : matrix[j][k]));
                    System.out.print((vertices - 1 == k ? "\n" : "\t"));
                }
            }
            
            System.out.println("-------------------------------------------------------------------------------------\n");
        }
        
        //finish time
        double finishTime = System.currentTimeMillis();
        //total time 
        System.out.println("Total runtime of FLOYD ALGORITHM is : "+(finishTime-startTime)+" ms.");
        
        // END OF FLOYD ALGORITHM
    }
    
    
    //-----------------------------------------------------------------------------------------------------------------------

    
    /** This method performs Dijkstra alg
     *
     * @param vertices (number of vertices)
     * @param source vertex
     */
    public static void dijkstra_alg(int vertices, int source) {
        
        System.out.println("\n------------------------------ DIJKSTRA ALGORITHM --------------------------");
        
        //start time
        double startTime = System.currentTimeMillis();
        
        //DIJKSTRA ALGORITHM
        boolean[] flag = new boolean[vertices]; //For visited vertices
        int[] distance = new int[vertices]; //To store distances 
        
        // initialize flag and distance arrays
        for (int i = 0; i < vertices; i++) {
            flag[i] = false;
            distance[i] = Integer.MAX_VALUE;
        }
        
        // Distance from source to source is zero
        distance[source] = 0;
        
        int u;
        for (int i = 0; i < vertices; i++) {
            // Update the distance between neighbouring vertex and source vertex
            u = findMinimumDistance(distance, flag);
            flag[u] = true;
            
            // Update all the neighbouring vertex distances
            for (int v = 0; v < vertices; v++) {
                if (!flag[v] && matrix[u][v] != 0 && matrix[u][v] != INF &&(distance[u] + matrix[u][v] < distance[v])) {
                    distance[v] = distance[u] + matrix[u][v];
                }
            }
        }
        
        //finish time
        double finishTime = System.currentTimeMillis();
            
        // printing final distances
        System.out.println("\nShortest distances from "+ label[source] +" to all other vertices are:");
        for (int i = 0; i < distance.length; i++) {
            if(!label[source].equals( label[i]))
            System.out.println("Distance from "+label[source]+" to "+label[i]+" is "+distance[i]);
        }
        
        //Total time 
        System.out.println("\nTotal runtime of DIJKSTRA ALGORITHM is : "+(finishTime-startTime)+" ms.");

        //END OF DIJKSTRA ALGORITHM
    }
    
    
    //----------------------------------------------------------------------------------------------------------------------------
    
    
    /**Used to find the minimum distance
     *
     * @param distance
     * @param flag
     * @return label location in array
     */
    public static int findMinimumDistance(int[] distance, boolean[] flag) {
        
        int minimumDistance = Integer.MAX_VALUE;
        int vertex = -1;
        
        for (int i = 0; i < distance.length; i++) {
            if (!flag[i] && distance[i] < minimumDistance) {
                minimumDistance = distance[i];
                vertex = i;    
            }
        }
        return vertex;
    }
}
