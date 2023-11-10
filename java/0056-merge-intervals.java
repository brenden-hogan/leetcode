class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        
        List<int[]> outList = new ArrayList<>();
        for(int[] i : intervals){
            if(outList.isEmpty() || i[0] > outList.get(outList.size()-1)[1]){
                outList.add(i);
            } else {
                //merge
                outList.get(outList.size()-1)[1] = Math.max(i[1], outList.get(outList.size()-1)[1]);
            }
        }
        return outList.toArray(new int[outList.size()][2]);
    }
}