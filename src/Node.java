
public class Node {

	private Location loc;
	private int heuristic; 
	private int moveCost;
	private int fVal;		//moveCost + heuristic
	private Location parentNode;
	
	public Node(Location loc){
		this.loc = loc;
	}
	

	public Location getLoc() {
		return loc;
	}

	public void setLoc(Location loc) {
		this.loc = loc;
	}

	public int getHeuristic() {
		return heuristic;
	}

	public void setHeuristic(int heuristic) {
		this.heuristic = heuristic;
	}

	public int getMoveCost() {
		return moveCost;
	}

	public void setMoveCost(int moveCost) {
		this.moveCost = moveCost;
	}

	public int getfVal() {
		return fVal;
	}

	public void setfVal(int fVal) {
		this.fVal = fVal;
	}

	public Location getParentNode() {
		return parentNode;
	}

	public void setParentNode(Location parentNode) {
		this.parentNode = parentNode;
	}

}
