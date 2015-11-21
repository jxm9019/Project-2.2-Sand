import java.util.ArrayList;
/**
 * @author Jean Luis Urena ju7847 
 * @author Jake Madlem     jxm9019
 * CS For Transfers
 * Project3
 *
 * An interface puzzle class that contains stubs for a puzzle.
 */

public interface Puzzle<E> {


    //Getter for goal in Puzzle
    public boolean isGoal(E config);

    //Will return neighbors in a puzzle
    public ArrayList<E> getNeighbors(E config);

    //Getter for starting configuration
    public E getStart();
}