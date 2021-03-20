/**
 * Description: 
 * 
 * Given a robot cleaner in a room modeled as a grid.Each cell in the grid can be empty or 
 * blocked.
 * 
 * The robot cleaner with 4 given APIs can move forward, turn left or turn right. 
 * Each turn it made is 90 degrees.
 * When it tries to move into a blocked cell, its bumper sensor detects the obstacle and 
 * it stays on the current cell.
 * 
 * Design an algorithm to clean the entire room using only the 4 given APIs shown below.
 */

/*
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */



public class cleanRoom{
    int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    Set<Pair<Integer, Integer>> visited = new HashSet();
    Robot robot;

    public void goBack() {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }

    public void backtrack(int row, int col, int d) {
        visited.add(new Pair(row, col));
        robot.clean();
    // going clockwise : 0: 'up', 1: 'right', 2: 'down', 3: 'left'
        for (int i = 0; i < 4; ++i) {
            int newD = (d + i) % 4;
            int newRow = row + directions[newD][0];
            int newCol = col + directions[newD][1];

        if (!visited.contains(new Pair(newRow, newCol)) && robot.move()) {
            backtrack(newRow, newCol, newD);
            goBack();
        }
      // turn the robot following chosen direction : clockwise
        robot.turnRight();
    }
  }

    public void cleanRoom(Robot robot) {
        this.robot = robot;
        backtrack(0, 0, 0);
    }
}