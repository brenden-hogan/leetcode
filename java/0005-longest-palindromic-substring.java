class Solution {
    // Time Complexity O(n^2)
    // Space Complexity(O(n))
    public String longestPalindrome(String s) {
        if(s.length() == 0) return "";
        
        int left = 0;
        int right = 0;
        
        char[] cArr = s.toCharArray();
        
        for(int i = 0; i < cArr.length; i++){
            
            int len = Math.max(expand(cArr, i, i), expand(cArr, i, i + 1)); // Expand around the current value or the current value + 1 to catch the odd length case
            
            if(len > right - left + 1){ // Found a longer one!
                left = i - (len - 1) / 2; // left is len/2 to the left of i
                right = i + len / 2; // right is len/2 to the right of i
            }
        }
        
        return s.substring(left, right + 1); // Whatever is at the end is the biggest.        
    }
    
    public int expand(char[] cArr, int i, int j){
        while(i >= 0 && j < cArr.length && cArr[i] == cArr[j]){ //Expand until we are no longer a palindrome
            i--;
            j++;
        }
        return j - i - 1; // Start - end - 1 for the loop exceeding bounds
    }
}