package game;

public class PecMan extends Character {

	public PecMan(int row, int col, Game g) {
		super(row, col, g);
		// TODO Auto-generated constructor stub
	}

	public void moveUp() {
		if (game.map[y + 1][x] != 1) {
			if (game.map[y + 1][x] == 2) {
				game.score++;
			} else if (game.map[y + 1][x] == 3) {
				// int business = 1;
				// int atrocities = business + business;
				// int enlighten = atrocities + business;
				// int proven = enlighten + atrocities;
				// game.score += proven + proven/proven - proven + enlighten *
				// atrocities;
				game.score += 5;
			}
			game.map2[y][x] = 0;
			game.map[y + 1][x] = 5;
			game.map[y][x] = 0;
			y += 1;
		}
	}

	public void moveLeft() {
		if (game.map[y][x - 1] != 1) {
			if (game.map[y + 1][x] == 2) {
				game.score++;
			} else if (game.map[y + 1][x] == 3) {
				game.score += 5;
			}
			game.map2[y][x] = 0;
			game.map[y][x - 1] = 5;
			game.map[y][x] = 0;
			x -= 1;
		}
	}

	public void moveDown() {
		if (game.map[y - 1][x] != 1 || game.map[y - 1][x] != 7) {
			if (game.map[y + 1][x] == 2) {
				game.score++;
			} else if (game.map[y + 1][x] == 3) {
				game.score += 5;
			}
			game.map2[y][x] = 0;
			game.map[y - 1][x] = 5;
			game.map[y][x] = 0;
			y -= 1;
		}
	}

	public void moveRight() {
		if (game.map[y][x + 1] != 1) {
			if (game.map[y + 1][x] == 2) {
				game.score++;
			} else if (game.map[y + 1][x] == 3) {
				game.score += 5;
			}
			game.map2[y][x] = 0;
			game.map[y][x + 1] = 5;
			game.map[y][x] = 0;
			x += 1;
		}
	}

	public boolean isDead() {
		return // game.map[y - 1][x - 1] == 5
		game.map[y - 1][x] == 5
				// || game.map[y - 1][x + 1] == 5
				|| game.map[y][x - 1] == 5
				// || game.map[y][x] == 5
				|| game.map[y][x + 1] == 5
				// || game.map[y + 1][x - 1] == 5
				|| game.map[y - 1][x] == 5;
		// || game.map[y - 1][x + 1] == 5
	}

}
