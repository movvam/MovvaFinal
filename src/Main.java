import processing.core.PApplet;

public class Main extends PApplet{
//	public static void main(String[] args) {
//		System.out.println("work");
//
//	}
	Game g;
	
	
	
	
	
	public void setup(){
		size(1280, 720);
		
		g = new Game(this);
		
		
	}
	
	
	
	public void draw(){
		g.display();
		
	}
	
	public void mousePressed(){
		int c = mouseX/32;
		int r = mouseY/32;
		g.grid[r][c] = null;
//		/g.changeGrid(new Wall(), r, c);
	}
	
}