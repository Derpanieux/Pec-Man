package gui;

import java.util.concurrent.TimeUnit;

import game.Game;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Gui g = new Gui();
		g.initialize();
		g.drawGame();
	}

}
