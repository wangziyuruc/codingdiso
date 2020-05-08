package src;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 417. 太平洋大西洋水流问题
 */
public class LeetCode417 {

    public static List<List<Integer>> pacificAtlantic(int[][] matrix) {

        // x=0||y==0 到达太平洋
        // x=matrix.length||y==matrix[i].length到达大西洋
        List<List<Integer>> reslut = new ArrayList<>();
        if(matrix==null){
            return reslut;
        }
        Queue<int[]> pOcean = new ArrayDeque<>();
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[i].length;j++){
                int[][] visit = new int[matrix.length][matrix[i].length];
                boolean isPOcean =false;
                boolean isAtlantic = false;
                // 是否临近太平洋
                pOcean.add(new int[]{i,j});
                visit[i][j]=1;

                while (!pOcean.isEmpty()){
                    int[] point  = pOcean.poll();
                    int x = point[0];
                    int y = point[1];
                    if(x==0||y==0){
                        isPOcean=true;


                    }
                    if(x==matrix.length-1||y==matrix[x].length-1){
                        isAtlantic=true;


                    }
                    // 上
                    if(x-1>=0&& matrix[x][y]>=matrix[x-1][y]&&visit[x-1][y]==0){
                        pOcean.add(new int[]{x-1,y});
                        visit[x-1][y]=1;
                    }
                    // 左
                    if(y-1>=0&&matrix[x][y]>=matrix[x][y-1]&& visit[x][y-1]==0){
                        pOcean.add(new int[]{x,y-1});
                        visit[x][y-1]=1;
                    }
                    // 下
                    if (x + 1 < matrix.length && matrix[x][y] >= matrix[x+1][y]&&visit[x+1][y]==0) {
                        pOcean.add(new int[]{x+1,y});
                        visit[x+1][y]=1;
                    }
                    // 右
                    if(y+1<matrix[x].length && matrix[x][y]>=matrix[x][y+1]&&visit[x][y+1]==0){
                        pOcean.add(new int[]{x,y+1});
                        visit[x][y+1]=1;
                    }
                }
//
                pOcean.clear();

                if(isAtlantic&&isPOcean){
                    ArrayList<Integer> r = new ArrayList<>();
                    r.add(i);
                    r.add(j);
                    reslut.add(r);
                }

            }
        }

        return reslut;

    }
    public static List<List<Integer>> pacificAtlantic1(int[][] matrix) {

        // x=0||y==0 到达太平洋
        // x=matrix.length||y==matrix[i].length到达大西洋
        List<List<Integer>> reslut = new ArrayList<>();
        if(matrix==null){
            return reslut;
        }
        int[][] visit = new int[matrix.length][matrix[0].length];

        Queue<int[]> pOcean = new ArrayDeque<>();
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[i].length;j++){
                boolean isPOcean =false;
                boolean isAtlantic = false;
                // 是否临近太平洋
                pOcean.add(new int[]{i,j});
                visit[i][j]=1;

                while (!pOcean.isEmpty()){
                    int[] point  = pOcean.poll();
                    int x = point[0];
                    int y = point[1];
                    if(x==0||y==0){
                        isPOcean=true;

                    }
                    if(x==matrix.length-1||y==matrix[x].length-1){
                        isAtlantic=true;


                    }
                    // 上
                    if(x-1>=0&& matrix[x][y]>=matrix[x-1][y]&&visit[x-1][y]==0){
                        pOcean.add(new int[]{x-1,y});
                        visit[x-1][y]=1;
                    }
                    // 左
                    if(y-1>=0&&matrix[x][y]>=matrix[x][y-1]&& visit[x][y-1]==0){
                        pOcean.add(new int[]{x,y-1});
                        visit[x][y-1]=1;
                    }
                    // 下
                    if (x + 1 < matrix.length && matrix[x][y] >= matrix[x+1][y]&&visit[x+1][y]==0) {
                        pOcean.add(new int[]{x+1,y});
                        visit[x+1][y]=1;
                    }
                    // 右
                    if(y+1<matrix[x].length && matrix[x][y]>=matrix[x][y+1]&&visit[x][y+1]==0){
                        pOcean.add(new int[]{x,y+1});
                        visit[x][y+1]=1;
                    }
                }
//
                pOcean.clear();


                if(isAtlantic&&isPOcean){
                    ArrayList<Integer> r = new ArrayList<>();
                    r.add(i);
                    r.add(j);
                    reslut.add(r);
                }else {
                    visit[i][j]=-1;
                }

            }
        }

        return reslut;

    }

    public static void main(String[] args) {
//        int[][] matrix = {
//                {1,2,2,3,5},
//                {3,2,3,4,4,},
//                {2,4,5,3,1},
//                {6,7,1,4,5},
//                {5,1,1,2,4}
//        };
        int[][] matrix = {
                {1,2,3},
                {8,9,4},
                {7,6,5}
        };
        for (List<Integer> list : pacificAtlantic1(matrix)) {
            for (Integer integer : list) {
                System.out.print(integer+" ");
            }
            System.out.println();
        }
    }
}
