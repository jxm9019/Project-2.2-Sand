import java.util.ArrayList;
/**
 * @author Jean Luis Urena ju7847 
 * @author Jake Madlem     jxm9019
 * CS For Transfers
 * Project3
 *
 * An interface puzzle class that contains stubs for a puzzle.
 */

public interface Puzzle {

    //Getter for a goal in the puzzle
    public int getGoal();
    
    //Will return neighbors of a given number
    public ArrayList<Integer> getNeighbors(int config);
    
    //Getter for start of puzzle
    public int getStart();
    
}
