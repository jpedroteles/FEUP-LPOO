package maze.logic;

import java.util.Random;

public class Dragon extends Piece {

	// Posiçao inicial do hero
	// Position p= new Position(1,3);
	private boolean dead = false;
	private boolean sleep;
	DragonBehavior behavior = DragonBehavior.MOVING;

	public enum DragonBehavior {
		NOTMOVING, MOVING, MOVINGANDSLEEPING
	}

	public Dragon(Position p, DragonBehavior behavior) {
		super(p, 'D');
		boolean dead = false;
		this.behavior = behavior;
	}

	public boolean isDead() {
		return dead;
	}

	public boolean isSleepling() {
		return sleep;
	}

	private void setSleeping() {
		if (sleep == false) {
			this.setSymbol('d');
			this.sleep = true;
		}
	}

	private void wake() {
		if (sleep == true) {
			this.setSymbol('D');
			this.sleep = false;
		}
	}

	public void move(Maze maze, char direction) {

		if (behavior != DragonBehavior.NOTMOVING && !sleep) {
			// moving dragon randomly
			switch (direction) {
			case 'w':
				if (maze.dragonCanWalkTo(getPosition().getX(), getPosition()
						.getY() - 1))
					getPosition().setY(getPosition().getY() - 1);
				break;
			case 'd':
				if (maze.dragonCanWalkTo(getPosition().getX() + 1,
						getPosition().getY()))
					getPosition().setX(getPosition().getX() + 1);
				break;
			case 's':
				if (maze.dragonCanWalkTo(getPosition().getX(), getPosition()
						.getY() + 1))
					getPosition().setY(getPosition().getY() + 1);
				break;
			case 'a':
				if (maze.dragonCanWalkTo(getPosition().getX() - 1,
						getPosition().getY()))
					getPosition().setX(getPosition().getX() - 1);
				break;
			}
		}

		if (behavior == DragonBehavior.MOVINGANDSLEEPING) {
			Random r = new Random();

			// making dragon sleep sometimes
			int sleep = r.nextInt(2);

			if (sleep == 1)
				setSleeping();
			else
				wake();
		}
	}
}