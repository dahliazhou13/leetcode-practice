// Description:
// On a 2D plane, we place n stones at some integer coordinate points. Each coordinate point 
// may have at most one stone.

// A stone can be removed if it shares either the same row or the same column as another stone 
// that has not been removed.

// Given an array stones of length n where stones[i] = [xi, yi] represents the location of the 
// ith stone, return the largest possible number of stones that can be removed.

public class removeStones {
    public int removeStones(int[][] stones) {

        boolean[] visited = new boolean[stones.length];

        int connected = 0;

        for (int i = 0; i < stones.length; i++) {

            if (!visited[i]) {
                connected++;
                helper(stones[i], stones, visited, i);
            }
        }

        return stones.length - connected;

    }

    void helper(int[] stone, int[][] stones, boolean[] visited, int index) {

        if (visited[index])
            return;
        visited[index] = true;
        for (int i = 0; i < stones.length; i++) {
            int[] temp = stones[i];
            if ((temp[0] == stone[0] || temp[1] == stone[1]) && !visited[i]) {

                helper(temp, stones, visited, i);
            }
        }

    }
}