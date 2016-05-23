import processing.core.PApplet;

public class Main extends PApplet{
	
	static AStarPathFinder g;
	
	
	
	
//	public static void main(String[] args) {
//		System.out.println(g.grid[3][4].);
//
//	}
//	
	public void setup(){
		size(1024, 640);
		
		g = new AStarPathFinder(this, new Location(2,2), new Location(22,7));
		
		
	}
	
	
	
	public void draw(){
		g.display();
		
	}
	
	public void mousePressed(){
		int r = mouseX/32 ;
		int c = mouseY/32 -1;
		if (c < 0) c = 0;
//		g.grid[r][c].status = 1;
		AStarPathFinder.setBlocked(r, c);
	}
	
}