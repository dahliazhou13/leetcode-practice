/**
 * You are given an array of variable pairs equations and an array of real numbers values, 
 * where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. 
 * Each Ai or Bi is a string that represents a single variable.
 * 
 * You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query 
 * where you must find the answer for Cj / Dj = ?.
 * Return the answers to all queries. If a single answer cannot be determined, return -1.0.
 */

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        double[] res = new double[queries.size()];
        for(int i =0; i < equations.size(); i ++){
            List<String> equation = equations.get(i);
            String divident = equation.get(0);
            String divider = equation.get(1);
            double value = values[i];
            if(!map.containsKey(divident)){
                map.put(divident,new HashMap<String,Double>());
            }
            if(!map.containsKey(divider)){
                map.put(divider,new HashMap<String,Double>());
            }
            map.get(divident).put(divider, value);
            map.get(divider).put(divident, 1/value);
        }
        
        int i = 0;
        for(List<String> query : queries){
            String start = query.get(0);
            String target = query.get(1);
          
            if(!map.containsKey(target)){
                res[i++] = -1;
                continue;
            }
            res[i] = dfs(start, target, map, new HashSet<String>());
            i ++;
            
        }
        return res;
    }
    
    private double dfs(String start, String target, Map<String, Map<String, Double>> map, Set<String> scanned){
        if(start.equals(target)) return 1;
        
        if(!map.containsKey(start)) return -1;
        
        scanned.add(start);
        for(String s : map.get(start).keySet()){
            if(!scanned.contains(s)){
                double val = map.get(start).get(s);
                double next = dfs(s, target, map, scanned);
                if(next != -1) return val*next;
            }
            

        }
        return -1;
    }
}