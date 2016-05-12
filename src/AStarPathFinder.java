import java.util.ArrayList;

public class AStarPathFinder {

	static Node [][] grid = new Node[5][5];		//the grid 
	
	 ArrayList<Node> openList = new ArrayList<Node>();
	 ArrayList<Node> closedList = new ArrayList<Node>();
	
	 static Location start;
	 static Location target;
	            
	 	public AStarPathFinder(Location start, Location target){
	 		this.start = start;
	 		this.target = target;
	 	}
	 
	    public static void setBlocked(int i, int j){
	        grid[i][j] = null;
	    }
	    
	    public static void setStartNode(Location newStart){
	        start = newStart;
	    }
	    
	    public static void setTargetNode(Location newTarget){
	        target = newTarget;
	    }
	    
	    public void calculateHeuristics(){
	    	/**
	    	 * loop through grid
	    	 * calculate manhattan distance for each node
	    	 * - get x distance
	    	 * - get y distance 
	    	 * - add together
	    	 * add as Heuristic for each node
	    	 */
	    	
	    	for (int r = 0; r < grid.length; r++){
	    		for (int c = 0; c < grid[r].length; c++){
	    			if(grid[r][c] != null){
		    			int rDist = target.getRow() - r;
		    			int cDist = target.getCol() - c;
		    			int heuristic = rDist + cDist;
		    			grid[r][c].setHeuristic(heuristic);
	    			}
	    		}
	    	}
	    }
	    
	    
}
