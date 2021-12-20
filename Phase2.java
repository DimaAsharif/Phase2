
/** CPCS 324 project Phase 2
* Dima, Mona, Aseel
* IAR
*/

import java.util.Scanner;

public class Phase2 {
    
    /** shows a menu for user to performe experiments
     * it loops until the user chooses to exit
     * @param args
     */
    public static void main(String[] args) {
        
        int v=0;
        int testType;
        Scanner input = new Scanner(System.in);
        System.out.println("Runtime of Different Algorithms "
                         +" \n-------------------------------------------------------"
                         + "\n1- Test Floyd Algorithm and Dijkstra Algorithm"
                         + "\n2- Test Edmonds-Karp Algorithm Maximum Bipartite Matching Algorithm" 
                         + "\n3- To exit");
        
        while (true) {
            
            //user's choice of experiment
            System.out.print("\n> Enter your test choice : ");
            testType = input.nextInt();
            
            if (testType==3)
                break;
            
            switch (testType) {
                
                case 1:
                    
                    System.out.println("> Choose input case: ");
                    System.out.print(" 1- v=10\n"+
                            " 2- v=15\n"+
                            " 3- v=20\n"+
                            " 4- v=25\n"+
                            "> Enter an input case to perform the experament: ");
                    
                    //user's choice of input case
                    int userIntput = input.nextInt();
                    System.out.println();
                    
                    switch (userIntput) {
                        case 1:
                            v=10;
                            break;
                        case 2:
                            v=15;
                            break;
                        case 3:
                            v=20;
                            break;
                        case 4:
                            v=25;
                            break;
                        default:
                            System.out.println("Invalid input case!");
                    }   
                    Floyd_Dijkstra.Floyd_alg(v);
                    Floyd_Dijkstra.dijkstra_alg(v,0);
                    
                break;
                
                case 2:
                    
                    maxBipartite G = new maxBipartite();
                    System.out.println("The maximum possible number of assignments of hospitals to applicants: " + G.maxMatch() + "\n");
                    
                    WeightedGraph graph = new WeightedGraph(6);
                    graph.addEdge(0, 1, 2);
                    graph.addEdge(1, 3, 3);
                    graph.addEdge(1, 4, 4);
                    graph.addEdge(0, 2, 7); 
                    graph.addEdge(2, 3, 4);
                    graph.addEdge(2, 4, 2);
                    graph.addEdge(3, 5, 1);
                    graph.addEdge(4, 5, 5);
                    MaxFlow max = new MaxFlow();
                    max.EdmondsKarp(graph.Graphmatrix(), 0, graph.Length()-1);
                    
                break;
            }
        }
    }  
}
