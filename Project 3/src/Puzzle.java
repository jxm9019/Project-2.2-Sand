import java.util.ArrayList;

/*
 * Puzzle.java
 *
 * Version:
 * $Id: Puzzle.java,v 1.2 2015/10/22 23:55:05 ju7847 Exp $
 * Revisions:
 * $Log: Puzzle.java,v $
 * Revision 1.2  2015/10/22 23:55:05  ju7847
 * Finished project.
 * Tested thoroughly.
 *
 * Revision 1.1  2015/10/22 04:03:48  ju7847
 * Implemented Puzzle, Mobius and almost finished solver
 *
 */

/**
 * @author Jean Luis Urena ju7847 
 * @author Jake Madlem     jxm9019
 * CS For Transfers
 * Project2
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
