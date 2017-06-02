package gui;

import java.util.concurrent.TimeUnit;

import game.Game;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		boolean dead = false;
		boolean won = false;
		Gui g = new Gui();
		g.initialize();
		g.drawGame();
		while (!dead && !won) {
			if (g.game.isDead()) {
				dead = true;
			}else if (g.game.isAWinner()) {
				won = true;
			}
		}
		System.out.println(dead);
		System.out.println(won);
		if (dead) {
			g.drawDead();
		}else if (won) {
			g.drawWin();
		}
	}

}
