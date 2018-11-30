
public class PercolationDFSFast extends PercolationDFS {

	public PercolationDFSFast(int n) {
		super(n);
		// TODO Auto-generated constructor stub
	}
	
	/*public void open(int row, int col) {
		if (! inBounds(row,col)) {
			throw new IndexOutOfBoundsException("index out of bound");
			
	}
		
    super.open(row, col);
}
	
	public boolean isOpen(int row, int col) {
		if (! inBounds(row,col)) {
			throw new IndexOutOfBoundsException("index out of bound");
			
	}
		
		return super.isOpen(row,col);
		
	}
	
	public boolean isFull(int row, int col) {
		if (! inBounds(row,col)) {
			throw new IndexOutOfBoundsException("index out of bound");
			
	}
		return super.isFull(row, col);
		
	}*/
	@Override
	protected void updateOnOpen(int row, int col) {
		if (! inBounds(row,col)) {
			throw new IndexOutOfBoundsException("index out of bound");
			
		}
		int j = 0;
		
	    int[] rowDelta = {-1,1,0,0};
	    
        int[] colDelta = {0,0,-1,1};
        
        for(int k =0; k < colDelta.length; k++) {
        	
			Integer nr = rowDelta[k] + row;
			
			Integer nc = colDelta[k] + col;
			
			if(inBounds(nr,nc)&& isFull(nr,nc)) {
			j=1;
				
			}
        }
			if(j==1) {
				myGrid[row][col] = FULL;  
				dfs(row,col);
				
			}
			
			
		/*if((inBounds(row,col)) && isFull(row,col)){
			myGrid[row][col] = FULL;    //mark it as full
			dfs(row,col); //check right                   //
			dfs(row+1,col); //check left
			dfs(row,col+1); //check up
			dfs(row,col-1); //checkbottom
			
		}
		if((inBounds(row+1,col))&& isFull(row+1,col)){
			myGrid[row][col] = FULL;
			
			//dfs(row-1,col); //check right
			dfs(row,col); //check left
			//dfs(row,col+1); //check up
			//dfs(row,col-1); //checkbottom
			
		}
		if((inBounds(row-1,col))&& isFull(row-1,col)){
            myGrid[row][col] = FULL;
			
			dfs(row-1,col); //check right
			dfs(row+1,col); //check left
			dfs(row,col+1); //check up
			dfs(row,col-1); //checkbottom
		}
		if((inBounds(row,col-1))&& isFull(row,col-1)){
            myGrid[row][col] = FULL;
			
			dfs(row-1,col); //check right
			dfs(row+1,col); //check left
			dfs(row,col+1); //check up
			dfs(row,col-1); //checkbottom
		}
		
		if((inBounds(row,col+1))&& isFull(row,col+1)){
            myGrid[row][col] = FULL;
			
			dfs(row-1,col); //check right
			dfs(row+1,col); //check left
			dfs(row,col+1); //check up
			dfs(row,col-1); //checkbottom
		}*/
		
	}

}