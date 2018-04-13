package mineSweeper;

import java.util.Random;

public class Board {
	private int width = 9;// width of minefield
	private int height = 9;// height of minefield
	private int numOfBombs = 10;// number of mines
	private int[][] grid;// 2d array of ints for board

	public Board() {
		setGrid(new int[getHeight()][getWidth()]);
		placeMines();
		drawMineField();
		checkNeighbors();
		// drawMineField();
		/*
		 * clearMineField(); placeMines(); drawMineField();
		 */

	}

	/**
	 * Prints out the grid with mines
	 */
	void drawMineField() {
		for (int i = 0; i < getHeight(); i++) {
			for (int j = 0; j < getWidth(); j++) {
				System.out.print(getGrid()[i][j]);
			}
			System.out.print("\n");

		}

	}

	public void placeMines() {
		int minesPlaced = 0;
		Random rand = new Random();

		while (minesPlaced < numOfBombs) {
			int i = rand.nextInt(getHeight());
			int j = rand.nextInt(getWidth());
			if (getGrid()[i][j] != 2) {
				getGrid()[i][j] = 2;
				minesPlaced++;
			}
		}

	}

	/**
	 * clears the grid to 0
	 */
	private void clearMineField() {
		for (int i = 0; i < getHeight(); i++) {
			for (int j = 0; j < getWidth(); j++) {
				getGrid()[i][j] = 0;
			}

		}

	}

	public void checkNeighbors() {
		int bombNeighborCounter = 0;
		System.out.println("\nChek Neighbors\n");
		for (int i = 0; i < getHeight(); i++) {
			for (int j = 0; j < getWidth(); j++) {
				// check up
				if (i - 1 >= 0) {
					if (getGrid()[i - 1][j] == 2) {
						bombNeighborCounter++;
					}
				}
				// check down
				if (i + 1 > 9) {
					if (getGrid()[i + 1][j] == 2) {
						bombNeighborCounter++;
					}
				}
				// check left
				if (j - 1 >= 0) {
					if (getGrid()[i][j - 1] == 2) {
						bombNeighborCounter++;
					}
				}
				// check right
				if (j + 1 > 9) {
					if (getGrid()[i][j + 1] == 2) {
						bombNeighborCounter++;
					}
				}
				// check diagonal upper left
				if (i - 1 >= 0 && j - 1 >= 0) {
					if (getGrid()[i - 1][j - 1] == 2) {
						bombNeighborCounter++;
					}
				}
				// check diagonal upper right
				if (i - 1 >= 0 && j + 1 > 9) {
					if (getGrid()[i - 1][j + 1] == 2) {
						bombNeighborCounter++;
					}
				}
				// check diagonal lower left
				if (i + 1 > 9 && j - 1 >= 0) {
					if (getGrid()[i + 1][j - 1] == 2) {
						bombNeighborCounter++;
					}
				}
				// check diagonal lower right
				if (i + 1 > 9 && j + 1 > 9) {
					if (getGrid()[i + 1][j + 1] == 2) {
						bombNeighborCounter++;
					}

				}
				getGrid()[i][j] = bombNeighborCounter;
				System.out.print(getGrid()[i][j]);

				// System.out.print(getGrid()[i][j]);

			}
			System.out.print("\n");
		}
	}

	// Unit Testing
	public static void main(String[] args) {
		Board mineSweeper = new Board();
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int[][] getGrid() {
		return grid;
	}

	public void setGrid(int[][] grid) {
		this.grid = grid;
	}

}
