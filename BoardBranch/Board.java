package mineSweeper;

import java.util.Random;

public class Board {
	private int width = 9;// width of minefield
	private int height = 9;// height of minefield
	private int numOfBombs = 10;// number of mines
	private int[][] grid;// 2d array of ints for board

	public Board() {
		//setGrid(new char[getHeight()][getWidth()]);
		grid = new int[height][width];
		clearMineField();
		placeMines();
		drawMineField();
		checkNeighbors();
		drawMineField();
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
				System.out.print(getGrid()[i][j] + " ");
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
			if (getGrid()[i][j] != '*') {
				getGrid()[i][j] = '*';
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
				getGrid()[i][j] = ' ';
			}

		}

	}

	public void checkNeighbors() {
		int bombNeighborCounter = 0;
		System.out.println("\nCheck Neighbors\n");
		for (int i = 0; i < getHeight(); i++) {
			for (int j = 0; j < getWidth(); j++) {
				if (grid[i][j] != '*') {
					bombNeighborCounter = 0;
					// check up
					if (i - 1 >= 0) {
						if (grid[i - 1][j] == '*') {
							bombNeighborCounter++;
						}
					}
					// check down
					if (i + 1 < 9) {
						if (grid[i + 1][j] == '*') {
							bombNeighborCounter++;
						}
					}
					// check left
					if (j - 1 >= 0) {
						if (grid[i][j - 1] == '*') {
							bombNeighborCounter++;
						}
					}
					// check right
					if (j + 1 < 9) {
						if (grid[i][j + 1] == '*') {
							bombNeighborCounter++;
						}
					}
					// check diagonal upper left
					if (i - 1 >= 0 && j - 1 >= 0) {
						if (grid[i - 1][j - 1] == '*') {
							bombNeighborCounter++;
						}
					}
					// check diagonal upper right
					if (i - 1 >= 0 && j + 1 < 9) {
						if (grid[i - 1][j + 1] == '*') {
							bombNeighborCounter++;
						}
					}
					// check diagonal lower left
					if (i + 1 < 9 && j - 1 >= 0) {
						if (grid[i + 1][j - 1] == '*') {
							bombNeighborCounter++;
						}
					}
					// check diagonal lower right
					if (i + 1 < 9 && j + 1 < 9) {
						if (grid[i + 1][j + 1] == '*') {
							bombNeighborCounter++;
						}
					}

					getGrid()[i][j] = (char) bombNeighborCounter;
				}

			}
		}
	}
	
	public void revealZeroes(){
		
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

	// Unit Testing
	public static void main(String[] args) {
		Board mineSweeper = new Board();
	}

}
