class Solution {
    public void rotate(int[][] matrix) {
        // add each of the columns to a stack and then play back the stack working from the bottom to the top left to right
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < matrix.length; i++ ){//column
            for (int j = 0; j < matrix.length; j++){//row
                st.push(matrix[j][i]);
            }
        }
        
        for(int i = matrix.length-1; i >= 0; i--){//row
            for(int j = 0; j< matrix.length; j++){//column
                matrix[i][j] = st.pop();
            }
        }
    }
}