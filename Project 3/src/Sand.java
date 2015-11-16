import java.util.ArrayList;

/**
 * @author Jean Luis Urena ju7847 
 * @author Jake Madlem     jxm9019
 * CS For Transfers
 * Project3
 *
 * This is a Bucket class. This class is to be used with Sand puzzle, Bucket is an object 
 * that holds sand, transfers to other Bucket objects, and throws out its sand.
 */
public class Sand {
    public static final int MINSAND = 0;
    private int maxSand;
    private int curSand;

    //Constructor will take the max amount of sand it can take and build a bucket
    public Sand(int maxSand){
        this.maxSand = maxSand;
        this.curSand = 0;
    }

    //Bucket copy constructor
    public Sand(Sand bucket){
        this.maxSand = bucket.maxSand;
        this.curSand = bucket.curSand;
    }

    //Getter of current sand
    public int getCurSand() {
        return curSand;
    }

    //Getter of max sand bucket can hold
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

    public boolean isEmpty(Sand bucket){
        return(bucket.curSand == MINSAND);
    }

    /* Empties out a bucket of its sand
     */
    public void emptyBucket(){
        curSand = MINSAND;
        System.out.println("Bucket is now empty.");
    }

    /* Fills a bucket with its max value of sand it can hold
     */
    public void fill(){
        setCurSand(maxSand);
    }

    
    /* This will transfer sand from one bucket to another.
     * 
     * @param Bucket: bucket that sand will be transferred to
     * @return : true if bucket transfer is successful, false otherwise
     */

    public boolean transfer(Sand bucket2){
        //Checking if bucket is not full
        if(!bucket2.isFull()){
            
            //Setting current sand of second bucket to sum of the two buckets
            bucket2.setCurSand(getCurSand()+bucket2.getCurSand());
            
            //If bucket overflows...
            if(bucket2.getCurSand()>bucket2.getMaxSand()){
                int temp = (bucket2.getCurSand()-bucket2.getMaxSand());  //temp amount of sand difference between buckets
                bucket2.setCurSand(bucket2.getMaxSand());                //Setting second bucket to max
                setCurSand(temp);                                        //setting first bucket to difference
                return true;
            
             //If bucket does not overflow
            } else if(bucket2.getCurSand()<=bucket2.getMaxSand()){
                emptyBucket();
                return true;
            }else
                return false;
        }else
            return false;
    }


    public static void main(String[] args) {
        ArrayList<Sand> bucketList= new ArrayList<>();
        for(int i=1;i<args.length;i++){
            bucketList.add(new Sand(Integer.parseInt(args[i])));
        }
        for (int i =0; i < bucketList.size(); i++) {
            System.out.println("Bucket "+(i+1)+": "+ bucketList.get(i).getMaxSand() +" max sand");
        }
    }
}
