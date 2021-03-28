public class subarraySum {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> previousSum = new HashMap<>();
        int prefix = 0;
        int count = 0;
        previousSum.put(0, 1);
        for(int i = 0; i < nums.length; i ++){
            prefix += nums[i];
            int complement = prefix  - k;
            if(previousSum.containsKey(complement)) count += previousSum.get(complement);
            previousSum.put(prefix, previousSum.getOrDefault(prefix,0)+1);
        }
        return count;
    }
}
