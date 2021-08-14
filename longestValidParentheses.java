class longestValidParentheses {
/**
 * Given a string containing just the characters '(' and ')', 
 * find the length of the longestvalid (well-formed) parentheses 
 * substring.
 */
    /**Stack Solution 
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            
            if(c == '(') stack.push(i);
            else{
                stack.pop();
                
                if(stack.isEmpty()){
                    stack.push(i);
                }
                else{
                    max = Math.max(max, i - stack.peek());
                }
            }
            
        }
        
        return max;
    }
    */

    /** DP */

    public int longestValidParentheses(String s) {
        
        if(s == null || s.length() == 0) return 0;
        int[] dp = new int[s.length()];
        int max = 0;
        dp[0] = 0;
        
        for(int i = 1; i < s.length() ; i ++){
            if(s.charAt(i) == ')'){
                if(s.charAt(i-1) == '('){
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                }
                else if(i - dp[i-1] > 0 && s.charAt(i-dp[i-1] - 1) == '('){
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                max = Math.max(max, dp[i]);
            }
            
            
        }
        return max;
    }
}
