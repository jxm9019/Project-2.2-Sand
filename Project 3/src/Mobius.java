import java.util.ArrayList;
/**
 * @author Jean Luis Urena ju7847
 * @author Jake Madlem     jxm9019
 * CS For Transfers
 * Project3
 *
 * This is the Mobius class. Implements Puzzle to solve a Mobius puzzle.
 */

@SuppressWarnings("rawtypes")
public class Mobius <E> implements Puzzle {

    //Fields for range, start and goal of puzzle
    private E range;
    private E start;
    private E goal;
    
    //Constructor takes in a range, start and goal.
    public Mobius(E range, E start, E goal){
        this.range = range;
        this.start = start;
        this.goal = goal;
    }
    
    //Getter of goal
    @Override
    public boolean isGoal(E config) {
        return(this.goal==config);
    }
    
    //Getter of start
    @Override
    public E getStart(){
        return start;
    }
    
    //Getter of range
    public E getRange(){
        return range;
    }

    
/*********************************************************************************************************************/
    
    
    /**
     *  Finds neighbors of given config
//        @param int: number you want to find neighbors of
        @return ArrayList<Integer>: a list of neighbors
      */ 
    @Override
    public ArrayList<Integer> getNeighbors(Object config) {
        //List to hold neighbors
        ArrayList<Integer> neighbors = new ArrayList<Integer>();
        
        
        int leftNeighbor;
        int rightNeighbor;
        
        /*
         * If config is 1, left neighbor should be the range, right should be 2
         * If config is size range, right neighbor should be 1, left should be range -1
         * else, substract 1 for left, add 1 for right
         */
        if ((int)config   == 1){
//            leftNeighbor  = (int)range;
            rightNeighbor = 2;
        //If
        } else if (config == range){
            rightNeighbor = 1;
//            leftNeighbor  = (int)range - 1;
        } else {
            leftNeighbor  = (int) config - 1;
            rightNeighbor = (int) config + 1;
        }
        
        //Adding neighbors to array list, and returning array list
//        neighbors.add((int)leftNeighbor);
        neighbors.add((int)rightNeighbor);
        return neighbors;
        
    }
    /**
     *  Returns object string value
        @return String: object string values
      */
    public String toString(){
        return range + " " + start + " " + goal;
        
    }
    
    //Main method to test program
    public static void main (String [] args){
        if(args.length != 3){
            System.out.println("Usage: java Mobius range start goal ");
            return;
        }
        
        //List to hold path
        ArrayList<Integer> path;
        
        int step = 0;                               //Iterate steps 
        int range = Integer.parseInt(args[0]);      //Command line arguments
        int start = Integer.parseInt(args[1]);
        int goal = Integer.parseInt(args[2]);
        
        //Checking for invalid values
        if(start > range || goal > range){
            System.out.println("Usage: java Mobius range start goal ");
            return;
        }
        
        //Mobius object to solve puzzle
        Mobius<Integer> mob = new Mobius<Integer> (range, start, goal);
        
        //Solving puzzle
        Solver<Integer> solver = new Solver<Integer>();
        path = solver.solver(mob);
        
        //Printing values
        System.out.println("Mobius " + mob.toString());
        for(int b: path){
            System.out.println("Step " +  step + ": " + b);
            step++;
        }
        
        
    }
}
