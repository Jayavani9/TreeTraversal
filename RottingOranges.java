994. Rotting Oranges
    

You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.

Solution:
1. Using BFS
class Solution {
    int[][] dirs;
    int m;
    int n;
    public int orangesRotting(int[][] grid) {
        //Tc: O(m*n) Sc: O(min(m,n))
        if(grid == null || grid.length == 0) return 0;
        m = grid.length;
        n = grid[0].length;
        //L,R,U,D
        dirs = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        for(int i = 0 ; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(grid[i][j] == 2)
                {
                    q.add(new int[]{i,j});
                }
                else if(grid[i][j] == 1) fresh += 1;
            }
        }
        if(fresh == 0) return 0;
        int time = 0;
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i = 0 ; i < size; i++)
            {
                int[] cur = q.poll();
                for(int[] dir : dirs)
                {
                    int nr = cur[0] + dir[0];
                    int nc = cur[1] + dir[1];

                    if(nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        fresh--;
                        q.add(new int[]{nr,nc});
                    }
                }
            }
            time++;
        }
        if(fresh != 0) return -1;
        else return time-1;
    }
}
