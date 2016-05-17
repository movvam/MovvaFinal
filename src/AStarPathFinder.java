import java.util.ArrayList;

public class AStarPathFinder {

	static Node [][] grid = new Node[5][5];		//the grid 
	
	 ArrayList<Node> openList = new ArrayList<Node>();
	 ArrayList<Node> closedList = new ArrayList<Node>();
	
	 static Location start;
	 static Location target;
	 
	 private final int MOVECOST = 10;
	            
	 	public AStarPathFinder(Location start, Location target){
	 		this.start = start;
	 		this.target = target;
	 		for (int r = start.getRow() - 1; r <= start.getRow() + 1; r++){
	    		for(int c = start.getCol() - 1; c <= start.getCol() + 1; c++){
	    			openList.add(grid[r][c]);
	    			closedList.remove(grid[r][c]);
	    		}
	 		}
	 		grid[start.getRow()][start.getCol()].setMoveCost(0);
	 		grid[start.getRow()][start.getCol()].setfVal(0);
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
	    
	    public void calculateMoveCostAndFVal(Location current){
	    	for (int r = current.getRow() - 1; r <= current.getRow() + 1; r++){
	    		for(int c = current.getCol() - 1; c <= current.getCol() + 1; c++){
	    			int rDist = target.getRow() - r;
	    			int cDist = target.getCol() - c;
	    			int steps = rDist + cDist;			//calculates distance away from current location
	    			
	    			grid[r][c].setMoveCost(grid[current.getRow()][current.getCol()].getMoveCost() + MOVECOST*steps);
	    			grid[r][c].setfVal(grid[r][c].getMoveCost() + grid[r][c].getHeuristic()); 	// calculates moveCost and fVal for nodes
	    			
	    			for (int l = r - 1; l <= r + 1; l++){
	    				for (int p = c - 1; c <= c + 1; p++){
	    					if(closedList.contains(grid[l][p])){
	    						closedList.remove(grid[l][p]);
	    						openList.add(grid[l][p]);			//adds surrounding nodes to openList
	    					}
	    				}
	    			}
	    		}
	    	}
	    }
	    
	    public Node getLeastFVal(){
	    	int min = Integer.MAX_VALUE;
	    	int minLoc = 0;
	    	for (int i = 0; i < openList.size(); i++){
	    		if(openList.get(i).getfVal() < min){
	    			min = openList.get(i).getfVal();
	    			minLoc = i;
	    		}
	    	}
	    	return openList.get(minLoc);
	    }
	    
}
