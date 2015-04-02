package maze.logic;

import java.util.Scanner;
import java.util.Arrays;

public class Maze {
	
	private int width, height;
	private Symbols[][] maze;
	
	public enum Symbols {
		PATH, WALL, EXIT
	}
	
	public Maze(int width, int height, Symbols[][] maze) {
		this.width = width;
		this.height = height;
		this.maze = maze;
	}
	
	
	public int getWidth() {
		return width;
	}


	public void setWidth(int width) {
		this.width = width;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}


	public Symbols[][] getMaze() {
		return maze;
	}


	public void setMaze(Symbols[][] maze) {
		this.maze = maze;
	}


	public char getSymbolChar(Symbols symbol) {
		char res = '.';

		switch (symbol) {
		case PATH:
			res = ' ';
			break;
		case WALL:
			res = 'X';
			break;
		case EXIT:
			res = 'S';
			break;
		}

		return res;
	}


	public boolean heroCanWalk(char dir, Hero hero) {
		int x = hero.getPosition().getX();
		int y = hero.getPosition().getY();

		switch (dir) {
		// scanning cell to the right
		case 'd':
			if (maze[y][x + 1] != Symbols.EXIT)
				return maze[y][x + 1] != Symbols.WALL;
			break;
		// scanning cell to the south
		case 's':
			if (maze[y + 1][x] != Symbols.EXIT)
				return maze[y + 1][x] != Symbols.WALL;
			break;
		// scanning cell to the left
		case 'a':
			if (maze[y][x - 1] != Symbols.EXIT)
				return maze[y][x - 1] != Symbols.WALL;
			break;
		// scanning cell to the north
		case 'w':
			if (maze[y - 1][x] != Symbols.EXIT)
				return maze[y - 1][x] != Symbols.WALL;
			break;
		default:
			break;
		}

		// if hero is trying to walk to maze exit
		
		if (hero.KilledDragon())
			return true;
		else
			return false;
	}

	public boolean dragonCanWalkTo(int x, int y) {
			return maze[y][x] == Symbols.PATH;
		}
	
	/*
	static void finalMessage(Hero player1, Dragon dragon1) {
		if(Hero.getMeta()){
				System.out.print("Parabéns ganhou o jogo");
				}
		else if(Dragon.getMata()){
			System.out.print("Game Over");
		}
	}*/
}
