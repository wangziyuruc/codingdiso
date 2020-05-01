package src;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 210. 课程表 II
 */
public class LeetCode210 {

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        // 构造图的逆序
        int[][] graph = new int[numCourses][numCourses];
        int[] inDegree = new int[numCourses];// 初始化入入度
        for (int[] edge : prerequisites){ // 初始化逆序图和入度表
            int x =edge[0];
            int y =edge[1];
            graph[y][x]=1;
            inDegree[x]++;
        }
        int[] reslut= new int[numCourses];
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i=0;i<numCourses;i++){
            if(inDegree[i]==0){
                queue.add(i);
            }
        }
        int i=0;
        while (!queue.isEmpty()){
            int e = queue.poll();
            reslut[i]=e;
            i++;
            for (int j=0;j<graph[e].length;j++){
                if(graph[e][j]==1){
                    inDegree[j]--;
                    if(inDegree[j]==0){
                        queue.add(j);
                    }
                }
            }
        }
        for (int d:inDegree){
            if (d>0){
                return new int[0];
            }
        }

        return reslut;

    }

    public static void main(String[] args) {
        int[][] prerequisites = {{0,1},{1,0}};
        System.out.println(findOrder(2, prerequisites));
    }

}
