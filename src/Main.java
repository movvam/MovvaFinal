import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;

import processing.core.PApplet;

public class Main extends PApplet {

	static AStarPathFinder g;
	static Location current;

	public void setup() {
		size(1024, 640);
		current = new Location(2, 2);
		g = new AStarPathFinder(this, new Location(2, 13), new Location(20, 7));
		g.calculateHeuristics();
	}

	public void draw() {
		g.display();
 
	}

	public void keyReleased(KeyEvent e) {

		if (e.getKeyCode() == 32) // if spacebar is pressed
		{

			do { // loop start (until finds end)
				g.calculateMoveCostAndFVal(current);
				current = g.getLeastFVal().getLoc(); // keeps finding the closest node to the target in the openList until finds target node
			} while (!g.checkIfEnd(current));
			
			while (current.getRow() != g.start.getRow() || current.getCol() != g.start.getCol()) { 	//changes status of the pathway nodes to PATHWAY
				g.setAsPath(current);
				current = g.grid[current.getRow()][current.getCol()].getParentNode();
			}

			g.display();
		}

	}

	public void mousePressed() {		// blocks location where in the location where clicked
		int r = mouseX / 32;
		int c = mouseY / 32 - 1;
		if (c < 0)
			c = 0;
		AStarPathFinder.setBlocked(r, c);
	}

}