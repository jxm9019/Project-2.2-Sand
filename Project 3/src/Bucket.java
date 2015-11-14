/**
 * @author Jean Luis Urena ju7847 
 * @author Jake Madlem     jxm9019
 * CS For Transfers
 * Project3
 *
 * This is a Bucket class. This class is to be used with Sand puzzle, Bucket is an object 
 * that holds sand, transfers to other Bucket objects, and throws out its sand.
 */
public class Bucket {
    public static final int MINSAND = 0;      //Minimum amount of sand
    private int maxSand;                      //Maximum amount of sand able to store in bucket
    private int curSand;                      //Current amount of sand in bucket

    
    /* Constructor takes in the maximum amount of sand bucket can take
     * @param int: amount of sand bucket can take
     */
    public Bucket(int maxSand){
        this.maxSand = maxSand;
        this.curSand = 0;
    }

    //Copy constructor of bucket
    public Bucket(Bucket bucket){
        this.maxSand = bucket.maxSand;
        this.curSand = bucket.curSand;
    }

    //Getter of current sand
    public int getCurSand() {
        return curSand;
    }

    //Getter of maxSand
    public int getMaxSand() {
        return maxSand;
    }

    //Sets current amount of sand 
    public void setCurSand(int curSand) {
        this.curSand = curSand;
    }

    /* Checks if bucket is full.
     * @return boolean: true if bucket is full, false otherwise.
     */
    public boolean isFull(){
        return (curSand == maxSand);
    }

    /* Checks if bucket is empty
     * @return boolean : true if bucket is empty, false otherwise
     */
    public boolean isEmpty(){
        return(curSand == 0);
    }

    /* Empties out a bucket of its sand
     */
    public void emptyBucket(){
        curSand = 0;
        System.out.println("Bucket is now empty.");
    }

    /* Fills a bucket with its max value of sand it can hold
     */
    public void fill(){
        setCurSand(maxSand);
    }




}
