class read {
    public int read(char[] buf, int n) {
        char[] buf4 = new char[4];
        
        int pointer = 0;//pointer and how many character read
        while(pointer < n){
            int num = read4(buf4); //store char in buf4 and also see how may numbers
            if(num == 0) break;
            for(int i = 0; i < num; i ++){
                if(pointer == n) return n;
                buf[pointer] = buf4[i];
                pointer ++;
            }
            
        }
        
        return pointer;
    }
}
