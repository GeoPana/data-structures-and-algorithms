package dsatutorial.codinginterviwqestions;

/*
-------------------- Number of Islands - LeetCode #200 ----------------------
Given an m x n 2D binary grid which represents a map of '1's (land)
and '0's (water), return the number of islands.
An island is surrounded by water and is formed by connecting adjacent
lands horizontally or vertically.
You may assume all four edges of the grid are all surrounded by water.
-----------------------------------------------------------------------------
 */

public class NumberOfIslands {

    public static int numberOfIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int numberOfIslands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    dfs(grid, i, j, visited);
                    numberOfIslands++;
                }
            }
        }
        return numberOfIslands;
    }

    public static void dfs(char[][] grid, int row, int column, boolean[][] visited) {
        if (row < 0 || column < 0
                || row >= grid.length || column >= grid[0].length
                || visited[row][column] || grid[row][column] == '0') {
            return;
        }
        visited[row][column] = true;
        dfs(grid, row - 1, column, visited); // up
        dfs(grid, row, column + 1, visited); // right
        dfs(grid, row + 1, column, visited); // down
        dfs(grid, row, column - 1, visited); // left
    }

    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '0', '0'},
                         {'1', '0', '0', '0'},
                         {'0', '0', '1', '0'},
                         {'0', '0', '0', '1'}
                        };
        System.out.println("Number Of Islands: " + numberOfIslands(grid));
    }
}
