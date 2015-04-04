package maze.logic;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class Maze {

	private int width, height;
	private Board board;
	private Hero hero;
	private Sword sword;
	private boolean end;
	private ArrayList<Dragon> dragons;

	public Maze(int boardDimension, int dragonsCount) {

		this.board = new Board(boardDimension);
		this.hero = new Hero(new Position(1, 1));
		this.sword = new Sword(new Position(8, 1));
		this.dragons = new ArrayList<Dragon>();

		this.end = false;

		Scanner reader = new Scanner(System.in);
		char input;

		// Add dragons
		for (int i = 0; i < dragonsCount; i++) {
			this.newDragon();
		}
		
		this.board.printsMaze();
		this.drawPieces();

		do {

			System.out.print("\n> ");
			input = reader.next(".").charAt(0);			

			if (!moveHero(input,hero)) {
				board.printsMaze();
				continue;
			}

			this.updatePieces();
			this.drawPieces();
			board.printsMaze();

		} while (!end && !this.hero.isDead());

		if (end) {
			System.out.println("\nYOU WON!");
		} else {
			System.out.println("\nGAME OVER! ");
		}

		reader.close();

	}

	private void drawPieces() {
		// Draw Dragons
		for (int i = 0; i < this.dragons.size(); i++) {
			if (this.board.getSymbol(this.dragons.get(i).getPosition()) == 'E') {
				this.board.setSymbol(this.dragons.get(i).getPosition(), 'F');
			} else {
				this.board.setSymbol(this.dragons.get(i).getPosition(),
						this.dragons.get(i).getSymbol());
			}
		}

		// Draw Hero
		board.setSymbol(this.hero.getPosition(), this.hero.getSymbol());
		board.setSymbol(this.sword.getPosition(), this.sword.getSymbol());

	}

	private void updatePieces() {

		Random random = new Random();

		// Hero
		if (this.hero.getPosition().isEqual(this.board.getExit())) {
			this.end = true;
			return;
		}

		// Dragons
		for (int i = 0; i < this.dragons.size(); i++) {

			this.dragons.get(i).setSleeping(random.nextBoolean());
			if (!this.dragons.get(i).isSleepling()) {
				//moveDragon(this.dragons.get(i));
			}

			if (this.dragons.get(i).getPosition()
					.isAdjacent(this.hero.getPosition())) {

				if (this.hero.isArmed()) {
					this.board
							.setSymbol(this.dragons.get(i).getPosition(), ' ');
					this.dragons.remove(i--);
				} else {
					this.hero.setDead();
				}

			}

		}
		if (this.sword.getPosition().isEqual(this.hero.getPosition())) {

			this.hero.setArmed();

		}

	}

	private void newDragon() {
		Position dragonPosition;
		do {
			dragonPosition = this.randomPlace();
		} while (dragonPosition.isAdjacent(this.hero.getPosition()));

		this.dragons.add(new Dragon(dragonPosition));

	}

	// Dragons spawn
	private Position randomPlace() {

		Position p = new Position(0, 0);
		Random random = new Random();
		int max = board.getDimension() - 1;

		do {
			p.setX(random.nextInt(max));
			p.setY(random.nextInt(max));
		} while (!board.isPath(p));

		return p;

	}

	public boolean heroCanWalk(char dir, Hero hero) {
		int x = hero.getPosition().getX();
		int y = hero.getPosition().getY();

		switch (dir) {
		// scanning cell to the right
		case 'd':
			if (board.isExit(new Position(y, x + 1)))
				return board.isWall(new Position(y, x + 1));
			break;
		// scanning cell to the south
		case 's':
			if (board.isExit(new Position(y + 1, x)))
				return board.isWall(new Position(y + 1, x));
			break; // scanning cell to the left
		case 'a':
			if (board.isExit(new Position(y, x - 1)))
				return board.isWall(new Position(y, x - 1));
			break; // scanning cell to the north
		case 'w':
			if (board.isExit(new Position(y - 1, x)))
				return board.isWall(new Position(y - 1, x));
			break;
		default:
			break;
		}
		// if hero is trying to walk to maze exit
		if (hero.isArmed())
			return true;
		else
			return false;
	}

	private boolean moveHero(char dir, Hero hero) {
		if (heroCanWalk(dir, hero)) {			
			hero.move(this,dir);			
			return true;
		} else 
			return false;
	}

	public boolean dragonCanWalkTo(int x, int y) {
		return board.isPath(new Position(y, x));
	}

}
