// Given two strings s and t, return true if they are both one edit distance apart, 
// otherwise return false.

// A string s is said to be one distance apart from a string t if you can:

// Insert exactly one character into s to get t.
// Delete exactly one character from s to get t.
// Replace exactly one character of s with a different character to get t.

class isOneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        if(s.equals(t)) return false;
        if((s.equals("") && t.length() == 1) || (t.equals("") && t.length() == 1)) return true;
        if(Math.abs(s.length() - t.length()) > 1) return false;
        int count = 0;
        int p = 0;
        
        while(p < s.length() && p < t.length() && s.charAt(p) == t.charAt(p)){p++;};
        if(p == s.length() || p == s.length()) return true;
        StringBuilder sb1 = new StringBuilder(s);
        StringBuilder sb2 = new StringBuilder(t);
        if(s.length() == t.length() ){
            sb1.replace(p, p+1, String.valueOf(t.charAt(p)));
        }
        else if(s.length() < t.length()){
            sb2.deleteCharAt(p);
        }
        else{
            sb1.deleteCharAt(p);
        }
        
        if(sb1.toString().equals(sb2.toString())) return true;
        return false;
    }
}
