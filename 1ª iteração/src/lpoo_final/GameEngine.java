/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lpoo_final;

import java.util.Scanner;

public class GameEngine {
	Map m;
	Hero h;
	Dragon drg;
	Sword s;
	Dart drt;
	Armor arm;

	public GameEngine() {
		menuInicial();
		loop();
	}

	public void loop() {
		while (!endGame()) {
			displayMapAndInfo();
			System.out.println("DRT: " + h.dartAmount);
			h.moveHero(m, drg);
			drg.fallAsleep(m);
			drg.awakeDragon(m);
			drg.moveDragons(m, h);
			drg.attack(m, h);

		}
	}

	private void menuInicial() {
		Scanner scn = new Scanner(System.in);
		System.out.println("1. Static map.");
		System.out.println("2. Random map.");
		System.out.println("q (exit)");
		char i = scn.next().charAt(0);
		
		if (i=='1'){
			m = new StaticMap(0);
			h = new Hero();
			drg = new Dragon();
			s = new Sword();


		}
			
		else if(i =='2')
			initRandomGame();		
	}
	
	private void initRandomGame(){

		System.out.println("Map dimention?(min. 7) ");
		Scanner x = new Scanner(System.in);
		
		int option = x.nextInt();
		if(option %2==0){
			option++;
		}	
		
		m = new RandomMap(option);
		h = new Hero(m);
		drg = new Dragon(drakeBehavior(), m);
		s = new Sword(m);
		drt = new Dart(6, m);
		arm = new Armor(m);
}

	private int drakeBehavior() {
		Scanner s = new Scanner(System.in);
		System.out.println("Number of dragons: ");
		//int num = s.nextInt();
		//System.out.println("Sleeping dragons?");
		//System.out.println("1-Yes");
		//System.out.println("2-No");
		//int option=0;
		return s.nextInt();
	}
	

	private void displayMapAndInfo() {
		m.displayMap();
		System.out.println();
		System.out.println("Up:    w\n" + "Left:  a\n" + "Down:  s\n"
				+ "Right: d\n" + "Option: ");
	}

	public boolean endGame() {
		return !h.getHeroAlive() || h.getExitReached();
	}

}
