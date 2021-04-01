public class ProductExceptSelf{
    // Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums 
    // except nums[i].
    // The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        //Solution using prefix & suffix
//         int[] prefix = new int[n];
//         int[] suffix = new int[n];
//         prefix[0] = nums[0];
//         suffix[n-1] = nums[n-1];
//         for(int i = 1; i < n ; i++){
//             prefix[i] = prefix[i-1] * nums[i];
            
//             suffix[n-i-1] = suffix[n-i] * nums[n-i-1];
            
//         }
//         int[] res = new int[n];
//         res[0] = suffix[1];
//         res[n-1] = prefix[n-2];
//         for(int i = 1; i < n-1; i++){
//             res[i] = prefix[i-1]*suffix[i+1];
//         }

// Solution using O(1) space
        int[] res = new int[n];
        res[n-1] = 1;
        for(int i = 0; i < n-1; i ++){
            res[n-i-2] = res[n-i-1] * nums[n-i-1];
        }
        int prefix = 1;
        
        for(int i = 0; i < n; i ++){
            res[i] = res[i] * prefix;
            prefix *= nums[i];
        }
        return res;
    }
}