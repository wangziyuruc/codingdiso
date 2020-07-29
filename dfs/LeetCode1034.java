/**
 *
 */
public class LeetCode1034 {
    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        if(grid==null||grid.length ==0||grid[0].length==0) return grid;

        if(grid[r0][c0]==color) return grid;

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        dfs(grid,r0,c0,color,visited);
        return grid;

    }


    public void dfs(int[][] grid, int r, int c, int color,boolean [][] visited) {
        int pre = grid[r][c];
        if(r==0||c==0||r==grid.length-1||c==grid[0].length-1){
            grid[r][c]=color;
        }else {
            // 上 下 左 右
            if (grid[r-1][c] != pre && !visited[r-1][c]){ grid[r][c]=color;}
            if (grid[r+1][c] != pre && !visited[r+1][c]){ grid[r][c]=color;}
            if (grid[r][c-1] != pre && !visited[r][c-1]){ grid[r][c]=color;}
            if (grid[r][c+1] != pre && !visited[r][c+1]){ grid[r][c]=color;}
        }

        visited[r][c]=true;

        // 上下左右
        if(r-1>=0&& grid[r-1][c]==pre && !visited[r-1][c]){
            dfs(grid,r-1,c,color,visited);
        }
        if(r+1<grid.length&& grid[r+1][c]==pre && !visited[r+1][c]){
            dfs(grid,r+1,c,color,visited);
        }
        if(c-1>=0&& grid[r][c-1]==pre && !visited[r][c-1]){
            dfs(grid,r,c-1,color,visited);
        }
        if(c+1<grid[0].length&& grid[r][c+1]==pre && !visited[r][c+1]){
            dfs(grid,r,c+1,color,visited);
        }

    }
}
