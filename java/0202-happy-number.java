class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> pastD = new HashSet<>();
        while (true){
            int newDig = squareEachDigit(n);
            if (newDig == 1) return true;
            if (pastD.contains(newDig)){
                //loop
                return false;
            }else {
                n = newDig;
                pastD.add(newDig);
            } 
        }
    }
    
    public static int squareEachDigit(int d){
        int returnInt = 0;
        while (d != 0){
            int rightD = d%10;
            d=d/10;
            returnInt += rightD * rightD;
        }
        return returnInt;
    }
}