import javafx.beans.value.ObservableValueBase;

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

@SuppressWarnings({ "unchecked", "rawtypes" })
public class Sand <E> implements Puzzle {
    
    private Bucket bucketList [];       //Array to hold list of buckets from command line
    private ArrayList<Sand> sandList;    //ArrayList to hold sand solutions.
    private E goal;                     //Goal 
    private int start = 0;              //Start, always 0
    private int amountOfBuckets;        //Amount of buckets

    /**
     * Constructor takes in goal and amount of buckets based on number of command line arguments. 
     * Also creates array of Buckets based on amount of buckets passed.
     * @param args
     */
    public Sand (String [] args) {
    	amountOfBuckets = args.length-1;
    	bucketList = new Bucket[amountOfBuckets];
    	goal = (E) args[0];
    	for(int i = 0; i < amountOfBuckets; i++){
    		bucketList[i] = new Bucket (Integer.parseInt(args[i+1]));
    	}
    	sandList = new ArrayList<>();
    	sandList.add(this);
    }

    
    /**
     * Copy constructor, creates a copy of a Sand object
     * @param sander
     */
    public Sand (Sand sander){
    	this.amountOfBuckets = sander.amountOfBuckets;
    	this.bucketList = new Bucket[this.amountOfBuckets];
    	this.goal = (E) sander.goal;
    	
    	for (int i = 0; i < bucketList.length; i++){
    		this.bucketList[i] = new Bucket(sander.bucketList[i]);
    	}
    	this.sandList = new ArrayList<>();
    	this.sandList.add(this);
    	
        
    }
    //Getter of amount of buckets
    public int getAmountOfBuckets(){
    	return amountOfBuckets;
    }
    
    //Getter of bucket list
    public Bucket getBucket(int index){
    	return bucketList[index];
    }
    
    //Getter of goal
    @Override
    public boolean isGoal(ArrayList<E> config) {
        return(config.contains(this.goal));
    }
    //Getter of start
    @Override
    public Object getStart() {
        return this;
    }
    /**This program will return neighbors of a specific configuration
     * It will create all possible solutions and store them in an array.
     *
//     * @param Object: integer of configuration whose neighbors the method is going to look for
     * @return ArrayList<Integer>: list of neighbors
     */
    @Override
    public ArrayList<Sand> getNeighbors(Object input) {

        Sand config = (Sand)input;
//        Sand config = new Sand(input);
        ArrayList<Sand> successors = new ArrayList<>();
        for (int k = 0; k < amountOfBuckets; k++) {
        	
            //if bucket[k] is empty then make a copy and fill it
            if(config.bucketList[k].isEmpty()){
                Sand copy = new Sand(config);
                copy.getBucket(k).fill();
                System.out.println("I filled a bucket");
                successors.add(copy);
                
            }
            //if bucket[k] is not empty then make a copy and empty it
            if(config.bucketList[k].getCurSand() > 0){
            	System.out.println("I emptied a bucket");
                Sand copy = new Sand(config);
                copy.bucketList[k].emptyBucket();
                successors.add(copy);
            }
            //if bucket[k] is anything but 0 transfer to all other buckets
            if(config.bucketList[k].getCurSand()!=0){
            	System.out.println("I transferred a bucket");
                for (int j = 0; j < bucketList.length; j++) {
                    if(k!=j) {
                        Sand copy = new Sand(config);
                        copy.bucketList[k].transfer(copy.bucketList[j]);
                        successors.add(copy);
                    }
                }
            }
        }
        return successors;

    }
    

    /**
     * This method will solve and give a solution for the puzzle. NOT IN THE LEAST STEPS.
     * It will use a method of Fill -> Transfer right until no longer possible -> dump last bucket on right.
     * (Repeat)
     *
//     * @param Bucket []: Bucket list that contains all bucket objects.
     * @return ArrayList<Bucket> : list of all possible solutions using Fill -> transfer -> dump method
     */
    
    public static void main (String [] args){
        if(args.length<3) {
            System.out.println("Usage: java Sand amount bucket1 bucket2 ... ");
            System.exit(0);
        }
    	Sand sand = new Sand (args);
    	Sand sandCopy = new Sand(sand);
    	
    	ArrayList<Sand> sandNeighbor = new ArrayList<> (sand.getNeighbors(sand));

        Solver solve = new Solver();
        solve.solver(sand);


    	for (int i = 0; i < sandNeighbor.size(); i++){
    		for(Sand h: sandNeighbor)
    		System.out.println(h.getBucket(i).getCurSand());
    	}
    }
}
