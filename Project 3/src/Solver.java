import java.util.ArrayList;
/**
 * @author Jean Luis Urena ju7847
 * @author Jake Madlem     jxm9019
 *
 * CS For Transfers
 * Project3
 *
 * This solver class contains method to solve Mobius puzzle.
 */

public class Solver {

    
    
    public ArrayList<Integer> solver(Puzzle puzzle){
        //Array list of array list of integers
        ArrayList<ArrayList<Integer>> queue = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> startConfig = new ArrayList<Integer>(1);
        
        //ArrayList to hold current path
        ArrayList<Integer> current = new ArrayList<Integer>();
        
        //Adding starting number to start config
        startConfig.add(puzzle.getStart());
        
        //Enqueue'ing startConfig
        queue.add(startConfig);
        
        //checking if starting config is the ending config
        boolean found;
        if (puzzle.getStart() == puzzle.getGoal()){
            current = queue.remove(0);
            found = true;
        } else {
            found = false;
        }
        
        
        while(!queue.isEmpty() && !found){
            //dequeue'ing the front element from the queue and setting to current

            current = queue.remove(0);
            
            //for each neighbor of the last element in current
            for (int iterator: puzzle.getNeighbors(current.get(current.size()-1))){
                //next config a copy of current
                ArrayList<Integer> nextConfig = new ArrayList<Integer>(current);
                //appending neighbors to nextConfig
                nextConfig.add(iterator);
                if(iterator == puzzle.getGoal()){
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
