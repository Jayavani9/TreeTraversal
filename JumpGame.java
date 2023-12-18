55. Jump Game
You are given an integer array nums. You are initially positioned at the array's first index, 
and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.


Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.

class Solution {
    //Tc: O(N+M) Sc: O(N)
    public boolean canJump(int[] nums) {
        //BFS
        if(nums.length == 0 || nums == null) return false;
        int n = nums.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();

        q.add(0);
        visited[0] = true;

        while(!q.isEmpty())
        {
            int cur = q.poll();
            for(int i = 0; i <= nums[cur]; i++)
            {
                int next = cur + i;

                if(next == n-1) return true;

                if(next < n && !visited[next])
                {
                    q.add(next);
                    visited[next] = true;
                }
            }
        }
        return false;

    }
}
