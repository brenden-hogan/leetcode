class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<String> set = new HashSet<>();
        int maxSize = 0;
        int winStart = 0;
        for (int i = 0; i < s.length(); i++){
            if (set.contains(s.substring(i,i+1))){
                maxSize = Math.max(set.size(), maxSize);
                while(set.contains(s.substring(i,i+1))){
                    set.remove(s.substring(winStart,winStart+1));
                    winStart++;
                }
            }
            set.add(s.substring(i,i+1));
        }
        maxSize = Math.max(set.size(), maxSize);
        return maxSize;   
    }
}