/**
 * Created by Jacob on 11/13/2015.
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

    public void setMaxSand(int maxSand) {
        this.maxSand = maxSand;
    }

    public void setCurSand(int curSand) {
        this.curSand = curSand;
    }

    public boolean isFull(Bucket bucket){
        return(bucket.curSand==bucket.maxSand);
    }

    public boolean isEmpty(Bucket bucket){
        return(bucket.curSand == 0);
    }

    public void emptyBucket(Bucket bucket){
        bucket.setCurSand(0);
        System.out.println("Bucket is now empty.");
    }

    public void fill(Bucket bucket){
        bucket.setCurSand(maxSand);
    }




}
