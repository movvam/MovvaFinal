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
	    
	    public void calculateHeuristic(){
	    	
	    }
}
