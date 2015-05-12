/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lpoo_final;

import java.util.Random;

public class Dragon {

	private static final int FIRE_RANGE = 3;
	private static final int SLEEP_TIME = 3;

	private int numDragons;
	private int[] dragonPos;
	private int[] sleepTime;
	private boolean[] dragonAlive;
	private boolean[] dragonSleep;

	public Dragon(int n, Map m) {
		numDragons = n;
		dragonPos = new int[n];
		dragonAlive = new boolean[n];
		dragonSleep = new boolean[n];
		sleepTime = new int[n];
		Random r = new Random();
		int pos;
		for (int i = 0; i < n; i++) {
			pos = r.nextInt(m.getMapSize() * m.getMapSize());
			if (m.getMapElem(pos) == ' ') {
				m.setMapElem(pos, 'D');
				sleepTime[i] = 0;
				dragonPos[i] = pos;
				dragonAlive[i] = true;
				dragonSleep[i] = false;
			} else
				i--;
		}
	}

	public Dragon() {
		numDragons = 1;
		dragonPos = new int[1];
		dragonAlive = new boolean[1];
		dragonSleep = new boolean[1];
		sleepTime = new int[1];
		sleepTime[0] = 0;
		dragonPos[0] = 31;
		dragonAlive[0] = true;
		dragonSleep[0] = false;

	}


	private void moveDragon(Map m, int i, Hero h) {
		Random r = new Random();
		int newPosition = randomMove(dragonPos[i], m);
		System.out.println(newPosition + " " + i);

		if (setNewPosition(i, newPosition, m, h)) {
			correctPrevious(i, m);
			dragonPos[i] = newPosition;
		}
	}

	private int updtPos(int pos, int n, Map m) {

		switch (n) {
		case 0:
			return pos + 1;
		case 1:
			return pos - 1;
		case 2:
			return pos + m.getMapSize();
		case 3:
			return pos - m.getMapSize();
		}

		System.out.println("ERROR in updtDir()");
		return pos;

	}

	private int randomMove(int pos, Map m) {
		Random r = new Random();
		int n = r.nextInt(4);

		for (int i = 0; i < 4; i++) {

			int newM = updtPos(pos, n, m);
			if (m.getMapElem(newM) != 'X' || m.getMapElem(newM) != 'S'
					|| m.getMapElem(newM) != 'D')
				return newM;
			else {
				n = (n + 1) % 4;
				i--;
			}
		}

		return pos;
	}

	public void killDragon(int i) {
		dragonAlive[i] = false;
	}

	public int getNumDragons() {
		return numDragons;
	}

	public int getDragonPos(int i) {
		return dragonPos[i];
	}

	public void moveDragons(Map m, Hero h) {
		for (int i = 0; i < numDragons; i++) {
			if (dragonAlive[i] && !dragonSleep[i])
				moveDragon(m, i, h);
		}
	}

	public boolean getDragonAlive(int i) {
		return dragonAlive[i];
	}

	private void spitFire(Map m, int pos, Hero h) {
		Random r = new Random();
		int prob = r.nextInt(5);

		if (prob >= 3) {
			if (m.checkRow(pos, -1) != 'X')
				for (int i = 0; i < FIRE_RANGE; i++) {
					if (m.getMapElem(pos + ((-1) * (i + 1))) == 'H'
							|| m.getMapElem(pos + ((-1) * (i + 1))) == 'A')
						if (!h.getHeroProtected())
							h.killHero();
				}
			else if (m.checkRow(pos, 1) != 'X')
				for (int i = 0; i < FIRE_RANGE; i++) {
					if (m.getMapElem(pos + (1 * (i + 1))) == 'H'
							|| m.getMapElem(pos + (1 * (i + 1))) == 'A')
						if (!h.getHeroProtected())
							h.killHero();
				}
			else if (m.checkRow(pos, m.getMapSize()) != 'X')
				for (int i = 0; i < FIRE_RANGE; i++) {
					if (m.getMapElem(pos + (m.getMapSize() * (i + 1))) == 'H'
							|| m.getMapElem(pos + (m.getMapSize() * (i + 1))) == 'A')
						if (!h.getHeroProtected())
							h.killHero();
				}
			else if (m.checkRow(pos, -1 * m.getMapSize()) != 'X')
				for (int i = 0; i < FIRE_RANGE; i++) {
					if (m.getMapElem(pos + ((-1) * m.getMapSize() * (i + 1))) == 'H'
							|| m.getMapElem(pos
									+ ((-1) * m.getMapSize() * (i + 1))) == 'A')
						if (!h.getHeroProtected())
							h.killHero();
				}
		}
	}

	public void attack(Map m, Hero h) {
		for (int i = 0; i < getNumDragons(); i++)
			if (dragonAlive[i] && !dragonSleep[i])
				spitFire(m, dragonPos[i], h);
	}

	public void fallAsleep(Map m) {

		for (int i = 0; i < getNumDragons(); i++) {

			Random r = new Random();
			int n = r.nextInt(21);

			if (n == 20
					&& dragonAlive[i]
					&& (m.getMapElem(getDragonPos(i)) == 'D' || m
							.getMapElem(getDragonPos(i)) == 'd')) {
				m.setMapElem(getDragonPos(i), 'd');
				dragonSleep[i] = true;
			}
		}
	}

	public void awakeDragon(Map m) {

		for (int i = 0; i < getNumDragons(); i++) {

			if (dragonSleep[i] && dragonAlive[i]) {
				if (sleepTime[i] == SLEEP_TIME) {
					dragonSleep[i] = false;
					sleepTime[i] = 0;
					m.setMapElem(getDragonPos(i), 'D');
				} else
					sleepTime[i]++;
			}
		}
	}

	public int dragonIndex(int pos) {
		for (int i = 0; i < getNumDragons(); i++)
			if (dragonPos[i] == pos)
				return i;
		return -1;
	}

	private boolean setNewPosition(int i, int np, Map m, Hero h) {

		if (m.getMapElem(np) == ' ') {
			m.setMapElem(np, 'D');
			return true;
		} else if (m.getMapElem(np) == 'E') {
			m.setMapElem(np, 'F');
			return true;
		} else if (m.getMapElem(np) == 'P') {
			m.setMapElem(np, 'f');
			return true;
		} else if (m.getMapElem(np) == '*') {
			m.setMapElem(np, '+');
			return true;
		} else if (m.getMapElem(np) == 'H') {
			h.killHero();
			return true;
		} else if (m.getMapElem(np) == 'A') {
			killDragon(i);
			return true;
		}

		return false;
	}

	private void correctPrevious(int i, Map m) {
		if (m.getMapElem(dragonPos[i]) == 'D')
			m.setMapElem(dragonPos[i], ' ');
		else if (m.getMapElem(dragonPos[i]) == 'F')
			m.setMapElem(dragonPos[i], 'E');
		else if (m.getMapElem(dragonPos[i]) == 'f')
			m.setMapElem(dragonPos[i], 'P');
		else if (m.getMapElem(dragonPos[i]) == '+')
			m.setMapElem(dragonPos[i], '*');

	}
}
