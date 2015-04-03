package maze.logic;

public class Position {
	
	private int x,y;
	
	private static final int UP=0;
	private static final int DOWN=1;
	private static final int LEFT=2;	
	private static final int RIGHT=3;
	//Constructors
	public Position(int x, int y){
		this.x=x;
		this.y=y;
	}
	
	public Position(Position p){
		this.x=p.getX();
		this.y=p.getY();
	}
	
	//Getters e setters
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}	
	public void setX(int x){
		this.x=x;
	}	
	public void setY(int y){
		this.y=y;
	}
	
	//Comparations
	public boolean isEqual(Position p){
		return this.x==p.getX() && this.y==p.getY();
	}
	
	public boolean isAdjacent(Position p){
		return Math.abs(this.x-p.getX())+Math.abs(this.y-p.getY())<=1; 
	}

}
