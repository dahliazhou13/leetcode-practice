// Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

// Follow-up: Could you solve the problem in linear time and in O(1) space?


public class majorityElement{
    public List<Integer> majorityElement(int[] nums) {
        int count1 = 0;
        int count2 = 0;
        
        Integer c1 = null;
        Integer c2 = null;
        for( int n : nums){
            if(c1 != null && c1 == n){
                count1 ++;
            }
            else if (c2 != null && c2 == n){
                count2 ++;
            }
            else if(count1 == 0){
                c1 = n;
                count1 ++;
            }
            else if(count2 == 0){
                c2 = n;
                count2 ++;
            }
            else{
                count1 --;
                count2 --;
            }
        }
        
        List result = new ArrayList<> ();

        count1 = 0;
        count2 = 0;

        for (int n: nums) {
            if (c1 != null && n == c1) count1++;
            if (c2 != null && n == c2) count2++;
        }

        int n = nums.length;
        if (count1 > n/3) result.add(c1);
        if (count2 > n/3) result.add(c2);

        return result;
    }
}