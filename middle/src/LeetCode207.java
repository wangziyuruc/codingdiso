package src;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * 207. 课程表
 */
public class LeetCode207 {
    // 拓扑排序
    //

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] graph = new int[numCourses][numCourses];
        // kahn 拓扑排序
        int[] inDegree = new int[numCourses];// 初始化入度
        Arrays.fill(inDegree,0);
        for (int[] edge : prerequisites){
            int s = edge[0];
            int t = edge[1];
            graph[t][s] = 1;
            inDegree[s]++;
        }
        Queue<Integer> queue = new ArrayDeque<>(); // 寻找入度为0为起始点
        for (int i=0;i<inDegree.length;i++){
            if(inDegree[i]==0){
                queue.add(i);
            }
        }

        while (!queue.isEmpty()){
            int w = queue.poll();
            for (int i=0;i<graph[w].length;i++){
                if(graph[w][i]==1){
                    inDegree[i]--;
                    if(inDegree[i]==0){
                        queue.add(i);
                    }
                }
            }
        }
        for (int in :inDegree){
            if(in >0)
                return false;
        }



        return true;
    }

    public static void main(String[] args) {
        int[][] prerequisites = {{1,0},{0,1}};
        System.out.println(canFinish(2, prerequisites));
    }
}
