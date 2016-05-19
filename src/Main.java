import processing.core.PApplet;

public class Main extends PApplet{
//	public static void main(String[] args) {
//		System.out.println("work");
//
//	}
	Game g;
	
	
	
	
	
	public void setup(){
		size(1024, 640);
		
		g = new Game(this);
		
		
	}
	
	
	
	public void draw(){
		g.display();
		
	}
	
	public void mousePressed(){
		int r = mouseX/32 - 1 ;
		int c = mouseY/32 - 1 ;
		g.grid[r][c].status = 1;
	}
	
}