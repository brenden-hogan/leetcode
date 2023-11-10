class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] rowZero = new boolean[n];
        boolean[] colZero = new boolean[m];
        Arrays.fill(rowZero, false);
        Arrays.fill(colZero, false);
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[j][i] == 0) {
                    rowZero[i] = true;
                    colZero[j] = true;
                }
            }
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(rowZero[i] == true || colZero[j] == true) {
                    matrix[j][i] = 0;
                }
            }
        }
    }
}