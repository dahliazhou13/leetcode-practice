/*

Link: https://leetcode.com/problems/split-array-largest-sum/

Description: Given an array nums which consists of non-negative 
integers and an integer m, you can split the array into m 
non-empty continuous subarrays.
Write an algorithm to minimize the largest sum among these m 
subarrays.


+ Set the search range between min=(largest single value) and max=(sum of all values).
    + The min starts there because we're looking for the sum of the largest group in the 
    final set of groups. 
    And no matter what groups you create, the largest value has to be in it, 
    so the largest group can't be smaller than that. 
    (Thus the assumption of no negative numbers.)

    + Calculate the midpoint between min and max. 
    This midpoint is the group size we're going to try out to see how well it performs.

    + Split the nums list into groups such that no group has a value 
    larger than the chosen midpoint. 
    Note that we may end up with too many or too few groups. That's fine.

    + Compare the number of groups we created against the target m. 
    If we created too many groups, we know the final answer must be between mid+1 and max. 
    That's because we need fewer groups and the way to achieve fewer groups is to 
    increase the allowed maximum sum in each group.

    + On the other hand, if the number of groups is too small, we know the final answer is
     between min and mid-1 because we need to increase the number of groups which means the
      target sum is something smaller than the one we used. 
      This is actually also a possible answer assuming m is valid because you can 
      always take any group and split it up to make more groups, 
      so the mid value you targeted is at worst, higher than the real value.

    + On the third hand, if the number of groups is just right, we have a possible answer,
     so remember that answer. However, we should keep searching just in case there is a 
     better answer. We're ultimately looking for smaller maximum sums,
      so the potentially better answer is between min and mid-1.

    + Repeat the process until there is nothing else to search. 
    Then use the minimum value we found during the above process.
 */

class Solution {
    public int splitArray(int[] nums, int m) {
        long left = 0;
        long right = 0;
        for(int i = 0; i < nums.length; i ++){
            right += nums[i];//Maximum value
            left = Math.max(left, nums[i]); // Minimum value
        }
        
        long res = right;
        while(left <= right){
            long mid = (left + right) >> 1;
            long sum = 0;
            int count = 1;
            for(int i =0;i < nums.length; i ++){
                if(sum + nums[i] > mid){
                    count ++;
                    sum = nums[i];
                }
                else{
                    sum += nums[i];
                }
            }
            if(count <= m){
                res = Math.min(res, mid);
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return (int)res;
    }
}