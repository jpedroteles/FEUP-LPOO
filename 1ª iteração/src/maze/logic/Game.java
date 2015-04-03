package maze.logic;

import java.util.ArrayList;
import java.util.Random;


public class Game {
	Random random = new Random();
	private Maze maze;
	private Position p;
	private Hero hero;
	private Sword sword;	
	private static ArrayList<Dragon> dragons;
	
	public static enum TipoJogo {
		Parado, Mover, Mover_Dormir
	}
	
	private TipoJogo tipoJogo = TipoJogo.Parado;

	private boolean GameState;
	private boolean exitOpen;

	//Constructor for manualbuilder
	public Game() {
		
		Position pHero = new Position(1,1);
		Position pSword = new Position(8,1);
		Position pDragon = new Position(1,3);
		maze = new Maze(10, 1);
		hero = new Hero(p);
		sword = new Sword(p);		
		//maze = new (height, width);
	}
	
	//Constructor for autobuilder
	public Game(int height, int width, int number_dragons) {
		p= new Position(0,0);

		//maze = new (height, width);
		hero = new Hero(p);
		sword = new Sword(p);

		GameState = false;

		exitOpen = false;		

	

	}


}
