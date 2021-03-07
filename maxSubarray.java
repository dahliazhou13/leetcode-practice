//Link:https://leetcode.com/explore/interview/card/google/64/dynamic-programming-4/3087/
/*
*Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.
*It is guaranteed that the answer will fit in a 32-bit integer.
*A subarray is a contiguous subsequence of the array.
*/

class Solution {
    public int maxProduct(int[] nums) {
       
        if(nums == null || nums.length == 0) return 0;
        
        int min = nums[0];
        int max = nums[0];
        int res = max;
        
        for(int i = 1; i < nums.length; i ++){
            int curr = nums[i];
            int include = Math.max(curr, Math.max(max*curr, min*curr));
            min = Math.min(curr, Math.min(max*curr, min*curr));
            max = Math.max(curr, Math.max(max*curr, min*curr));
            
            max = include;
            
            res = Math.max(max, res);
        }
        return res;
       
    }
}