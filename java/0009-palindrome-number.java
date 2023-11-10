class Solution {
    public boolean isPalindrome(int x) {
        String intString = String.valueOf(x);
        if (intString.equals(reversedString(intString))){
            return true;
        }
        return false;
    }
    public String reversedString(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }
}