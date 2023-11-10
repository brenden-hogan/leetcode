class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length-1;
        int maxArea = 0;
        while (l<r) {
            maxArea = Math.max(maxArea, areaCalc(l, r, height));
            if (height[l] > height[r]){
                r--;
            }else{
                l++;
            }
        }
        return maxArea;
        
    }
    
    public int areaCalc(int l, int r, int[] height){
        int heightMin = height[l] > height[r] ? height[r] : height[l];
        return (r - l) * heightMin;
    }
}