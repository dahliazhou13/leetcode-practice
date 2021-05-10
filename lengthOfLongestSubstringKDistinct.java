class lengthOfLongestSubstringKDistinct {
    // Given a string s and an integer k, return the length of the longest substring of s 
    // that contains at most k distinct characters.
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k==0) return 0;
        if(s == null || s.length() == 0) return 0;
        if(s.length() == 1) return 1;
        int max = 1;
        int start = 0;
        int end = 0;
        int distinct = 0;
        
        int[] seen = new int[256];
        while(start <= s.length()-1 && end <= s.length() -1){
            char endChar = s.charAt(end);
            
            if(seen[endChar]++ == 0) distinct ++;
            
            while(distinct > k && start < end){
                char startChar = s.charAt(start);
                
                if(--seen[startChar] == 0) distinct --;
                start ++;
                
                
                
            }
            
            max = Math.max(max, end-start+1);
            end ++;
        }
        
        return max;
    }
}
