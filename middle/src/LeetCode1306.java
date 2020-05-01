package src;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * 1306. 跳跃游戏 III
 */
public class LeetCode1306 {

    public static boolean canReach(int[] arr, int start) {


        // 将arr 初始化图
        int graphLength = arr.length;
        Set<Integer> target =new HashSet<Integer>();
        for (int i=0;i<graphLength;i++){
            if(arr[i]==0){
                target.add(i);
            }
            int x =i;

        }

        boolean[] visited = new boolean[graphLength];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start]=true;
        while (!queue.isEmpty()){
            int v = queue.poll();
            if (target.contains(v)){
                return true;
            }
            int y1 = v+arr[v];
            int y2 = v-arr[v];
            if(y1<graphLength&&!visited[y1]){
                queue.add(y1);
                visited[y1]=true;
            }
            if(y2>=0&&!visited[y2]){
                queue.add(y2);
                visited[y2]=true;
            }

        }


        return false;
    }




    public static void main(String[] args) {
//        int[] arr = {4,2,3,0,3,1,2};
//        int[] arr = {3,0,2,1,2};
        int[] arr = {0,0};
//        int[] arr = {1,0,2,0};
        System.out.println(canReach(arr, 0));
    }
}
