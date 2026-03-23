package Arrays.Matrix;

import java.util.Arrays;

public class MatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int m=matrix.length, n=matrix[0].length;

        int[] rowsArray= new int[m];
        int[] colsArray= new int[n];

        Arrays.fill(rowsArray,1);
        Arrays.fill(colsArray,1);

        // Marking the rows and columns that need to be made zero
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){ // if we find a zero in the matrix, we will mark the corresponding row and column in rowsArray and colsArray as 0, so that we can later set the entire row and column to 0 in the matrix.
                    rowsArray[i]=0;
                    colsArray[j]=0;
                }
            }
        }

        // Making the rows and columns zero based on the rowsArray and colsArray
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(rowsArray[i]==0 || colsArray[j]==0)
                    matrix[i][j]=0;
            }
        }
    }
}
