class Solution {
    
    public List<Integer> outList;
    
    public List<Integer> spiralOrder(int[][] matrix) {
        outList = new ArrayList<>();
        outList.add(matrix[0][0]);
        spiral(matrix, 0, 0, 'r', 0, matrix[0].length, 0, matrix.length);
        return outList;
    }
    
    public void spiral(int[][] matrix, int row, int col, char dir, int left, int right, int up, int down) {
        if(dir == 'r'){
            if(col + 1 < right){
                outList.add(matrix[row][col + 1]);
                spiral(matrix, row, col + 1, 'r', left, right, up, down);
            } else {
                
                dir = 'd';
                up++;
                if(up >= down) return;
            }
        }
        if (dir == 'd'){
            if(row + 1 < down){
                outList.add(matrix[row + 1][col]);
                spiral(matrix, row + 1, col, 'd', left, right, up, down);
            } else {
                dir = 'l';
                right--;
                if(right <= left) return;
            }
            
        } 
        if (dir == 'l'){
            if(col - 1 >= left){
                outList.add(matrix[row][col - 1]);
                spiral(matrix, row, col - 1, 'l', left, right, up, down);
            } else {
                dir = 'u';
                down--;
                if(up >= down) return;
            }
            
        } 
        if (dir == 'u'){
            if(row - 1 >= up){
                outList.add(matrix[row - 1][col]);
                spiral(matrix, row - 1, col, 'u', left, right, up, down);
            } else if (col + 1 < right) {
                left++;
                outList.add(matrix[row][col + 1]);
                spiral(matrix, row, col + 1, 'r', left, right, up, down);
            } else {
                return;
            }
            
        }
    }
}