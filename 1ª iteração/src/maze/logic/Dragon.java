package maze.logic;

import java.util.Random;

public class Dragon extends Piece {

	private boolean dead = false;
	private boolean sleep;
	private int sleepingTime=0;
	DragonBehavior behavior = DragonBehavior.MOVING;

	public enum DragonBehavior {
		NOTMOVING, MOVING, MOVINGANDSLEEPING
	}

	public Dragon(Position p) {
		super(p, 'D');
		boolean dead = false;
		Random random = new Random();
		this.setSleeping( random.nextBoolean() );
	}
	

	public int getSleepingTime() {
		return sleepingTime;
	}


	public void setSleepingTime(int sleepingTime) {
		this.sleepingTime = sleepingTime;
	}


	public boolean isDead() {
		return dead;
	}
	
	public void setDead() {
		dead=true;
	}


	public boolean isSleepling() {
		return sleep;
	}

	public void setSleeping(boolean sleeping) {
		this.sleep = sleeping;
		if ( sleeping ) {
			this.setSymbol('d');
		} else {
			this.setSymbol('D');
		}
	}

	private void wake() {
		if (sleep == true) {
			this.setSymbol('D');
			this.sleep = false;
		}
	}

	public void move(Maze maze) {
		Random rand = new Random();
		int direction = rand.nextInt(5);
		if (behavior != DragonBehavior.NOTMOVING && !sleep) {
			// moving dragon randomly
			switch (direction) {
			case 0:
				break;
			case 1:
				if (maze.dragonCanWalkTo(getPosition().getX(), getPosition()
						.getY() - 1))
					getPosition().setY(getPosition().getY() - 1);
				break;
			case 2:
				if (maze.dragonCanWalkTo(getPosition().getX() + 1,
						getPosition().getY()))
					getPosition().setX(getPosition().getX() + 1);
				break;
			case 3:
				if (maze.dragonCanWalkTo(getPosition().getX(), getPosition()
						.getY() + 1))
					getPosition().setY(getPosition().getY() + 1);
				break;
			case 4:
				if (maze.dragonCanWalkTo(getPosition().getX() - 1,
						getPosition().getY()))
					getPosition().setX(getPosition().getX() - 1);
				break;
			}
		}

		if (behavior == DragonBehavior.MOVINGANDSLEEPING) {
			sleepDragon(this);
		}
			else
			wake();
		}
	
	
	public boolean sleepDragon(Dragon dragon) {
		if (dragon.getSleepingTime() == 0) {
			Random rand = new Random();
			if (rand.nextInt(5) == 0) {
				dragon.setSleepingTime(3 + rand.nextInt(4));
				return true;
			}
		} else {
			dragon.setSleepingTime(dragon.getSleepingTime() - 1);
		}
		return (dragon.getSleepingTime() > 0);
	}
}