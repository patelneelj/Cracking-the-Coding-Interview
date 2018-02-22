
public class MatrixSetZeroForAllRowsColumns {
	public void setZeroes(int[][] matrix) {
        boolean firstRowZero = false;
        boolean firstColumnZero = false;
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColumnZero = true;
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                firstRowZero = true;
                break;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < n; j++)
                    matrix[i][j] = 0;
            }
        }
        for (int i = 1; i < n; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j < m; j++)
                    matrix[j][i] = 0;
            }
        }
        if (firstRowZero) {
            for (int i = 0; i < n; i++)
                matrix[0][i] = 0;
        }
        if (firstColumnZero) {
            for (int i = 0; i < m; i++)
                matrix[i][0] = 0;
        }
    }

	   public  void printMatrix(int mat[ ][ ], int R, int C)
	    {
	        int i, j;
	        for (i = 0; i < R; i++)
	        {
	            for (j = 0; j < C; j++)
	            {
	                System.out.print(mat[i][j]+ " ");
	            }
	            System.out.println();
	        }
	    }

	public static void main(String[] args) {
		 int mat[][] = {{1, 5, 7, 2},
	                {2, 0, 7, 3},
	                {1, 8, 5, 0}};

		 MatrixSetZeroForAllRowsColumns m = new MatrixSetZeroForAllRowsColumns();
		 m.printMatrix(mat, 3, 4);
		 m.setZeroes(mat);
		  System.out.println();
		  System.out.println();
		 m.printMatrix(mat, 3, 4);
		 system.out.println();
	}

}
