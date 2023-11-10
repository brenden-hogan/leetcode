class Solution {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.isEmpty()|| haystack.equals(needle)){
            return 0;
        }
        //Do a sliding window of length needle 
        int winSize = needle.length();
        
        for (int i = 0; i < (haystack.length() - winSize)+1; i++){
            if(haystack.substring(i, i+winSize).equals(needle)){
                return i;
            }
        }
        return -1;
    }
}