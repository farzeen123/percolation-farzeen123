import java.util.Arrays;

public class PercolationUF implements IPercolate {
	private final int VTOP;
	private final int VBOTTOM;
	boolean[][] myGrid;
	IUnionFind myFinder;
	int myOpenCount;

	public PercolationUF(int size, IUnionFind finder) {
		
		VTOP = size * size;
		VBOTTOM = size * size + 1;
		 myOpenCount = 0;
		myGrid = new boolean[size][size]; // create a grid of size.

		finder.initialize(size * size + 2); // did whatever was said
		 myFinder = finder;
		for (boolean[] row : myGrid) {
			Arrays.fill(row, false); // fill everything false
		}

	}

	private boolean inBounds(int row, int col) {
		// if (! inBounds(row,col)) { //chEck if you are within bounds.

		if (row < 0 || row >= myGrid.length)
			return false;
		
		if (col < 0 || col >= myGrid.length)
			return false;
		return true;
	}

	@Override
	public void open(int row, int col) {
		// TODO Auto-generated method stub
		if (!inBounds(row, col)) { // chEck if you are within bounds.
			throw new IndexOutOfBoundsException("index out of bound");
		}
		if (myGrid[row][col] != false) { // check if grid cell is not full
			return; // if full return
		} 
			myOpenCount += 1; // count open cells.
		
		myGrid[row][col] = true; // set the open cells to full.
		 updateOnOpen(row,col); //update the index
		// if on top then do union shit with top
		if (row == 0) {
			myFinder.union(getIndex(row, col), VTOP);
		}
		// if last row the do the union shit with bottom
		if (row == myGrid.length - 1) {
			myFinder.union(getIndex(row, col), VBOTTOM);
		}
		
		
		
	}

	private void updateOnOpen(int row, int col) {
		
		if (!inBounds(row, col)) { // chEck if you are within bounds.
			throw new IndexOutOfBoundsException("index out of bound");

		}
		int poop = getIndex(row,col);
		if(inBounds(row+1, col) && isOpen(row+1,col)){
			myFinder.union(poop, getIndex(row+1,col));	
		}
		if(inBounds(row-1, col) && isOpen(row-1,col)) {
			myFinder.union(poop, getIndex(row-1,col));	
		}
		if(inBounds(row, col+1) && isOpen(row,col+1)) {
			myFinder.union(poop, getIndex(row,col+1));	
		}
		if(inBounds(row, col-1) && isOpen(row,col-1)) {
			myFinder.union(poop, getIndex(row,col-1));	
		}
		// TODO Auto-generated method stub
			
		
	}

	// private void updateOnOpen(int row, int col) {

	// TODO Auto-generated method stub

	// }

	@Override
	public boolean isOpen(int row, int col) {
		if (!inBounds(row, col)) { // chEck if you are within bounds.
			throw new IndexOutOfBoundsException("index out of bound");

		}

		// TODO Auto-generated method stub
		return myGrid[row][col];
	}

	@Override
	public boolean isFull(int row, int col) {
		// TODO Auto-generated method stub
		if (!inBounds(row, col)) { // chEck if you are within bounds.
			throw new IndexOutOfBoundsException("index out of bound");

		}

		return myFinder.connected(getIndex(row, col), VTOP);
	}

	private int getIndex(int row, int col) {
		int m = row * myGrid.length + col; // convert index into a number that can be used in various methods.
		// TODO Auto-generated method stub
		return m;
	}

	@Override
	public boolean percolates() {
		return myFinder.connected(VTOP, VBOTTOM);
		// TODO Auto-generated method stub

	}

	@Override
	public int numberOfOpenSites() {

		return myOpenCount;
	}

}
