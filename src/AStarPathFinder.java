import java.util.ArrayList;

import processing.core.PApplet;

public class AStarPathFinder extends PApplet{

	PApplet p;
	
	static Node [][] grid;		//the grid 
	
	 ArrayList<Node> openList = new ArrayList<Node>();
	 ArrayList<Node> closedList = new ArrayList<Node>();
	
	 static Location start;
	 static Location target;
	 
	 private final int MOVECOST = 10;
	            
	 	public AStarPathFinder(PApplet p, Location start, Location target){
	 		this.p = p;
	 		
	 		grid = new Node[22][20];
	 		
	 		initGrid();
	 		this.start = start;
	 		this.target = target;
	 		for (int r = start.getRow() - 1; r <= start.getRow() + 1; r++){
	    		for(int c = start.getCol() - 1; c <= start.getCol() + 1; c++){
	    			openList.add(grid[r][c]);
	    			closedList.remove(grid[r][c]);
	    		}
	 		}
	 		grid[start.getRow()][start.getCol()].setGVal(0);
	 		grid[start.getRow()][start.getCol()].setfVal(0);
	 	}
	 	
	 	public void display(){
			displayGrid();
			//fillColors();
		}
		
		
		
		private void fillColors() {
			fill(p.color(255, 3, 2));
			
		}

		public void displayGrid(){
			
			for(int i = 0; i < grid.length-1; i++){
				for(int c = 0; c < grid[0].length-1; c++){
					
					grid[i][c].Display(p, 32*i, 32*c );
					
				}
			}
			
		}
	 	
	 	public void initGrid(){
			for(int i = 0; i < grid.length-1; i++){
				for(int c = 0; c < grid[0].length-1; c++){
					
					grid[i][c] = new Node(new Location(i,c));
				}
			}
	 	}
	 	
	    public static void setBlocked(int i, int j){
	        grid[i][j].status = 1;
	    }
	    
	    public static void setStartNode(Location newStart){
	        start = newStart;
	    }
	    
	    public static void setTargetNode(Location newTarget){
	        target = newTarget;
	    }
//	    
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
	    			if(grid[r][c].status != 1){
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
	    			int steps = rDist + cDist;			//calculates distance away from current location and surrounding nodes
	    			
	    			
	    			
	    			if(openList.contains( grid[r][c] )){
	    				if (grid[current.getRow()][current.getCol()].getGVal() + MOVECOST*steps < grid[r][c].getGVal()){
	    					grid[r][c].setParentNode(current);
	    				}
	    			}		//repoints if faster route is found
	    			
	    			
	    					if(closedList.contains(grid[r][c])){
	    						grid[r][c].setGVal(grid[current.getRow()][current.getCol()].getGVal() + MOVECOST*steps);
	    		    			grid[r][c].setfVal(grid[r][c].getGVal() + grid[r][c].getHeuristic()); 	// calculates moveCost and fVal for nodes
	    						closedList.remove(grid[r][c]);
	    						openList.add(grid[r][c]);			//adds node to openList
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
	    
	    public void checkIfEnd(Location current){
	    	if(grid[current.getRow()][current.getCol()].getHeuristic() == 1){
	    		grid[target.getRow()][target.getCol()].setParentNode(current);
	    	}
	    }
	    
}
