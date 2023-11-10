class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        
        int p1 = m - 1; // Real last index of nums1
        int p2 = n - 1; // Last/True index of nums2
        int p3 = m + n - 1; // True index of nums1
        
        while(p3 >= 0 && p2 >= 0 && p1 >= 0){
            if(p2 >= 0 && p1 >=0){
                if(nums2[p2] > nums1[p1]){
                    nums1[p3] = nums2[p2];
                    p3--;
                    p2--;
                } else {
                    nums1[p3] = nums1[p1];
                    p1--;
                    p3--;
                }
            } else {
                break;
            }
        }
        while(p3 >= 0 && p2 >= 0){
            nums1[p3--] = nums2[p2--];
        }
        
    }
}