1992. Find All Groups of Farmland

You are given a 0-indexed m x n binary matrix land where a 0 represents a hectare of forested land and a 1 represents a hectare of farmland.

To keep the land organized, there are designated rectangular areas of hectares that consist entirely of farmland. 
  
These rectangular areas are called groups. No two groups are adjacent, meaning farmland in one group is not four-directionally adjacent to another farmland in a different group.

land can be represented by a coordinate system where the top left corner of land is (0, 0) and the bottom right corner of land is (m-1, n-1). 
  
  Find the coordinates of the top left and bottom right corner of each group of farmland. 
  
  A group of farmland with a top left corner at (r1, c1) and a bottom right corner at (r2, c2) is represented by the 4-length array [r1, c1, r2, c2].

Return a 2D array containing the 4-length arrays described above for each group of farmland in land. 
  
  If there are no groups of farmland, return an empty array. You may return the answer in any order.

 


  //Using BFS 

  class Solution {
    public int[][] findFarmland(int[][] land) {
         int m = land.length;
        int n = land[0].length;
        boolean[][] visited = new boolean[m][n];
        List<int[]> ans = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                    int[] last = BFS(q, land, visited);

               
                    int[] arr = new int[]{i, j, last[0], last[1]};
                    ans.add(arr);
                }
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }

    private int[] BFS(Queue<int[]> q, int[][] land, boolean[][] visited) {
        int m = land.length;
        int n = land[0].length;
        int[] last = new int[2];


        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!q.isEmpty()) {
            int[] current = q.poll();
            last = current; 

            for (int[] dir : directions) {
                int x = current[0] + dir[0];
                int y = current[1] + dir[1];

              
                if (x >= 0 && x < m && y >= 0 && y < n && land[x][y] == 1 && !visited[x][y]) {
                    visited[x][y] = true;
                    q.add(new int[]{x, y});
                }
            }
        }

        return last; 
    }
}