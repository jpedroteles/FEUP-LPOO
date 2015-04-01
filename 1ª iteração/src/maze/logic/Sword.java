package maze.logic;

public class Sword extends Piece {
	
		// Posiçao inicial do hero
		//Position p= new Position(8,1);
		private boolean picked;
		
		public Sword(Position p) {
			super(p,'S');
			picked=false;
		}

		public boolean isPicked() {
			return picked;
		}
		public void setPicked(boolean picked) {
			this.picked = picked;
		}
}
