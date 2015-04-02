package maze.logic;

import java.awt.Point;
import java.util.Random;
import java.util.Stack;

import maze.logic.Maze.Symbols;

public class AutoBuilder implements MazeBuilder {

	private final Random rand;
	/**
	 * Maze Builder Parameters
	 */
	private Symbols[][] maze_matrix;
	private int maze_size;

	/**
	 * Random Maze Generation
	 */
	private Position m_guide;
	private Position m_exit;
	private Stack<Position> maze_stack;

	private char[][] visitedCells;
	private int visitedCellsDimension;

	public Maze buildEmpty() {
		maze_matrix = new Symbols[10][10];
		// filling maze with 'X'
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				// if odd column draw space
				if (j % 2 != 0 && j % 2 != 0)
					maze_matrix[i][j] = Symbols.PATH;
				// if odd column draw X
				maze_matrix[i][j] = Symbols.WALL;
			}
		}
		return new Maze(10, 10, maze_matrix);
	}

	public boolean exteriorWall(int i, int j) {
		return (j == 0 || j == Maze.getWidth() - 1||i == 0|| i == Maze.getHeight() - 1);

	}

}
