package game;

public class Ghost extends Character {

	public Ghost(int row, int col, Game g) {
		super(row, col, g);
		// TODO Auto-generated constructor stub
	}

	public void moveUp() {
		if (game.map[y + 1][x] != 1) {
			game.map[y + 1][x] = 4;
			game.map[y][x] = game.map2[y][x];
			y += 1;
		}
	}

	public void moveLeft() {
		if (game.map[y][x - 1] != 1) {
			game.map[y][x - 1] = 4;
			game.map[y][x] = game.map2[y][x];
			x -= 1;
		}
	}

	public void moveDown() {
		if (game.map[y - 1][x] != 1 || game.map[y - 1][x] != 1) {
			game.map[y - 1][x] = 4;
			game.map[y][x] = game.map2[y][x];
			y -= 1;
		}
	}

	public void moveRight() {
		if (game.map[y][x + 1] != 1) {
			game.map[y][x + 1] = 4;
			game.map[y][x] = game.map2[y][x];
			x += 1;
		}
	}
}
