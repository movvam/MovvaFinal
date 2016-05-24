import java.awt.event.KeyEvent;

import processing.core.PApplet;

public class Main extends PApplet{
	
	static AStarPathFinder g;
	
	
	public void setup(){
		size(1024, 640);
		
		g = new AStarPathFinder(this, new Location(2,2), new Location(22,7));
		
		
//	}
//	
//	public static void main(String[] args) {
	
		
	

		
		
	}
	
	public void draw(){
		g.display();
		
	}
	
	public void keyPressed(KeyEvent e)
    {

	if (e.getKeyCode()==32)
	{
		g.calculateHeuristics();
		System.out.println(g.grid[3][4].getHeuristic());
		System.out.println("hi");
		      //spacebar key code
		
		
//		loop start (until finds end)
		//get vals
		//find least
		// check if at end
		//set statuses of the path to something else
		//display colors
//		loop end (until finds end)
	}

}
	
	public void mousePressed(){
		int r = mouseX/32 ;
		int c = mouseY/32 -1;
		if (c < 0) c = 0;
//		g.grid[r][c].status = 1;
		AStarPathFinder.setBlocked(r, c);
	}
	
}