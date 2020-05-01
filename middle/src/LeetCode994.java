package src;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 994. 腐烂的橘子
 */
public class LeetCode994 {


    public static int orangesRotting(int[][] grid) {

        Queue<int[]> queue = new ArrayDeque<>();
        int min =0;

        // 初始化队列 附一个腐烂的苹果
        for (int i =0;i<grid.length;i++){
            for (int j=0;j<grid[i].length;j++){
                if(grid[i][j]==2){
                    queue.add(new int[]{i,j});

                }
            }
        }



        while (!queue.isEmpty()){

            int length = queue.size();
            // 逐层扩展
            for (int i=0;i<length;i++){
                int[] point = queue.poll();
                int x = point[0];
                int y = point[1];
                // 上
                if(x-1>=0&&grid[x-1][y]==1){
                    queue.add(new int[]{x-1,y});
                    grid[x-1][y]=2;
                }
                // 下
                if(x+1<grid.length&&grid[x+1][y]==1){
                    queue.add(new int[]{x+1,y});
                    grid[x+1][y]=2;
                }
                // 左
                if(y-1>=0&&grid[x][y-1]==1){
                    queue.add(new int[]{x,y-1});
                    grid[x][y-1]=2;
                }
                // 右
                if(y+1<grid[x].length&&grid[x][y+1]==1){
                    queue.add(new int[]{x,y+1});
                    grid[x][y+1]=2;
                }

            }
            min++;
        }

        // 初始化队列 附一个腐烂的苹果
        for (int i =0;i<grid.length;i++){
            for (int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        return min-1<0?0:min-1;
    }

    public static void main(String[] args) {
        int[][] grid ={{2,1,1},{1,1,0},{0,1,1}};
        int[][] grid1 ={{0,2}};
        int[][] grid2 ={{1,2}};
        System.out.println(orangesRotting(grid1));
    }
}
