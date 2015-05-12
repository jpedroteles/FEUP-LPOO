package logic;

public class Enemy extends Ship {
	private boolean dead;
	private boolean armed;

	// Constructor

	public Enemy(Position p) {
		super(p, 1, 'E');
		this.dead = false;
		this.armed = false;
	}

	// Getters and Setters

	public boolean isArmed() {
		return this.armed;
	}
	
	public boolean isDead() {
		return this.dead;
	}
	
	public void setArmed(boolean armed) {
		if (this.armed = armed) {
			this.symbol = 'A';
		}
	}

	public void setDead() {
		if (getHp() <= 0) {
			this.dead = true;
		} else
			this.dead = false;
	}

}
