class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curResult = new ArrayList<>();
        if (numRows == 0) return result;
        for(int i=1; i <= numRows; i++){
            int addPointer = 0;
            for (int j=0; j < i; j++){
                if (j==0 || j==(i-1)){
                    curResult.add(1);
                } else if (i>1) {
                    int addValue = result.get(i-2).get(addPointer) + result.get(i-2).get(addPointer+1);
                    curResult.add(addValue);
                    addPointer++;
                }
            }
            result.add(new ArrayList<>(curResult));
            curResult.clear(); 
        }
        return result;
        
        
    }
}

//  1
// 1 1
//1 1 1  //ignore first and last and then going across keep track of above values till filled