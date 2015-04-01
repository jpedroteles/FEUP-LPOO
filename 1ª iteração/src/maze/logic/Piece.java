package maze.logic;

public class Piece {

	Position position;
	char symbol;
	
	
	
	public Piece(Position p,char symbol) {
		this.position=new Position(p);
		this.symbol=symbol;
	}
	
	
	public char getSymbol(){
		return symbol;
	}	
	public Position getPosition(){
		return position;
	}
	public void setPosition(Position position){
		this.position=position;
	}
	public void setSymbol(char symbol){
		this.symbol=symbol;
	}
	
	
}

