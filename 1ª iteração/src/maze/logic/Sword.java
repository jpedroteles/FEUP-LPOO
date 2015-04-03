package maze.logic;

public class Sword extends Piece {
	
		
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
