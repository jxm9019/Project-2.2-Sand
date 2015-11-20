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
    private E goal;                     //Goal 
    private int start = 0;              //Start, always 0
    private int amountOfBuckets;        //Amount of buckets

    /**
     * Constructor takes in goal and amount of buckets based on number of command line arguments. 
     * Also creates array of Buckets based on amount of buckets passed.
     * @param args
     */
	public Sand (String[] args) {
    	this.amountOfBuckets = args.length-1;
    	bucketList = new Bucket[amountOfBuckets];
    	goal = (E) args[0];
    	for(int i = 1; i < args.length; i++){
    		bucketList[i] = new Bucket (Integer.parseInt(args[i]));
    	}
    }

    public Sand (Sand sand){
        for (int i = 0; i < amountOfBuckets; i++) {
            sand.setBucket(i, bucketList[i]);
        }
    }

    private void setBucket(int index, Bucket anotherBucket){
        bucketList[index].setCurSand(anotherBucket.getCurSand());
        bucketList[index].setMaxSand(anotherBucket.getMaxSand());
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
    public E getGoal() {
        return goal;
    }




    /**This program will return neighbors of a specific configuration
     *
//     * @param Object: integer of configuration whose neighbors the method is going to look for
     * @return ArrayList<Integer>: list of neighbors
     */
    @Override
    public ArrayList<Sand> getNeighbors(Object input) {
        if (input instanceof Sand){
            Sand orig = (Sand) input;
            ArrayList<Sand> successors = new ArrayList<>();
            for (int k = 0; k < bucketList.length; k++) {
                //if bucket[k] is empty then make a copy and fill it
                if(orig.bucketList[k].isEmpty()){
                    Sand copy = new Sand(orig);
                    copy.bucketList[k].fill();
                }
                //if bucket[k] is not empty then make a copy and empty it
                if(orig.bucketList[k].getCurSand() > 0){
                    Sand copy = new Sand(orig);
                    copy.bucketList[k].emptyBucket();
                    successors.add(copy);
                }
                //if bucket[k] is anything but 0 transfer to all other buckets
                if(orig.bucketList[k].getCurSand()!=0){
                    for (int j = 0; j < bucketList.length; j++) {
                        Sand copy = new Sand(orig);
                        copy.bucketList[k].transfer(copy.bucketList[j]);
                        successors.add(copy);
                    }
                }
            }
            return successors;
        }else
            return null;
    }
    //Getter of start
    @Override
    public Object getStart() {
        return start;
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
    	Sand sand = new Sand(args);
    	for(int i = 1; i < args.length; i++){
    		System.out.println(sand.getBucket(i).getMaxSand());
    		System.out.println(sand.getBucket(i).getCurSand());
    	}
    	
    }

    
    
}
