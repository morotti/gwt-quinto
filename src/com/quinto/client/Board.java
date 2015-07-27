package com.quinto.client;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Board {
	int side;

	// cell[y][x]
	boolean board[][];

	Board(int side) {
		generate(side);
	}

	/**
	 * Flip the selected cell and its neighbors
	 * 
	 * @param x
	 * @param y
	 */
	void click(int x, int y) {
		// quand la case x, y est cliquee
		// inverse l'etat des cases qui se trouvent autour
		// s'il y a des cases autours
		flip(x, y);

		if (x > 0)
			flip(x - 1, y);

		if (x < side - 1)
			flip(x + 1, y);

		if (y > 0)
			flip(x, y - 1);

		if (y < side - 1)
			flip(x, y + 1);
	}

	/**
	 * Generate a new board with the given size
	 * 
	 * @param side
	 */
	void generate(int side) {
		this.side = side;
		this.board = new boolean[side][side];
	}

	boolean isWon()
	{
		return countBlacks() == side * side;
	}

	int countBlacks() {
		int count = 0;

		for (int y = 0; y < side; y++) {
			for (int x = 0; x < side; x++) {
				if (board[y][x] == true)
					count++;
			}
		}

		return count;
	}

	int countWhites() {
		return side * side - countBlacks();
	}

	void set(int x, int y) {
		set(x, y, true);
	}

	void set(int x, int y, boolean value) {
		board[y][x] = value;
	}

	void reset(int x, int y) {
		board[y][x] = false;
	}

	void flip(int x, int y) {
		board[y][x] = !board[y][x];
	}

	boolean get(int x, int y) {
		return board[y][x];
	}
	
	int getSide()
	{
		return this.side;
	}

}
