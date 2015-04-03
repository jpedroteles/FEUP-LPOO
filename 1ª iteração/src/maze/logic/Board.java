package maze.logic;
import java.util.Scanner;
import java.util.Arrays;

public class Board {
	private char [][] board;
	private int dimension;
	private Position exit;
	
	
	public Board(int dimension){
		if(dimension ==0){
			ManualBuilder manualBuilder=new ManualBuilder();
			this.exit=new Position(0,0);
			this.board=manualBuilder.build(this.exit);
			this.dimension=10;			
		}
		else{
			//AtoBuilder autoBuilder=new AutoBuilder();
			this.exit=new Position(0,0);
			//this.board=autoBuilder.build(this.exit);
			this.dimension=dimension;		
		}
	}
	
	//Getters and Setters
	
	public char getSymbol(Position p){
		return board[p.getX()][p.getY()];
	}
	public void setSymbol(Position p,char c){
		board[p.getX()][p.getY()]=c;
	}
	public int getDimension(){
		return dimension;
	}	
	public Position getExit(){
		return exit;
	}
	
	public boolean isWall(Position p) {
		return board[p.getX()][p.getY()] == 'X';
	}
	
	public boolean isPath(Position p) {
		return board[p.getX()][p.getY()] == ' ';
	}
	
	public boolean isExit(Position p){
		return board[p.getX()][p.getY()]=='S';
	}
	
	public void printsMaze() {
		for (int linha = 0; linha < board.length ; linha++) {
			for (int coluna = 0; coluna < board.length; coluna++) {
				System.out.print(this.board[linha][coluna]+' ');
			}
			System.out.println();
		}
	}
	
	
}
