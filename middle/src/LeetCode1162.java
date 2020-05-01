package src;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 1162. 地图分析
 */
public class LeetCode1162 {

    public static int maxDistance(int[][] grid) {
        int[] dx = {0,0,-1,1};// 左右上下
        int[] dy = {-1,1,0,0};
        Queue<int[]> queue = new ArrayDeque<>();
        // 初始化队列
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1){
                    queue.add(new int[]{i,j});
                }
            }
        }

        int[] point = null;
        boolean hasOcean = false;
        while (!queue.isEmpty()){
             point = queue.poll();
            int x=point[0],y=point[1];
            for (int i=0;i<4;i++){
                int newX = x+dx[i],newY= y+dy[i];
                if(newX<0 || newY <0 || newX >= grid.length||newY>=grid.length
                || grid[newX][newY] !=0){
                    continue;
                }
                hasOcean = true;
                grid[newX][newY] = grid[x][y]+1;
                queue.add(new int[]{newX,newY});

            }
        }

        if(!hasOcean || point ==null){
            return -1;
        }
        return grid[point[0]][point[1]]-1;



    }

    public static void main(String[] args) {
        int[][] graph ={{1,0,1},{0,0,0},{1,0,1}};
        System.out.println(maxDistance(graph));
    }
}
