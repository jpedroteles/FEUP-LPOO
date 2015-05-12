package logic;

public class Hero extends Ship {

	private boolean armed;
	private boolean dead;

	// Constructor

	public Hero(Position p) {
		super(p, 0, 'H');
		this.armed = false;
		this.dead = false;
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

	public void setDead(boolean dead) {
		if (getHp() <= 0) {
			this.dead = true;
		} else
			this.dead = false;
	}
}
