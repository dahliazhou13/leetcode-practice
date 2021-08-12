class validPalindrome{
    // Given a string s, return true if the s can be palindrome after deleting at most one character from it.x
    public boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while(l < r){
            char lc = s.charAt(l);
            char rc = s.charAt(r);
            if(lc != rc){
                int len = r - l;
                if(isPal(s.substring(l, l + len)) || isPal(s.substring(l+1, l + len+1 ))) return true;
                else return false;
            }
            l++;
            r--;
        }
        return true;
    }
    
    private boolean isPal(String s){
        int l = 0;
        int r = s.length() - 1;
        while(l < r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}