class Solution {
    public int mySqrt(int x) {
        if(x==1||x==0){
            return x;
        }
        double guess = x/2;

        while (Math.abs(x - (guess*guess)) > 0.4){
            guess = newtonsMethodSqrt(x, guess);
        }
        return (int)guess;
        
    }
    
    public double newtonsMethodSqrt(double N, double guess){
        return guess - ((guess/2) - (N/(2*guess)));
    }
    

}