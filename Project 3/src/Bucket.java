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
    public static final int MINSAND = 0;
    private int maxSand;
    private int curSand;

    public Bucket(int maxSand){
        this.maxSand = maxSand;
        this.curSand = 0;
    }

    public Bucket(Bucket bucket){
        this.maxSand = bucket.maxSand;
        this.curSand = bucket.curSand;
    }

    public int getCurSand() {
        return curSand;
    }

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

    public boolean isEmpty(Bucket bucket){
        return(bucket.curSand == 0);
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

    public boolean transfer(Bucket bucket2){
        if(!bucket2.isFull()){
            bucket2.setCurSand(getCurSand()+bucket2.getCurSand());
            if(bucket2.getCurSand()>bucket2.getMaxSand()){
                int temp = (bucket2.getCurSand()-bucket2.getMaxSand());
                bucket2.setCurSand(bucket2.getMaxSand());
                setCurSand(temp);
                return true;
            }else
            if(bucket2.getCurSand()<=bucket2.getMaxSand()){
                emptyBucket();
                return true;
            }else
                return false;
        }else
            return false;
    }

    public static void main(String[] args) {
        Bucket b1 = new Bucket(5);
        Bucket b2 = new Bucket(2);

        System.out.println(b1.getMaxSand()+ " b1 max");
        System.out.println(b2.getMaxSand()+ " b2 max");
        b1.fill();
        System.out.println(b1.getCurSand() + " b1 cur after fill");
        b1.emptyBucket();
        System.out.println(b1.getCurSand() + " b1 cur after empty");



    }


}
