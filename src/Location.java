
public class Location {
	private int row, col;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + col;
		result = prime * result + row;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Location other = (Location) obj;
		if (col != other.col)
			return false;
		if (row != other.row)
			return false;
		return true;
	}

	public Location(int row, int col) {
		this.row = row;
		this.col = col;
	}

	public int getRow() { 
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public int distanceTo(Location location) {
		int dr = row - location.row;
		int dc = col - location.col;
		return (int)(Math.sqrt(dr*dr + dc*dc));
	}
	
	public String toString() {
		return "("+row+", "+col+")";
	}
}
