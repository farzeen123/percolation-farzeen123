import java.util.LinkedList;
import java.util.Queue;



public class PercolationBFS extends PercolationDFSFast{

	public PercolationBFS(int n) {
		super(n);
		// TODO Auto-generated constructor stub
	}
	@Override
	protected void dfs(int row, int col) {
		Queue<Integer> qp = new LinkedList<>();
		int size = myGrid.length;
		int[] rowDelta = {-1,1,0,0};
        int[] colDelta = {0,0,-1,1};
        
		myGrid[row][col] = FULL;
		//marks it full
		qp.add( row*size + col);  //add it in queue
		 while (qp.size() != 0){   //
			 
			Integer p = qp.remove();
		Integer r = p/size;
		Integer c = p% size;
			//dequeue  
			
			 for(int k =0; k < colDelta.length; k++) {
				Integer nr = rowDelta[k] + r;
				Integer nc = colDelta[k] + c;
				if(inBounds(nr,nc)&& isOpen(nr,nc) && !isFull(nr,nc)) {
					myGrid[nr][nc] = FULL;
					qp.add(nr*size+nc);
					
				}
				 
			 }
		 }
		
			
			 
		
		
		
		
	}

}
