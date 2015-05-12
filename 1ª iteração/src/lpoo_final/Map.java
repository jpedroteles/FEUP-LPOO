package lpoo_final;

import java.util.Random;
import java.util.Stack;

public class Map {
	protected char[] layout;
	protected int mapSize;
	protected int exit;
	
	public char[] getLayout() {
		return layout;
	}

	public int getMapSize() {
		return mapSize;
	}
	public int setMapSize(int j) {
		return mapSize=j;
	}
	
	public void setMapElem(int pos, char elem) {
		layout[pos] = elem;
	}

	public char getMapElem(int pos) {
		return layout[pos];
	}

	public int getx(int Pos, int Size) {
		return Pos % Size;
	}

	public int gety(int Pos, int Size) {
		return Pos / Size;
	}

	public int getpos(int x, int y, int Size) {
		return y * Size + x;
	}
	
	public void displayMap() {

		for (int y = 0; y < mapSize; y++) {
			for (int x = 0; x < mapSize; x++)
				System.out.print(" " + layout[y * mapSize + x] + " ");
			System.out.println();
		}
	}
	public char checkRow(int pos, int dir) {
		for (; getMapElem(pos) != 'X' && getMapElem(pos) != 'S'; pos += dir) {
			if (getMapElem(pos) == 'H' || getMapElem(pos) == 'A')
				return getMapElem(pos);
		}
		return 'X';
	}
        
        public int getExit(){
            return exit;
        }

}
