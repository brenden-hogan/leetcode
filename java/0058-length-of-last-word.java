class Solution {
    public int lengthOfLastWord(String s) {
        int end = s.length();
        boolean endSet = false;
        for (int i = end; i > 0 ; i--){
            if (!s.substring(i-1,i).equals(" ") && !endSet) {
                    endSet = true;
                    end = i;
            } else if (endSet && s.substring(i-1,i).equals(" ")) {
                return end - i;
            }
        }
        return end;
    }
}