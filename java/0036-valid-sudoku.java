class Solution {
    public boolean isValidSudoku(char[][] board) {
        ArrayList<HashSet<Character>> cols = new ArrayList<HashSet<Character>>();
        ArrayList<HashSet<Character>> boxs = new ArrayList<HashSet<Character>>();
        HashSet<Character> rowSet = new HashSet<>();
        
        for (int i =0; i < 9; i++){
             boxs.add(new HashSet<Character>());
        }
        
        for (int col = 0; col < 9; col++){
            for (int row = 0; row < 9; row++){
                int box = whichBox(row,col);
                if (col == 0){
                    cols.add(new HashSet<Character>());
                }
                char cur = board[col][row];
                
                //Boxs
                if (boxs.get(box).contains(cur) || cols.get(row).contains(cur) || rowSet.contains(cur)){
                    return false;
                } else if (cur != '.') {
                    boxs.get(box).add(cur);
                    rowSet.add(cur);
                    cols.get(row).add(cur);
                }
            }
            rowSet.clear();
        }
        return true;
    }
    
    public int whichBox(int col, int row){
        
        if (col <= 2){
            if (row <=2){
                return 0;
            } else if (row > 2 && row <=5){
                return 3;
            }
            return 6;
            //1 4 7
        } else if (col > 2 && col <=5){
            if (row <=2){
                return 1;
            } else if (row > 2 && row <=5){
                return 4;
            }
            return 7;
            // 2 5 8
        }
        if (row <=2){
            return 2;
        } else if (row > 2 && row <=5){
            return 5;
        }
        return 8;
        
        
    }
    
    }

/*
0,0 ... 2,0    3,0 ... 5,0
    
0,2 ... 2,2    3,2 ... 5,2
*/
    
    