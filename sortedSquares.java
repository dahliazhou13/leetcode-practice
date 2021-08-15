class sortedSquares {
    /**
     * Given an integer array nums sorted in non-decreasing order, 
     * return an array of the squares of each number sorted in 
     * non-decreasing order.
     */

    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        
        int[] result = new int[n];
        for(int i = 0; i < n; i ++){
            if(Math.abs(nums[left]) > Math.abs(nums[right])){
                result[n-i-1] = nums[left] * nums[left];
                left ++;
            }
            else{
                result[n-i-1] = nums[right] * nums[right];
                right --;
            }
        }
        return result;
    }
    
}
