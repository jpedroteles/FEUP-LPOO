package maze.cli;

import java.util.Scanner;

import maze.logic.Game;
import maze.logic.Maze;

public class Main {

	public static void main(String[] args) {

		System.out.println("MAZE RUNNER");

		System.out.println("1) MANUAL MAZE");
		System.out.println("2) RANDOM MAZE");
		System.out.println();
		// System.out.print("Digite o labirinto com o qual deseja jogar:");
		int option;
		int option2;
		while (true) {
			System.out.print("WHICH MAZE? ");
			Scanner sc = new Scanner(System.in);
			if (sc.hasNextInt()) {
				option = sc.nextInt();
				if ((option == 1 || option == 2))
					break;
			}
			System.out.println("INVALID INPUT!");
			System.out.println();
			sc.nextLine();
		}
		;
		System.out.println();
		System.out.println("1) STOPED DRAGON");
		System.out.println("2) DRAGON WITH RANDOM MOVIMENT");
		System.out.println("3) DRAGON WITH RANDOM MOVIMENT AND SLEEPING");
		System.out.println();		
		do
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("WHICH GAME TYPE? ");
			if (sc.hasNextInt()){
				option2 = sc.nextInt();
				if ((option2 == 1 || option2 == 2 || option2 == 3)) break;
			}
			System.out.println("INVALID INPUT!");
			System.out.println();
			sc.nextLine();
		}while (true);
		
		if (option == 1 && (option2 == 1 || option2 == 2 || option2 == 3))
		{
			Maze maze = new Maze(0,1);
			
			//if(option2 == 1) game.setTipoJogo(Game.Parado);
			//else if (option2 == 2) jogo.setTipoJogo(Game.Mover);
			//else if(option2 == 3) jogo.setTipoJogo(Game.Mover_Dormir);
			
		}
		else if (option == 2 && (option2 == 1 || option2 == 2 || option2 == 3))
		{
			
						
		}

	}
}
