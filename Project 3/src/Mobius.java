import java.util.ArrayList;

/*
 * Mobius.java
 *
 * Version:
 * $Id: Mobius.java,v 1.2 2015/10/22 23:55:06 ju7847 Exp $
 * Revisions:
 * $Log: Mobius.java,v $
 * Revision 1.2  2015/10/22 23:55:06  ju7847
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
 * ID: ju7847
 * CS For Transfers
 * Project2
 *
 * This is the Mobius class. Implements Puzzle to solve a Mobius puzzle.
 */

public class Mobius implements Puzzle {

    //Fields for range, start and goal of puzzle
    private static int rangeM;
    private static int startM;
    private static int goalM;
    
    //Constructor takes in a range, start and goal.
    public Mobius(int range, int start, int goal){
        rangeM = range;
        startM = start;
        goalM = goal;
    }
    
    //Getter of goal
    @Override
    public int getGoal() {
        return goalM;
    }
    
    //Getter of start
    @Override
    public int getStart(){
        return startM;
    }
    
    //Getter of range
    public int getRange(){
        return rangeM;
    }

    
/*********************************************************************************************************************/
    
    
    /**
     *  Finds neighbors of given config
        @param int: number you want to find neighbors of
        @return ArrayList<Integer>: a list of neighbors
      */
    @Override
    public ArrayList<Integer> getNeighbors( int config ) {
        //List to hold neighbors
        ArrayList<Integer> neighbors = new ArrayList<Integer>();
        
        
        int leftNeighbor;
        int rightNeighbor;
        
        /*
         * If config is 1, left neighbor should be the range, right should be 2
         * If config is size range, right neighbor should be 1, left should be range -1
         * else, substract 1 for left, add 1 for right
         */
        if (config == 1){
            leftNeighbor = rangeM;
            rightNeighbor = 2;
        //If
        } else if (config == rangeM){
            rightNeighbor = 1;
            leftNeighbor = rangeM - 1;
        } else {
            leftNeighbor = config - 1;
            rightNeighbor = config + 1;
        }
        
        //Adding neighbors to array list, and returning array list
        neighbors.add(leftNeighbor);
        neighbors.add(rightNeighbor);
        return neighbors;
        
    }
    /**
     *  Returns object string value
        @return String: object string values
      */
    public String toString(){
        return rangeM + " " + startM + " " + goalM;
        
    }
    
    //Main method to test program
    public static void main (String [] args){
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
        Mobius mob = new Mobius (range, start, goal);
        
        //Solving puzzle
        Solver solver = new Solver();
        path = solver.solver(mob);
        
        //Printing values
        System.out.println("Mobius " + mob.toString());
        for(int b: path){
            System.out.println("Step " +  step + ": " + b);
            step++;
        }
        
        
    }
}
