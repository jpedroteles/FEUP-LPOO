package logic;

public class Ship extends Piece {

	private int type, hp;// 0 is hero 1 is enemy -1 boss

	public Ship(Position p, int type, char symbol) {
		super(p, symbol);
		if (type == 0) {
			this.hp = 5;
		} else if (type == 1) {
			this.hp = 1;
		} else if (type == -1) {
			this.hp = 20;
		}
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

}
