
public class Node {

	private Location loc;
	private int heuristic; 
	private int moveCost;
	private int fVal;
	private Location parentNode;
	
	public Node(Location loc){
		this.loc = loc;
	}
}
