package src;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * 785. 判断二分图
 */
public class LeetCode785 {

    public static boolean bfs(int i, int[][] graph, boolean[] visited, int[] color) {
        // 1表示红色 0表示蓝色 -1表示未访问
        // 队列逐层访问
        Queue<Integer> queue = new ArrayDeque<>();
        visited[i] = true;
        queue.add(i);
        color[i] = 0;
        // 遍历nodecolor进行标记
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int node = queue.poll();
                for (int n : graph[node]) {
                    // 未访问过 添加到队列  访问过判断颜色是否差异
                    if (!visited[n]) {
                        visited[n]=true;
                        if (color[node]==0){
                            color[n]=1;
                        }
                        if (color[node]==1){
                            color[n]=0;
                        }
                        queue.add(n);
                    }else {
                        if(color[n]==color[node]){
                            return false;
                        }
                    }

                }
            }


        }
        return true;
    }

    public static boolean isBipartite(int[][] graph) {
        // 标记颜色
        int[] color = new int[graph.length];

        // 标记是否访问过
        boolean[] visited = new boolean[graph.length];
        // 图不连通  需要循环遍历每一个节点
        for (int i=0;i<graph.length;i++){

            if(!visited[i]){
                if(!bfs(i,graph,visited,color)){
                    return false;
                }
            }
        }

        return true;

    }


    public static void main(String[] args) {
        int[][] graph = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
        int[][] graph1 = {{1,2,3},{0,2},{0,1,3},{0,2}};
        System.out.println(isBipartite(graph1));
    }
}
