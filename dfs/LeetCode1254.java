/**
 * 1254. 统计封闭岛屿的数目
 */
public class LeetCode1254 {

    public int closedIsland(int[][] grid) {
        int ans =0;
        for (int i = 0; i < grid.length; i++) {
            for (int i1 = 0; i1 < grid[i].length; i1++) {
                if(grid[i][i1]==0){
                    ans+=(dfs(grid,i,i1)?1:0);
                }
            }

        }
        return ans;

    }

    boolean dfs(int[][] grid , int x,int y){
        if(x>=grid.length || y>= grid[0].length || x<0||y<0){
            return false;
        }
        if(grid[x][y]!=0){
            return true;
        }
        grid[x][y]=2;
        boolean b1=dfs(grid,x+1,y);
        boolean b2=dfs(grid,x-1,y);
        boolean b3=dfs(grid,x,y+1);
        boolean b4=dfs(grid,x,y-1);
        return b1&&b2&&b3&&b4;
    }


}
