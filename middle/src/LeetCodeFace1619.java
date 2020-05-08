package src;

import java.util.*;

/**
 * 面试题 16.19. 水域大小
 */
public class LeetCodeFace1619 {

    public static int[] pondSizes(int[][] land) {

        Queue<int[]> queue = new ArrayDeque<>();
        List<Integer> isLand = new ArrayList<>();
        // 计算连通图的个数
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                if(land[i][j]==0){
                    int isLandNum = 0;
                    queue.add(new int[]{i,j});
                    land[i][j]=-1;
                    while (!queue.isEmpty()){
                        int[] point = queue.poll();
                        int x = point[0];
                        int y = point[1];
                        // 上
                        if (x-1>=0&&land[x-1][y]==0){
                            queue.add(new int[]{x-1,y});
                            land[x-1][y]=-1;
                        }
                        // 下
                        if (x+1<land.length&&land[x+1][y]==0){
                            queue.add(new int[]{x+1,y});
                            land[x+1][y]=-1;
                        }
                        // 左
                        if (y-1>=0&&land[x][y-1]==0){
                            queue.add(new int[]{x,y-1});
                            land[x][y-1]=-1;
                        }
                        // 右
                        if (y+1<land[i].length&&land[x][y+1]==0){
                            queue.add(new int[]{x,y+1});
                            land[x][y+1]=-1;
                        }
                        // 左上
                        if (x-1>=0&&y-1>=0&&land[x-1][y-1]==0){
                            queue.add(new int[]{x-1,y-1});
                            land[x-1][y-1]=-1;
                        }
                        // 左下
                        if (x+1<land.length&&y-1>=0&&land[x+1][y-1]==0){
                            queue.add(new int[]{x+1,y-1});
                            land[x+1][y-1]=-1;
                        }
                        // 右上
                        if (x-1>=0&&y+1<land[i].length&&land[x-1][y+1]==0){
                            queue.add(new int[]{x-1,y+1});
                            land[x-1][y+1]=-1;
                        }
                        // 右下
                        if (x+1<land.length&&y+1<land[i].length&&land[x+1][y+1]==0){
                            queue.add(new int[]{x+1,y+1});
                            land[x+1][y+1]=-1;
                        }
                        isLandNum++;
                    }

                    isLand.add(isLandNum);

                }
            }
        }

        Collections.sort(isLand);
        int[] result = new int[isLand.size()];
        for (int i =0;i<isLand.size();i++){
            result[i]=isLand.get(i);
        }
        return result;

    }

    public static void main(String[] args) {
        int[][] land = {{0,2,1,0},
                {0,1,0,1},
                {1,1,0,1},
                {0,1,0,1}};
        for (int i : pondSizes(land)) {
            System.out.println(i);
        }
    }
}
