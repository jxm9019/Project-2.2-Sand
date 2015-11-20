import java.util.ArrayList;


/*
 * Sand.java
 *
 * Version:
 * $Id$
 * Revisions:
 * $Log$
 */

/**
 * @author Jake Madlam
 * @author Jean Luis Urena 
 * ID: ju7847
 * CS For Transfers
 * Project 3
 *
 */

public class Sand implements Puzzle {
    
    private Bucket bucketList [];       //Array to hold list of buckets from command line
    private int goal;                   //Goal 
    private final int start = 0;        //Start, always 0
    private int amountOfBuckets;        //Amount of buckets
    
    
    /**
     * Constructor takes in goal and amount of buckets based on number of command line arguments. 
     * Also creates array of Buckets based on amount of buckets passed.
     * @param goal
     * @param amountOfBuckets
     */
    public Sand (int goal, int amountOfBuckets) {
    	this.amountOfBuckets = amountOfBuckets;
    	this.goal = goal;
    	bucketList = new Bucket[amountOfBuckets];
        
    }
    
    //Getter of amount of buckets
    public int getAmountOfBuckets(){
    	return amountOfBuckets;
    }
    
    //Getter of bucket list
    public Bucket [] getBucketList(){
    	return bucketList;
    }
    
    //Getter of goal
    @Override
    public int getGoal() {
        return goal;
    }


    /** This program will return neighbors of a specific configuration
     * 
     * @param int: integer of configuration whose neighbors the method is going to look for
     * @return ArrayList<Integer>: list of neighbors
     */
    @Override
    public ArrayList<Integer> getNeighbors( int config ) {
    	ArrayList<Integer> neighbors = new ArrayList<Integer>();   //List of neighbors
        int leftNeighbor = config -1;                              // Left neighbor will be on left
        int rightNeighbor = config +1;                             //Right neighbor will be on right
        
        //If there is no left neighbor
        if(config == 1){
        	neighbors.add(bucketList[rightNeighbor].getMaxSand());
        	
        //Else if there is no right neighbor
        } else if (bucketList[rightNeighbor] == null){
        	neighbors.add(bucketList[leftNeighbor].getMaxSand());
        	
        //else if there are neighbors on both sides
        } else {
        	neighbors.add(bucketList[leftNeighbor].getMaxSand());
        	neighbors.add(bucketList[rightNeighbor].getMaxSand());
        	
        }
        return neighbors;
        
    }


    //Getter of start
    @Override
    public int getStart() {
        return start;
    }
    
    
    /** 
     * This method will solve and give a solution for the puzzle. NOT IN THE LEAST STEPS.
     * It will use a method of Fill -> Transfer right until no longer possible -> dump last bucket on right.
     * (Repeat)
     * 
     * @param Bucket []: Bucket list that contains all bucket objects.
     * @return ArrayList<Bucket> : list of all possible solutions using Fill -> transfer -> dump method
     */
    public ArrayList<Bucket> solution(Bucket [] bucketList){
    	return null;
    }

    
    
}
