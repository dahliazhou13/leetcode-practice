/**
 * Description: Given an m x n integers matrix, return the length of 
 * the longest increasing path in matrix.
 * From each cell, you can either move in four directions: left, right, up, or down. 
 * You may not move diagonally or move outside the boundary (i.e., wrap-around is not 
 * allowed).
 */

class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        //Set<String> set = new HashSet<>();
        int length = 0;
        int[][] memo = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i ++){
            for(int j = 0; j < matrix[0].length; j ++){
                int max = search(matrix,i,j, memo );
               
                length = Math.max(length, max);
            }
        }
        return length;
    }
    private int search(int[][] matrix,  int r, int c, int[][] memo){
        if(memo[r][c]!= 0) return memo[r][c];
        int val = matrix[r][c];
        //set.add(r+","+c);
        
        
        if(valid(r-1, c, matrix, val)  ){
            memo[r][c] = Math.max(memo[r][c],search(matrix, r-1, c,memo));
        }
        if(valid(r+1, c, matrix, val)){
            memo[r][c] = Math.max(memo[r][c],search(matrix, r+1, c,memo));
        }
        if(valid(r, c-1, matrix, val)){
            memo[r][c] = Math.max(memo[r][c],search(matrix, r, c-1, memo));
        }
        if(valid(r,c+1,matrix, val)){
            memo[r][c] = Math.max(memo[r][c],search(matrix, r, c+1, memo));
        }
        //set.remove(r+","+c);
        return ++memo[r][c];
    }
    
    
    
    private boolean valid(int r, int c, int[][] matrix, int prev){
        return (r >= 0) && (r <= matrix.length - 1) && (c >= 0) && (c <= matrix[0].length - 1) && (matrix[r][c] > prev);
    }
}