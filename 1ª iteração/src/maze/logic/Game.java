package maze.logic;

import java.util.ArrayList;
import java.util.Random;

import maze.logic.Maze.Symbols;

public class Game {
	Random random = new Random();

	private Maze maze;
	private Symbols[][] maz;
	private Position p;
	private Hero hero;
	private Sword sword;	
	private static ArrayList<Dragon> dragons;

	private boolean GameState;
	private boolean exitOpen;

	//Constructor for manualbuilder
	public Game() {
		
		p= new Position(0,0);
		
		maze = new Maze(10, 10, maz);
		hero = new Hero(p);
		sword = new Sword(p);		

		GameState = false;

		exitOpen = false;

		/*
		dragons = new ArrayList<Dragon>();
		dragons.add(new Dragon(0, 0));
		dragons.add(new Dragon(0, 0));
		dragons.add(new Dragon(0, 0));*/
	}
	
	//Constructor for autobuilder
	public Game(int height, int width, int number_dragons) {
		p= new Position(0,0);

		//maze = new (height, width);
		hero = new Hero(p);
		sword = new Sword(p);

		GameState = false;

		exitOpen = false;		

		/*dragons = new ArrayList<Dragon>();

		for (int i = 0; i < number_dragons; i++) {
			dragons.add(new Dragon(p, true));
		}*/

	}
	
	public boolean getGameState() {
		return GameState;
	}

	public Hero getHero() {
		return hero;
	}
	

}
