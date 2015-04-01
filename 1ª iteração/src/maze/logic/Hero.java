package maze.logic;

public class Hero extends Piece {
	// Posiçao inicial do hero
	//Position p= new Position(1,1);
	private boolean armed = false;
	private boolean dead = false;
	private boolean KilledDragon = false;

	

	public Hero(Position p) {
		super(p, 'H');
		boolean armed = false;
		boolean dead = false;
	}
	
	///Getters setters
	public boolean isArmed() {
		return this.armed;
	}
	public void setArmed() {
		if(this.armed == false){
			this.symbol='A';
			this.armed=true;
		}
	}
	public boolean isDead() {
		return this.dead;
	}
	public void setDead() {
		this.dead = true;
	}

	public boolean KilledDragon() {
		return KilledDragon;
	}

	public void setKilledDragon() {
		KilledDragon = true;
	}
	
	//Others functions
	public void move(Maze maze, char direction) {
		// if hero can go to direction, do go to that direction
		if (maze.heroCanWalk(direction, this)) {
			switch (direction) {
			case 'd':
				position.setX(position.getX() + 1);
				break;
			case 's':
				position.setY(position.getY() + 1);
				break;
			case 'a':
				position.setX(position.getX() - 1);
				break;
			case 'w':
				position.setY(position.getY() - 1);
				break;
			default:
				break;
			}
		}
	}
	
	public boolean catchSword(Sword sword) {
		if (sword.getPosition().equals(position)) {
			// hide sword from maze
			sword.setSymbol(' ');
			// arm hero
			setArmed();
			return true;
		}

		return false;
	}


}
