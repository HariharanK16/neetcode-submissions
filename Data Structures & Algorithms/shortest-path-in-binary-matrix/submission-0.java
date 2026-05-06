public class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int N = grid.length;
        int[] direct = {0, 1, 0, -1, 0, 1, 1, -1, -1, 1};

        if (grid[0][0] == 1 || grid[N - 1][N - 1] == 1)
            return -1;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        grid[0][0] = 1;

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0], c = cell[1];
            int dist = grid[r][c];

            if (r == N - 1 && c == N - 1)
                return dist;

            for (int d = 0; d < 9; d++) {
                int nr = r + direct[d], nc = c + direct[d + 1];

                if (nr >= 0 && nc >= 0 && nr < N && nc < N && grid[nr][nc] == 0) {
                    grid[nr][nc] = dist + 1;
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        return -1;
    }
}