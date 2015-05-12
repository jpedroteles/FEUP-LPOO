package tests;

import lpoo_final.Dragon;
import lpoo_final.Hero;
import lpoo_final.Map;
import lpoo_final.RandomMap;
import lpoo_final.StaticMap;
import lpoo_final.Sword;
import lpoo_final.Armor;
import lpoo_final.Dart;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Testes {

	@Test
	public void CreatGameState() // i
	{
		Map _map = new StaticMap(0);
		Hero h = new Hero();
		assertEquals(11, h.getPos());
		Dragon d = new Dragon();
		assertEquals(31, d.getDragonPos(0));
		Sword s = new Sword();
		assertEquals(81, s.getPos());
		assertFalse(h.getHeroProtected());
		assertFalse(h.getHeroArmed());
	}

	@Test
	public void MoveHeroSuccessTest() // ii
	{
		Map _map = new StaticMap(0);
		Hero h = new Hero();
		Dragon d = new Dragon();
		assertEquals(11, h.getPos());
		h.applyMove(h.newPosition('s', _map, d), _map, d);
		assertEquals(21, h.getPos());
	}

	@Test
	public void DragonKillHero() // iii
	{
		Map _map = new StaticMap(0);
		Hero h = new Hero();
		Dragon d = new Dragon();

		assertFalse(h.getHeroArmed());
		assertTrue(h.getHeroAlive());
		assertTrue(d.getDragonAlive(0));

		assertEquals(31, d.getDragonPos(0));
		assertEquals(11, h.getPos());

		assertEquals('H', _map.getMapElem(11));
		assertEquals('D', _map.getMapElem(31));

		h.applyMove(h.newPosition('s', _map, d), _map, d);

		assertTrue(h.getHeroAlive());
		assertTrue(d.getDragonAlive(0));

		assertEquals(31, d.getDragonPos(0));
		assertEquals(21, h.getPos());

		assertEquals(' ', _map.getMapElem(11));
		assertEquals('H', _map.getMapElem(21));
		assertEquals('D', _map.getMapElem(31));

		h.applyMove(h.newPosition('s', _map, d), _map, d);

		assertFalse(h.getHeroAlive());
		assertTrue(d.getDragonAlive(0));

		assertEquals(31, d.getDragonPos(0));

		assertEquals(' ', _map.getMapElem(21));
		assertEquals('D', _map.getMapElem(31));
	}

	@Test
	public void FailExitWithoutKill() // iv
	{
		Map _map = new StaticMap(0);
		Hero h = new Hero();
		Dragon d = new Dragon();

		h.applyMove(h.newPosition('d', _map, d), _map, d);
		h.applyMove(h.newPosition('d', _map, d), _map, d);
		h.applyMove(h.newPosition('d', _map, d), _map, d);
		h.applyMove(h.newPosition('d', _map, d), _map, d);
		h.applyMove(h.newPosition('d', _map, d), _map, d);
		h.applyMove(h.newPosition('s', _map, d), _map, d);
		h.applyMove(h.newPosition('s', _map, d), _map, d);
		h.applyMove(h.newPosition('s', _map, d), _map, d);
		h.applyMove(h.newPosition('s', _map, d), _map, d);
		h.applyMove(h.newPosition('s', _map, d), _map, d);
		h.applyMove(h.newPosition('s', _map, d), _map, d);
		h.applyMove(h.newPosition('s', _map, d), _map, d);
		h.applyMove(h.newPosition('d', _map, d), _map, d);
		h.applyMove(h.newPosition('d', _map, d), _map, d);
		h.applyMove(h.newPosition('w', _map, d), _map, d);
		h.applyMove(h.newPosition('w', _map, d), _map, d);
		h.applyMove(h.newPosition('w', _map, d), _map, d);

		assertEquals(31, d.getDragonPos(0));
		assertEquals(58, h.getPos());

		assertEquals('S', _map.getMapElem(59));
		assertEquals('H', _map.getMapElem(58));
		assertEquals('D', _map.getMapElem(31));

		h.applyMove(h.newPosition('d', _map, d), _map, d);

		assertEquals(58, h.getPos());

		assertEquals('S', _map.getMapElem(59));
		assertEquals('H', _map.getMapElem(58));
		assertEquals('D', _map.getMapElem(31));

	}

	@Test
	public void KillAndExit() // v
	{
		Map _map = new StaticMap(0);
		Hero h = new Hero();
		Dragon d = new Dragon();
		Sword s = new Sword();

		h.applyMove(h.newPosition('d', _map, d), _map, d);
		h.applyMove(h.newPosition('d', _map, d), _map, d);
		h.applyMove(h.newPosition('d', _map, d), _map, d);
		h.applyMove(h.newPosition('s', _map, d), _map, d);
		h.applyMove(h.newPosition('s', _map, d), _map, d);
		h.applyMove(h.newPosition('s', _map, d), _map, d);
		h.applyMove(h.newPosition('s', _map, d), _map, d);
		h.applyMove(h.newPosition('a', _map, d), _map, d);
		h.applyMove(h.newPosition('a', _map, d), _map, d);
		h.applyMove(h.newPosition('a', _map, d), _map, d);
		h.applyMove(h.newPosition('s', _map, d), _map, d);
		h.applyMove(h.newPosition('s', _map, d), _map, d);
		h.applyMove(h.newPosition('s', _map, d), _map, d);

		assertEquals('A', _map.getMapElem(81));

		h.applyMove(h.newPosition('w', _map, d), _map, d);

		assertEquals(' ', _map.getMapElem(81));
		assertEquals('A', _map.getMapElem(71));

		h.applyMove(h.newPosition('w', _map, d), _map, d);
		h.applyMove(h.newPosition('w', _map, d), _map, d);
		h.applyMove(h.newPosition('d', _map, d), _map, d);
		h.applyMove(h.newPosition('d', _map, d), _map, d);
		h.applyMove(h.newPosition('d', _map, d), _map, d);
		h.applyMove(h.newPosition('s', _map, d), _map, d);
		h.applyMove(h.newPosition('s', _map, d), _map, d);
		h.applyMove(h.newPosition('s', _map, d), _map, d);
		h.applyMove(h.newPosition('d', _map, d), _map, d);
		h.applyMove(h.newPosition('d', _map, d), _map, d);
		h.applyMove(h.newPosition('d', _map, d), _map, d);
		h.applyMove(h.newPosition('d', _map, d), _map, d);
		h.applyMove(h.newPosition('w', _map, d), _map, d);
		h.applyMove(h.newPosition('w', _map, d), _map, d);
		h.applyMove(h.newPosition('w', _map, d), _map, d);

		assertEquals(58, h.getPos());
		assertTrue(h.getHeroArmed());
		assertTrue(d.getDragonAlive(0));

		assertEquals('S', _map.getMapElem(59));
		assertEquals('A', _map.getMapElem(58));
		assertEquals('D', _map.getMapElem(31));

		h.applyMove(h.newPosition('d', _map, d), _map, d);

		assertEquals(58, h.getPos());

		assertEquals('S', _map.getMapElem(59));
		assertEquals('A', _map.getMapElem(58));

		h.applyMove(h.newPosition('s', _map, d), _map, d);
		h.applyMove(h.newPosition('s', _map, d), _map, d);
		h.applyMove(h.newPosition('s', _map, d), _map, d);
		h.applyMove(h.newPosition('a', _map, d), _map, d);
		h.applyMove(h.newPosition('a', _map, d), _map, d);
		h.applyMove(h.newPosition('a', _map, d), _map, d);
		h.applyMove(h.newPosition('a', _map, d), _map, d);
		h.applyMove(h.newPosition('w', _map, d), _map, d);
		h.applyMove(h.newPosition('w', _map, d), _map, d);
		h.applyMove(h.newPosition('w', _map, d), _map, d);
		h.applyMove(h.newPosition('a', _map, d), _map, d);
		h.applyMove(h.newPosition('a', _map, d), _map, d);
		h.applyMove(h.newPosition('a', _map, d), _map, d);
		h.applyMove(h.newPosition('w', _map, d), _map, d);
		h.applyMove(h.newPosition('w', _map, d), _map, d);

		assertEquals(31, h.getPos());
		assertFalse(d.getDragonAlive(0));
		assertTrue(h.getHeroAlive());

		assertEquals('A', _map.getMapElem(31));

		h.applyMove(h.newPosition('w', _map, d), _map, d);
		h.applyMove(h.newPosition('w', _map, d), _map, d);

		//

		h.applyMove(h.newPosition('d', _map, d), _map, d);
		h.applyMove(h.newPosition('d', _map, d), _map, d);
		h.applyMove(h.newPosition('d', _map, d), _map, d);
		h.applyMove(h.newPosition('d', _map, d), _map, d);
		h.applyMove(h.newPosition('d', _map, d), _map, d);
		h.applyMove(h.newPosition('s', _map, d), _map, d);
		h.applyMove(h.newPosition('s', _map, d), _map, d);
		h.applyMove(h.newPosition('s', _map, d), _map, d);
		h.applyMove(h.newPosition('s', _map, d), _map, d);
		h.applyMove(h.newPosition('s', _map, d), _map, d);
		h.applyMove(h.newPosition('s', _map, d), _map, d);
		h.applyMove(h.newPosition('s', _map, d), _map, d);
		h.applyMove(h.newPosition('d', _map, d), _map, d);
		h.applyMove(h.newPosition('d', _map, d), _map, d);
		h.applyMove(h.newPosition('w', _map, d), _map, d);
		h.applyMove(h.newPosition('w', _map, d), _map, d);
		h.applyMove(h.newPosition('w', _map, d), _map, d);

		h.applyMove(h.newPosition('d', _map, d), _map, d);

		assertEquals(59, h.getPos());

		assertEquals('R', _map.getMapElem(59)); // Reached
		assertEquals(' ', _map.getMapElem(58));

		assertTrue(h.getExitReached()); // Game end

	}


	@Test
	public void KillWithFire() // vi
	{
		Map _map = new StaticMap(0);
		Hero h = new Hero();
		Dragon d = new Dragon();

		d.attack(_map, h);

		assertFalse(h.getHeroAlive());
		assertTrue(d.getDragonAlive(0));
	}

	@Test
	public void ArmorWorking() // vii
	{
		Map _map = new StaticMap(1);
		Hero h = new Hero();
		Dragon d = new Dragon();
		Armor a = new Armor();

		assertEquals('H', _map.getMapElem(11));
		assertEquals('P', _map.getMapElem(12));
		assertEquals(12, a.getArmorPos());
		assertFalse(h.getHeroProtected());

		h.applyMove(h.newPosition('d', _map, d), _map, d);

		assertEquals('H', _map.getMapElem(12));
		assertTrue(h.getHeroProtected());

		h.applyMove(h.newPosition('a', _map, d), _map, d);

		assertEquals('H', _map.getMapElem(11));
		assertEquals(' ', _map.getMapElem(12));

		d.attack(_map, h);

		assertTrue(h.getHeroAlive());
	}

	@Test
	public void DartWorking() // viii
	{
		Map _map = new StaticMap(2);
		Hero h = new Hero();
		Dragon d = new Dragon();
		Dart drt = new Dart();

		assertEquals('H', _map.getMapElem(11));
		assertEquals('*', _map.getMapElem(12));
		assertEquals(12, drt.getDartPos());
		assertEquals(1, drt.getDartAmount());
		assertEquals(0, h.getDartAmount());

		h.applyMove(h.newPosition('d', _map, d), _map, d);

		assertEquals('H', _map.getMapElem(12));
		assertEquals(1, h.getDartAmount());

		h.applyMove(h.newPosition('a', _map, d), _map, d);

		assertEquals('H', _map.getMapElem(11));
		assertEquals(' ', _map.getMapElem(12));

		h.applyMove(h.newPosition('k', _map, d), _map, d);
		assertEquals(0, h.getDartAmount());
		assertFalse(d.getDragonAlive(0));
	}

	@Test
	public void DragonMoveRand() // ix
	{
		long xi = System.currentTimeMillis();

		boolean[] fd = new boolean[100];
		for (int i = 0; i < 100; i++) {
			fd[i] = false;
		}
		fd[22] = true;
		Map _map = new StaticMap(3);
		Dragon d = new Dragon();
		Hero h = new Hero();

		while (true) {
			long xf = System.currentTimeMillis();
			fd[d.getDragonPos(0)] = true;
			d.moveDragons(_map, h);
			// _map.displayMap();

			if (xf - xi > 1000)
				break;
		}

		assertTrue(fd[11]);
		assertTrue(fd[12]);
		assertTrue(fd[13]);
		assertTrue(fd[21]);
		assertTrue(fd[22]);
		assertTrue(fd[23]);
		assertTrue(fd[31]);
		assertTrue(fd[32]);
		assertTrue(fd[33]);
	}

	@Test
	public void CreatRandomState() // i
	{
		Map _map = new RandomMap(7);
		Hero h = new Hero(_map);
		Dragon d = new Dragon(2, _map);
		Sword s = new Sword(_map);
		Armor a = new Armor(_map);
		Dart dr = new Dart(2, _map);
		assertTrue(h.getPos() < 7 * 7);

		assertFalse(h.getHeroProtected());
		assertFalse(h.getHeroArmed());
	}

}
