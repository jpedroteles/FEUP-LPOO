package logic;

public class Position {
	
	private int x=0,y=0;	
	
	public Position(int x, int y){
		this.x=x;
		this.y=y;
	}
	
	public Position( Position p){
		this.x=getX();
		this.y=getY();
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public boolean equals(Object other) {
		if (!(other instanceof Position))
			return false;

		Position that = (Position) other;

		// Custom equality check here.
		return this.x == that.x && this.y == that.y;
	}
	
}
