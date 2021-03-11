class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
       
        if(!wordList.contains(endWord)) return 0;
        Queue<String> set = new LinkedList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(String word : wordList){
            StringBuilder sb = new StringBuilder(word);
            for(int i = 0; i < word.length(); i ++){
             
                sb.setCharAt(i, '*');
                String key = sb.toString();
                sb = new StringBuilder(word);
                if(!map.containsKey(key)){
                    map.put(key, new ArrayList<String>());
                    map.get(key).add(word);
                }
                else{
                    map.get(key).add(word);
                }
            }
        }
        set.add(beginWord);
        int level = 1;
        while(!set.isEmpty()){
            int size = set.size();
            while(size != 0){
                String curr = set.poll();
                StringBuilder sb = new StringBuilder(curr);
                for(int i = 0; i < curr.length(); i ++){
                 
                    sb.setCharAt(i, '*');
                    String key = sb.toString();
                    sb = new StringBuilder(curr);
                    if(map.containsKey(key)){
                        List<String> next = map.get(key);
                        for(String pos : next){
                            if(pos.equals(curr)) continue;
                            if(pos.equals(endWord)) return ++level;
                            else set.offer(pos);
                        }
                        map.remove(key);
                }
                
            }
                size --;
                
            }
            level ++;
        }
        return 0;
    }
}