class Solution {
    public int romanToInt(String s) {
        int returnValue = 0;
        int prevValue = 0;
        for (int i=0; i < s.length(); i++){
            char c = s.charAt(i);
            int curValue = singleRomanToInt(c);
            if (curValue>prevValue){
                returnValue -= prevValue;
                returnValue += (curValue-prevValue);
            } else {
                returnValue += curValue;
            }
            prevValue = curValue;
        }
        return returnValue;
    }
    
    public int singleRomanToInt(char c) {
        if (c == 'I'){
            return 1;
        } else if (c == 'V') {
            return 5;
        }else if (c == 'X') {
            return 10;
        }else if (c == 'L') {
            return 50;
        }else if (c == 'C') {
            return 100;
        }else if (c == 'D') {
            return 500;
        }else if (c == 'M') {
            return 1000;
        }else {
            return 0;
        }
    }
}