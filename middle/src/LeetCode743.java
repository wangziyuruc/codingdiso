package src;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 743. 网络延迟时间
 */
public class LeetCode743 {


    public static  int networkDelayTime(int[][] times, int N, int K) {
        int[][] graph = new int[N+1][N+1]; // 构造图
        // 初始化图 不访问-1的边
        for (int i=0;i<N+1;i++){
            for (int j =0;j<N+1;j++){
                graph[i][j]=-1;
            }
        }
        for (int[] edge:times){
            graph[edge[0]][edge[1]] = edge[2];
        }

        Queue<Integer> queue = new LinkedList<>(); // 通过队列实现层次遍历、】【p
        int[] visits = new int[N+1];// 标记被访问过的点
        Arrays.fill(visits,Integer.MAX_VALUE);
        visits[0]=0;
        int cost = 0;// 表示所有节点收到信号需要多长时间
        queue.add(K);
        visits[K]=0;

        while (!queue.isEmpty()){
            Integer node =queue.poll();

            for (int edge =1;edge<N+1;edge++){
                // 有向边防止循环访问
                if(graph[node][edge]!=-1&&
                        graph[node][edge]+visits[node]<visits[edge]){ // 表示边存在
                    visits[edge]=graph[node][edge]+visits[node];

                    queue.add(edge);// 将下一层节点添加到队列中

                }
            }
        }



        for (int i = 1; i < N+1; i++) {
            if (visits[i] == Integer.MAX_VALUE) return -1;
            cost = Math.max(cost, visits[i]);

        }
        return cost;



    }
    public static void main(String[] args) {
        int[][] times ={{2,1,1},{2,3,1},{3,4,1}};
        int N=4;
        int K=2;
        System.out.println(networkDelayTime(times,N,K));

    }
}
