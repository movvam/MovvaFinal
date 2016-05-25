import processing.core.PApplet;

public class Node {

	public static int FREE = 0;
	public static int BLOCKED = 1; 
	public static int PATHWAY = 2;
	public int status = FREE; //0 = free space, 1 = blocked node
	private Location loc;
	private int heuristic; 
	private int gVal;
	private int fVal;		//gVal + heuristic
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

	public int getGVal() {
		return gVal;
	}

	public void setGVal(int gVal) {
		this.gVal = gVal;
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
		if (this.status == FREE)	p.fill(255, 246, 204);
//		if (this.loc.getRow() == 4)p.fill(25, 206, 24);
		if (this.status == BLOCKED)p.fill(25, 3, 206);
		if (this.status == PATHWAY)p.fill(25, 3, 206);
	}

}
