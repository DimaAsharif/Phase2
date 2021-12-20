/**
 *Question 2 Task 2
 * This program is designed to find Maximum number of 
 * applicants that can be assigned to hospitals
 */

import java.util.ArrayList;

/**
 * @author Aseel Fahad 
 */

public class maxBipartite {
    String[] ListOfApplicants = {"Ahmed", "Mahmoud", "Eman", "Fatimah", "Kamel", "Nojood"};
    String[] ListOfHospitals = {"King Abdelaziz University", "King Fahd", "East Jeddah", "King Fahad Armed Forces", "King Faisal Specialist", "Ministry of National Guard"};
    ArrayList<Integer> matchingSet = new ArrayList<>();
    int M = ListOfApplicants.length, N = ListOfHospitals.length;
    //A graph with M applicant and N hospitals
    int[][] GraphOfBipartite = new int[][]{
        {1, 1, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 1},
        {1, 0, 0, 1, 0, 0},
        {0, 0, 1, 0, 0, 0},
        {0, 0, 0, 1, 1, 0},
        {0, 0, 0, 0, 0, 1}
    };
    int applicants[] = new int[N];
    
    
    //-------------------------------------------------------------------------------------------------------------------
    
    
    /**Method to check if a matching for applicant is possible
    *
    * @param theApplicant
    * @param visited
    * @param assigningArray
    * @return true if a match is found
    */
    public boolean bipartiteMatch(int theApplicant, boolean visited[], int[] assigningArray) {
        //for all hospital 0 to N-1
        for (int theHospital = 0; theHospital < N; theHospital++) {
            //when hospital theHospital is not visited and theApplicant is interested
            if (GraphOfBipartite[theApplicant][theHospital] == 1 && !visited[theHospital]) {
                //mark as hospital theHospital is visited
                visited[theHospital] = true;
                //when theHospital is not assigned or previously assigned
                if (assigningArray[theHospital] < 0 || bipartiteMatch(assigningArray[theHospital], visited, assigningArray)) {
                    //assign hospital theHospital to applicant theApplicant
                    assigningArray[theHospital] = theApplicant;
                    System.out.println(ListOfApplicants[theApplicant] + " is assigned to " + ListOfHospitals[theHospital] + "\n");
                    // add the edge to matching matching set
                    matchingSet.set(theApplicant, theHospital); 
                    applicants[theHospital] = theApplicant;
                    return true;
                }
            }
        }
        return false;
    }
    
    
    //---------------------------------------------------------------------------------------------------------------
    
    
    /**Method to return the number of matching found in the graph
    *
    * @return the number of found matching
    */
    public int maxMatch() {
        System.out.println("\n------------------------------ MAXIMUM BIPARTITE ALGORITHM --------------------------");
        //an array to track which hospital is assigned to which applicant
        int[] assigningArray = new int[N];
        for (int i = 0; i < N; i++){
            //set all jobs as available
            assigningArray[i] = -1;
            //matching set initializing
            matchingSet.add(-1); 
        }
        int CounterOfMatch = 0;
        //for all applicants
        for (int theApplicant = 0; theApplicant < M; theApplicant++) {
            boolean visited[] = new boolean[N];
            //when theApplicant assigned to a hospital
            if (bipartiteMatch(theApplicant, visited, assigningArray)) {
                System.out.println("Set matching: \n{");
                for (int i = 0; i < matchingSet.size(); i++) {
                    if (matchingSet.get(i) > -1) {
                        System.out.print("(" + ListOfApplicants[i] + " - " + ListOfHospitals[matchingSet.get(i)] + ") \n");
                    }
                }
                System.out.println("}\n------------------------------------------------------------");
                CounterOfMatch++;
            }
        }
        return CounterOfMatch;
    }
}