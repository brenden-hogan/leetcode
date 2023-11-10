class Solution {
    public String longestCommonPrefix(String[] strs) {
        int index = 0;
        String longestCommonPrefix = "";
        boolean atEnd = false;
        while(!atEnd){
            String curChar = "";
            for (String str : strs){
                if (index > str.length()-1){
                    atEnd = true;
                    break;
                }
                if (curChar.isEmpty()){
                    curChar = str.substring(index, index+1);
                } else if (curChar.equals(str.substring(index, index+1))){
                    continue;
                } else {
                    atEnd = true;
                    break;
                }
            }
            if (!atEnd){
                longestCommonPrefix += curChar;
            }
            index++;
        }
        return longestCommonPrefix;
    }
}