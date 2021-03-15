
/**
 * Description: Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square 
brackets is being repeated exactly k times. Note that k is guaranteed to be a positive 
integer.

You may assume that the input string is always valid; No extra white spaces, square
 brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that
 digits are only for those repeat numbers, k. For example, there won't be input like 3a 
 or 2[4].
 */
class Solution {
    int i = 0;
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        while(i <s.length() && s.charAt(i) != ']'){
            if(!Character.isDigit(s.charAt(i))){
                sb.append(s.charAt(i++));
            }
            else{
                int val = 0;
            
                while(i < s.length() && Character.isDigit(s.charAt(i))) val = val * 10 + s.charAt(i++) - '0';
                i ++;
                String next = decodeString(s);
            
                i ++;
            
                for(int j = 0; j < val; j ++){
                    sb.append(next);
                }
            }
            
        }
        return new String(sb);
    }
}