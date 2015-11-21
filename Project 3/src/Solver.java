import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author Jean Luis Urena ju7847
 * @author Jake Madlem     jxm9019
 *
 * CS For Transfers
 * Project3
 *
 * This solver class contains method to solve Mobius puzzle.
 */

public class Solver<E> {
    /**
     * Solves a puzzle
     *
     * @param puzzle
     *            - the puzzle to be solved
     * @return ArrayList holding solution
     */
    public ArrayList<E> solver(Puzzle<E> puzzle) {
        //Hashset for visited configs for pruning
        HashSet<E> visitList = new HashSet<E>();
        ArrayList<ArrayList<E>> queue = new ArrayList<>();
        ArrayList<E> startConfig = new ArrayList<E>();
        //ArrayList to hold current path
        ArrayList<E> current = null;
        //Adding start number to start config
        startConfig.add(puzzle.getStart());
        //Checks if the given puzzle is already solved with it's first config
        boolean found = puzzle.isGoal(puzzle.getStart());
        queue.add(startConfig);
        //Add the first config to the visited list
        visitList.add(puzzle.getStart());
        while (!queue.isEmpty() && !found) {
            //deque's element from queue and adds to current path
            current = queue.remove(0);
            ArrayList<E> neighbors = puzzle.getNeighbors(current.get(current.size() - 1));
            for (E neighbor : neighbors) {
                //if the neighbor hasnt been visited yet
                if (!visitList.contains(neighbor)) {
                    //make a new config to modify
                    ArrayList<E> nextConfig = new ArrayList<E>();
                    for (E item : current) {
                        nextConfig.add(item);
                    }
                    nextConfig.add(neighbor);
                    if (puzzle.isGoal(nextConfig.get(nextConfig.size() - 1))) {
                        current = nextConfig;
                        found = true;
                        break;
                    } else {
                        queue.add(nextConfig);
                    }
                    visitList.add(neighbor);
                }
            }
        }
        //returns Arraylist path if found
        if (found) {
            return current;
        //otherwise there is no solution
        } else {
            System.out.println("There is no solution.");
            return null;
        }
    }
}