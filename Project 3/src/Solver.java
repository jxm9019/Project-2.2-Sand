import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author Jean Luis Urena ju7847
 * @author Jake Madlem     jxm9019
 *
 * CS For Transfers
 * Project3
 *
 * This solver class contains method to solve Mobius puzzle.
 */

public class Solver <E>  {


    /****************************************************************
     //Have to use something other than an array list!!!!!!
     **********************************************************/
    public ArrayList<E> solver (Puzzle<E> puzzle){
        //Array list of array list of integers
        HashSet<E> visitSet = new HashSet<>();
        ArrayList<ArrayList<E>> queue = new ArrayList<>();
        ArrayList<E> startConfig = new ArrayList<>();
        //ArrayList to hold current path
        ArrayList<E> current = new ArrayList<>();
        //Adding starting number to start config
        startConfig.add((puzzle.getStart()));
        //Enqueue'ing startConfig
        queue.add(startConfig);
        //Adds first config to visited list
        visitSet.add(puzzle.getStart());
        //checking if starting config is the ending config
        boolean found;
        if (puzzle.getStart() == puzzle.getGoal()){
            current = queue.remove(0);
            found = true;
        }else
            found = false;
        while(!queue.isEmpty() && !found){
            //dequeue'ing the front element from the queue and setting to current
            current = queue.remove(0);
            //for each neighbor of the last element in current
            for (E iterator: puzzle.getNeighbors(current.get(current.size()-1))){
                //if the config hasn't been visited yet
                if(!visitSet.contains(iterator)) {
                    //next config a copy of current
                    ArrayList<E> nextConfig = new ArrayList<>(current);
                    //appending neighbors to nextConfig
                    nextConfig.add(iterator);
                    if (iterator == puzzle.getGoal()) {
                        current = nextConfig;
                        found = true;
                        break;
                    } else {
                        queue.add(nextConfig);
                    }
                    visitSet.add(iterator);
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
