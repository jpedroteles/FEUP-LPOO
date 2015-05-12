package logic;

public class Weapon extends Piece{

	private boolean taken;
	
	public Weapon(Position p) {
		super(p, 'W');
		this.taken = false;
	}
	
	public boolean isTaken() {
		return taken;
	}
	
	public void setTaken(boolean taken) {
		this.taken = taken;
	}
	
}
