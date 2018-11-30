import java.util.Arrays;

public class PercolationUF implements IPercolate {
	private final int VTOP;
	private final int VBOTTOM;
	boolean[][] myGrid;
	IUnionFind myFinder;

	
	public PercolationUF(int size, IUnionFind finder) {
		IUnionFind myFinder = finder;
		VTOP = size*size;
		VBOTTOM = size*size+1;
		int myOpenCount = 0;
		  myGrid = new boolean [size][size]; //create a grid of size.
		
		finder.initialize(size*size+2);  //did whatever was said
		for (boolean [] row : myGrid) {
			Arrays.fill(row, false);   //fill everything false
		}
		
	}
	
	private boolean inBounds(int row, int col) {
		if(row<0|| row >= myGrid.length) return false;
		if(col < 0 || col >= myGrid.length) return false;
		return true;
	}

	@Override
	public void open(int row, int col) {
		// TODO Auto-generated method stub
		if (! inBounds(row,col)) { //chEck if you are within bounds.
			throw new IndexOutOfBoundsException("index out of bound");
			
	}
		
		
	}

	

	@Override
	public boolean isOpen(int row, int col) {
		if (! inBounds(row,col)) { //chEck if you are within bounds.
			throw new IndexOutOfBoundsException("index out of bound");
			
	}
		
		// TODO Auto-generated method stub
		return myGrid[row][col];
	}

	@Override
	public boolean isFull(int row, int col) {
		// TODO Auto-generated method stub
		if (! inBounds(row,col)) { //chEck if you are within bounds.
			throw new IndexOutOfBoundsException("index out of bound");
			
	}
		
		
		return myFinder.connected(getIndex(row,col), VTOP);
	}

	

	private int getIndex(int row, int col) {
		int m = row* myGrid.length + col;
		// TODO Auto-generated method stub
		return m;
	}

	@Override
	public boolean percolates() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int numberOfOpenSites() {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
