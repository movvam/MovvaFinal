import processing.core.PApplet;

public class Node {

	public int status = 0; //0 = free space, 1 = blocked node
	private Location loc;
	private int heuristic; 
	private int moveCost;
	private int fVal;		//moveCost + heuristic
	private Location parentNode;
	
	public Node(Location loc){
		this.loc = loc;
		this.status = 0;
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

	public void Display(PApplet p, int x, int y) {
		
		p.rect(x, y, 32, 32);
		if (this.status == 0)	p.fill(255, 246, 204);
//		if (this.loc.getRow() == 4)p.fill(25, 206, 24);
		if (this.status == 1)p.fill(25, 3, 206);
	}

}
