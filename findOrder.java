/**
 * There are a total of n courses you have to take labelled from 0 to n - 1.

Some courses may have prerequisites, for example, if prerequisites[i] = [ai, bi] 
this means you must take the course bi before the course ai.

Given the total number of courses numCourses and a list of the prerequisite pairs, 
return the ordering of courses you should take to finish all courses.

If there are many valid answers, return any of them. If it is impossible to finish 
all courses, return an empty array.


 */

 //My solution uses topological sort. use dfs instead
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        int[] indeg = new int[numCourses];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int i = 0; i < prerequisites.length; i ++){
            int[] req = prerequisites[i];
            indeg[req[0]] ++;
            if(map.containsKey(req[1])){
                map.get(req[1]).add(req[0]);
            }
            else{
                map.put(req[1], new HashSet<Integer>());
                map.get(req[1]).add(req[0]);
            }
        }
        int[] order = new int[numCourses];
        int next = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < indeg.length; i ++){
            if(indeg[i] == 0) q.add(i);
        }
        while(!q.isEmpty()){
            int curr = q.poll();
            order[next] = curr;
            if(map.containsKey(curr)){
                Set<Integer> s = map.get(curr);
            
            
                for(int neigh : s){
                    indeg[neigh] --;
                    if(indeg[neigh] == 0) q.add(neigh);
                }
            }
            
            
            next ++;
        }
        if(next != numCourses) return new int[0];
        else return order;
    }
}