class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length-1; i>=0; i--){
            if(i==0 && digits[i] ==9){
                digits[i] = 0;
                return arrayWithOne(digits);
            } else if (digits[i] < 9){
                digits[i] = digits[i] + 1;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        return null;
    }
    
    public int[] arrayWithOne(int[] digits) {
        int[] returnArray = new int[digits.length+1];
        returnArray[0] = 1;
        for (int i = 1; i < returnArray.length; i++){
            returnArray[i] = digits[i-1];
        }
        return returnArray;
        
    }
}