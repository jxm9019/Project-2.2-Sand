import java.util.ArrayList;

/*
 * Solver.java
 *
 * Version:
 * $Id: Solver.java,v 1.2 2015/10/22 23:55:05 ju7847 Exp $
 * Revisions:
 * $Log: Solver.java,v $
 * Revision 1.2  2015/10/22 23:55:05  ju7847
 * Finished project.
 * Tested thoroughly.
 *
 * Revision 1.1  2015/10/22 04:03:49  ju7847
 * Implemented Puzzle, Mobius and almost finished solver
 *
 */

/**
 * @author Jean Luis Urena ju7847
 * @author Jake Madlem     jxm9019
 *
 * CS For Transfers
 * Project2
 *
 * This solver class contains method to solve Mobius puzzle.
 */

public class Solver {

    
    
    public ArrayList<Integer> solver(Mobius mobius){
        //Array list of array list of integers
        ArrayList<ArrayList<Integer>> queue = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> startConfig = new ArrayList<Integer>(1);
        
        //ArrayList to hold current path
        ArrayList<Integer> current = new ArrayList<Integer>();
        
        //Adding starting number to start config
        startConfig.add(mobius.getStart());
        
        //Enqueue'ing startConfig
        queue.add(startConfig);
        
        //checking if starting config is the ending config
        boolean found;
        if (mobius.getStart() == mobius.getGoal()){
            current = queue.remove(0);
            found = true;
        } else {
            found = false;
        }
        
        
        while(!queue.isEmpty() && !found){
            //dequeue'ing the front element from the queue and setting to current

            current = queue.remove(0);
            
            //for each neighbor of the last element in current
            for (int iterator: mobius.getNeighbors(current.get(current.size()-1))){
                //next config a copy of current
                ArrayList<Integer> nextConfig = new ArrayList<Integer>(current);
                //appending neighbors to nextConfig
                nextConfig.add(iterator);
                if(iterator == mobius.getGoal()){
                    current = nextConfig;
                    found = true;
                    break;
                } else {
                    queue.add(nextConfig);
                }
                
                
                
            }
        }
        
        //Return array list of path if found
        if(found)
            return current;
        //Return null and print out display saying there is no solution
        else {
            System.out.println("There is no solution");
            return null;
        }
    }
}
