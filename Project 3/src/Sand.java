import java.util.ArrayList;

/**
 * @author Jake Madlam
 * @author Jean Luis Urena 
 * ID: ju7847
 * CS For Transfers
 * Project 3
 *
 */

public class Sand implements Puzzle<ArrayList<Integer>> {
	private ArrayList<Integer> bucketList;
	private int goal;
	private int amountOfBuckets;
	
	/**
	 * 
     * Constructor creates array list of Buckets based on amount of buckets passed.
//     * @param String [] :args
	 */
	public Sand(String[] args) {
		bucketList = new ArrayList<Integer>();
		amountOfBuckets = args.length-1;
		goal = Integer.parseInt(args[0]);
		for(int i = 1; i < args.length; i++) {
			bucketList.add(Integer.parseInt(args[i]));
		}
	}
	
	/**
	 * Checks for goal
//	 * @param ArrayList<Integer> bucketList to check goal
	 * @return returns true if the config contains the desiredWater
	 */
	@Override
	public boolean isGoal(ArrayList<Integer> solution) {
		
		return (solution.get(0) == goal);
	}
	
	/**
	 * Initial bucket list
	 * @return ArrayList<Integer> start
	 */
	@Override
	public ArrayList<Integer> getStart() {
		ArrayList<Integer> starter = new ArrayList<Integer>();
		
		for(int i = 0; i < amountOfBuckets; i++)
			starter.add(0);
		
		return starter;
	}
	
	/**
	 * This program will return neighbors of a specific configuration
     * It will create all possible solutions and store them in an array.
//     * @param ArrayList<Integer> : array list of buckets
     * @return ArrayList<ArrayList> : list of list of all next steps
	 */
	@Override
	public ArrayList<ArrayList<Integer>> getNeighbors(ArrayList<Integer> config) {
		
		ArrayList<ArrayList<Integer>> neighbors = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> startConfig = copy(config);
		for(int i = 0; i < config.size(); i++) {
			if(startConfig.size() != config.size())
				startConfig = copy(config);
			int current = startConfig.remove(i);
			
			/**
			 * Empties a bucket if its not 0 value
			 */
			if(current != 0) {
				startConfig.add(i, 0);
				neighbors.add(startConfig);
				startConfig = copy(config);
				current = startConfig.remove(i);
			}
			
			/**
			 * Fills a bucket 
			 */
			if(current != bucketList.get(i)) {
				startConfig.add(i, bucketList.get(i));
				neighbors.add(startConfig);
				startConfig = copy(config);
				current = startConfig.remove(i);
			}
			
			/**
			 * Transfers from one bucket to another
			 */
			for(int j = 0; j < config.size() - 1; j++) {
				//So bucket won't transfer to itself
				if (j != i) {
					
					if(startConfig.size() == config.size())
						current = startConfig.remove(i);
					
					if(current != bucketList.get(i) && startConfig.get(j) != 0) {
						
						Integer pourer = startConfig.remove(j);
						int total = 0;
						int overFlow = 0;
						
						if(current + pourer <= bucketList.get(i)) {
							total = current + pourer;
						} else {
							total = bucketList.get(i);
							overFlow = (current + pourer) - bucketList.get(i);
						}
		
						startConfig.add(j, overFlow);
						startConfig.add(i, total);
						
						if(pourer != overFlow) {
							neighbors.add(startConfig);
							startConfig = copy(config);
							current = startConfig.remove(i);
						}
					} else 
						startConfig = copy(config);
				}
			}
		}
		return neighbors;
	}
	
	/**
	 * Resets current
//	 * @param ArrayList<Integer> original to which to copy
	 * @return ArrayList<Integer> the copy
	 */
	private ArrayList<Integer> copy(ArrayList<Integer> config) {
		
		ArrayList<Integer> newConfig = new ArrayList<Integer>();
		
		for(Integer i : config) 
			newConfig.add(i);	
		
		return newConfig;
	}
	
	
	/**
	 * Main test program
	 * @param args - command line arguments
	 */
	public static void main(String[] args) {
		try {
			int length = args.length;
			ArrayList<ArrayList<Integer>> solution;
			
			if(length < 2){
				System.out.println("Usage: java Sand amount bucket1 bucket2 ... ");
				return;
		}
		
		
			solution = new Solver<ArrayList<Integer>>().solver(new Sand(args));
			if(solution != null) {
				for(int i = 0; i < solution.size(); i++) {
					System.out.print("Step " + i + ": ");
					for(int j = 0; j < solution.get(i).size(); j++) {
						
						System.out.print(solution.get(i).get(j));
							
						if(j + 1 != solution.get(i).size()) {
							System.out.print(" ");
						}
					}
					System.out.println();
				}
			}
			else {
				boolean solved = false;
				for(int i = 1; i < args.length; i++) {
					if(args[i].equals(args[0])) {
						solved = true;
						break;
					}
				}
				if(solved) {
					String output = "Step 0: ";
					for(int i = 1; i < args.length; i++) {
						output += args[i];
					}
					System.out.println(output);
				}
				else
					System.out.println("No solution.");
			}
			
		} catch (NumberFormatException ex){
			System.out.println("Usage: java Sand amount bucket1 bucket2 ... ");
		}
	} 
	
}