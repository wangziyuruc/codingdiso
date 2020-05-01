package src;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 542. 01 矩阵
 */
public class LeetCode542 {

    public static int[][] updateMatrix(int[][] matrix) {

        for (int i =0;i<matrix.length;i++){
            for (int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]==0){
                    continue;
                }
                int minNum =Integer.MAX_VALUE;
                // 上
                if(i-1>=0){
                    if(matrix[i-1][j]==0){
                        minNum=1;
                    }else {
                        minNum=Math.min(minNum,matrix[i-1][j]+1);
                    }
                }
                // 下
                if(i+1<matrix.length){
                    if(matrix[i+1][j]==0){
                        minNum=1;
                    }else {
                        minNum=Math.min(minNum,matrix[i+1][j]+1);
                    }
                }
                // 左
                if(j-1>=0){
                    if(matrix[i][j-1]==0){
                        minNum=1;
                    }else {
                        minNum=Math.min(minNum,matrix[i][j-1]+1);
                    }
                }
                // 右
                if(j+1<matrix[i].length){
                    if(matrix[i][j+1]==0){
                        minNum=1;
                    }else {
                        minNum=Math.min(minNum,matrix[i][j+1]+1);
                    }
                }
                matrix[i][j]=minNum;
            }
        }
        return matrix;

    }


    public static int[][] updateMatrix1(int[][] matrix) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i =0;i<matrix.length;i++){
            for (int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]==0){
                    queue.add(new int[]{i,j});
                    visited[i][j]=true;

                }

            }
        }

        while (!queue.isEmpty()){
            int[] point = queue.poll();
            int x =point[0];
            int y =point[1];
            // 上
            if(x-1>=0&&!visited[x-1][y]){
                visited[x-1][y] = true;
                matrix[x-1][y]=matrix[x][y]+1;
                queue.add(new int[]{x-1,y});
            }
            // 下
            if(x+1<matrix.length&&!visited[x+1][y]){
                visited[x+1][y] = true;
                matrix[x+1][y]=matrix[x][y]+1;
                queue.add(new int[]{x+1,y});
            }
            // 左
            if(y-1>=0&&!visited[x][y-1]){
                visited[x][y-1] = true;
                matrix[x][y-1]=matrix[x][y]+1;
                queue.add(new int[]{x,y-1});
            }
            // 右
            if(y+1<matrix[x].length&&!visited[x][y+1]){
                visited[x][y+1] = true;
                matrix[x][y+1]=matrix[x][y]+1;
                queue.add(new int[]{x,y+1});
            }

        }
        return matrix;

    }

    public static void main(String[] args) {
//        int[][] matrix = {{0,0,0},{0,1,0},{0,0,0}};
//        int[][] matrix = {{0,0,0},{0,1,0},{1,1,1}};
//        int[][] matrix = {{0},{1}};
        int[][] matrix = {{1,0,1,1,0,0,1,0,0,1},{0,1,1,0,1,0,1,0,1,1},{0,0,1,0,1,0,0,1,0,0},{1,0,1,0,1,1,1,1,1,1},{0,1,0,1,1,0,0,0,0,1},{0,0,1,0,1,1,1,0,1,0},{0,1,0,1,0,1,0,0,1,1},{1,0,0,0,1,1,1,1,0,1},{1,1,1,1,1,1,1,0,1,0},{1,1,1,1,0,1,0,0,1,1}};
        for (int [] a : updateMatrix1(matrix)){
            for (int n:a){
                System.out.print(n+"  ");
            }
            System.out.println();
        }

    }



}
