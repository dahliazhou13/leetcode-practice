// Given two binary strings a and b, return their sum as a binary string.
class addBinary {
    public String addBinary(String a, String b) {
        int p1 = a.length() -1;
        int p2 = b.length() - 1;
        int cin = 0;
        StringBuilder sb = new StringBuilder();
        while(p1 >= 0 && p2 >= 0){
            int n1 = a.charAt(p1) - '0';
            int n2 = b.charAt(p2) - '0';
            int total = n1 + n2 + cin;
            char out = (char)(total % 2 + '0');
            cin = (total)/2;
            sb.insert(0, out);
            p1 --;
            p2 --;
        }
        while(p1 >= 0){
            int n = a.charAt(p1) - '0';
            int total = n + cin;
            char out = (char)(total % 2 + '0');
            cin = total/2;
            sb.insert(0, out);
            p1--;
        }
        while(p2 >= 0){
            int n = b.charAt(p2) - '0';
            int total = n + cin;
            char out = (char)(total % 2 + '0');
            cin = total/2;
            sb.insert(0, out);
            p2 --;
        }
        if(cin == 1) sb.insert(0, '1');
        return sb.toString();
    }

}