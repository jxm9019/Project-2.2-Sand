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
 * @author Jean Luis Urena 
 * ID: ju7847
 * CS For Transfers
 * Project 3
 *
 */

public class Sand implements Puzzle {
    
    private ArrayList<Bucket> neighbors;
    private int goal;
    private final int start = 0;
    
    public Sand (int goal) {
        neighbors = new ArrayList<Bucket>();
        neighbors.add(new Bucket(goal));
        
    }

    /* (non-Javadoc)
     * @see Puzzle#getGoal()
     */
    @Override
    public int getGoal() {
        return goal;
    }

    /* (non-Javadoc)
     * @see Puzzle#getNeighbors(int)
     */
    @Override
    public ArrayList getNeighbors( int config ) {
        return null;
    }

    /* (non-Javadoc)
     * @see Puzzle#getStart()
     */
    @Override
    public int getStart() {
        return 0;
    }

    
    public ArrayList<Bucket []> listOfSolutions(String[] list){
        Bucket [] bucketSolutions = new Bucket [list.length];
        ArrayList<Bucket []> listOfSolutions = new ArrayList<>();
        
        for(int i = 0; i < list.length; i ++){
            int j = i;
            while(j < list.length){
                /*
                 * Fill -> transfer ->dump
                 */
                
            }
            
        }
        
    }
}
