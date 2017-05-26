package game;

public class Character {
	protected Game game;
	protected int x;
	protected int y;

	public Character(int row, int col, Game g) {
		y = row;
		x = col;
		game = g;
	}

}
