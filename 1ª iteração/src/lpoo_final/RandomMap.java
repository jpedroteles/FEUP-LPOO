package lpoo_final;

import java.util.Random;
import java.util.Stack;

public class RandomMap extends Map{

	
	private int auxSize;
	private char[] aux;
	private int auxExit;
	private Stack stack = new Stack();
	

	public RandomMap(int j) {
		setMapSize(j);
		generateMap();
		setMapExit();

		setAuxSize();
		setAuxExit();
		generateAux();

		createMaze();
	}

	private void generateMap() {

		layout = new char[mapSize * mapSize];

		for (int x = 0; x < mapSize; x++) {
			for (int y = 0; y < mapSize; y++) {
				if ((x % 2 == 1) && (y % 2 == 1))
					layout[y * mapSize + x] = ' ';
				else
					layout[y * mapSize + x] = 'X';
			}
		}
	}

	private void setMapExit() {
		Random r = new Random();
		exit = r.nextInt((mapSize / 2) - 1) * 2 + 1;
		layout[exit] = 'S';
	}
	
	public int getMapExit(){
		return exit;
	}
	
	private void generateAux() {

		aux = new char[auxSize * auxSize];

		for (int x = 0; x < auxSize; x++) {
			for (int y = 0; y < auxSize; y++) {
				if ((y * auxSize + x) != auxExit)
					aux[y * auxSize + x] = '.';
				else
					aux[y * mapSize + x] = '+';
			}
		}
	}

	private void setAuxSize() {
		auxSize = mapSize / 2;
	}

	private void setAuxExit() {
		auxExit = redimension(exit, mapSize, auxSize);
	}

	private void createMaze() {

		stack.push(auxExit);

		while (true) {
			int prevAux = auxExit;
			auxExit = randomMove(auxExit, auxSize);

			if (aux[auxExit] == '.') {
				stack.push(auxExit);
				clearPath(auxExit, prevAux);
				aux[auxExit] = '+';
				continue;
			} else {
				int i = updateMove(prevAux, auxSize);

				if (i != -1) {
					auxExit = i;
					stack.push(auxExit);
					clearPath(auxExit, prevAux);
					aux[auxExit] = '+';
				} else {
					auxExit = (int) stack.pop();
				}

				if (stack.empty())
					break;
			}
		}
	}	

	private int redimension(int pos, int from, int to) {
		return getpos(getx(pos, from) / 2, gety(pos, from) / 2, to);
	}

	private int randomMove(int pos, int Size) {
		Random r = new Random();
		int n = r.nextInt(4);

		switch (n) {
		case 0:
			if ((pos % Size) == 0)
				return pos + 1;
			else
				return pos - 1;
			// break;
		case 1:
			if ((pos % Size) == (Size - 1))
				return pos - 1;
			else
				return pos + 1;
			// break;
		case 2:
			if (pos < Size)
				return pos + Size;
			else
				return pos - Size;
			// break;
		case 3:
			if (pos >= Size * (Size - 1))
				return pos - Size;
			else
				return pos + Size;
			// break;
		}
		System.out.println("ERROR in randomMove()");
		return pos;
	}

	private int updateMove(int pos, int Size) {
		// System.out.println("\npos: " + pos + "\tSize" + Size);
		if (((pos % Size) != (Size - 1)) && aux[pos + 1] != '+')
			return pos + 1;
		else if ((pos % Size) != 0 && aux[pos - 1] != '+')
			return pos - 1;
		else if ((pos >= Size) && aux[pos - Size] != '+')
			return pos - Size;
		else if ((pos < Size * (Size - 1)) && aux[pos + Size] != '+')
			return pos + Size;
		else
			return -1;

	}

	private void clearPath(int next, int prev) {
		int xn = 2 * getx(next, auxSize) + 1;
		int yn = 2 * gety(next, auxSize) + 1;
		int xp = 2 * getx(prev, auxSize) + 1;
		int yp = 2 * gety(prev, auxSize) + 1;

		int varx = (xn - xp) / 2;
		int vary = (yn - yp) / 2;

		int altx = xp + varx;
		int alty = yp + vary;

		int altpos = getpos(altx, alty, mapSize);

		layout[altpos] = ' ';
		/*
		 * next = getpos(xn, yn, mapSize); prev = getpos(xp, yp, mapSize);
		 */

	}

}

