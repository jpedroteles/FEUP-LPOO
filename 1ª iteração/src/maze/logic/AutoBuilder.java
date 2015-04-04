//package maze.logic;
//
//import java.awt.Point;
//import java.util.Random;
//import java.util.Stack;
//
//public class AutoBuilder implements MazeBuilder {
//	
//
//	//private final Random rand;
//	/**
//	 * Maze Builder Parameters
//	 */
//	private char[][] maze_matrix;
//	private int maze_size;
//	private int width,visitedWidth;
//	private int height,visitedHeight;
//	/**
//	 * Random Maze Generation
//	 */
//	private Position mazeGuide;
//	private Position mazeExit;
//	private Stack<Position> maze_stack;
//	private char[][] visitedCells;
//	private int visitedCellsDimension;
//
//	public void setWidth(int width) {
//		this.width = width;
//	}
//
//	public void setHeight(int height) {
//		this.height = height;
//	}
//
//	public void buildEmpty() {
//		// filling maze with 'X'
//		for (int i = 0; i < width; i++) {
//			for (int j = 0; j < height; j++) {
//				// if odd column draw space
//				if (j % 2 != 0 && j % 2 != 0)
//					maze_matrix[i][j] = ' ';
//				// if odd column draw X
//				maze_matrix[i][j] = 'X';
//			}
//		}
//
//	}
//
//	public boolean exteriorWall(int i, int j) {
//		return (j == 0 || j == width - 1 || i == 0 || i == height - 1);
//	}
//
//	// set exit and guidecell
//	public void setExit() {
//		Random r = new Random();
//		boolean validExit = false;
//		int x = 0, y = 0;
//
//		while (validExit == false) {
//			do {
//				x = r.nextInt(width);
//				y = r.nextInt(height);
//			} while (maze_matrix[y][x] != ' ');
//			mazeGuide = new Position(x, y);
//			maze_matrix[y][x] = '+';
//			if (exteriorWall(x + 1, y)) {
//				validExit = true;
//				maze_matrix[y][x + 1] = 'S';
//				mazeExit = new Position(x + 1, y);
//			} else if (exteriorWall(x - 1, y)) {
//				validExit = true;
//				maze_matrix[y][x - 1] = 'S';
//				mazeExit = new Position(x - 1, y);
//			} else if (exteriorWall(x, y + 1)) {
//				validExit = true;
//				maze_matrix[y + 1][x] = 'S';
//				mazeExit = new Position(x, y + 1);
//			} else if (exteriorWall(x, y - 1)) {
//				validExit = true;
//				maze_matrix[y - 1][x] = 'S';
//				mazeExit = new Position(x, y - 1);
//			}
//		}
//
//	}
//
//	private void visitedCellMatrix() {
//		for (int k = 0; k < (visitedWidth - 1) / 2; k++) {
//			for (int m = 0; m < (visitedHeight - 1) / 2; m++) {
//				visitedCells[k][m] = '+';
//			}
//		}
//	}
//
//}
