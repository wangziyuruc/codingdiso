package src;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 787. K 站中转内最便宜的航班
 */
public class LeetCode787 {

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][] graph = new int[n][n];// 初始化图 邻接矩阵
        for (int[] fight:flights){
            graph[fight[0]][fight[1]]=fight[2];
        }

        // 存储每个k层对应的place 的花费
        Map<Integer,Integer> kCostMap = new HashMap<>();


        //  int[] 该部分转化为对象 更易读  {cost,k,place} 单源点到改点的距离
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        // 源点入队
        pq.offer(new int[]{0,0,src});




        while (!pq.isEmpty()){
            int[] info=pq.poll();
            int cost =info[0],k=info[1],place=info[2];
            // 到达地点  返回当前花费
            if(place==dst){
                return cost;
            }

            // 如果队列中存在长度超过k 过滤掉，或者剪枝
            if(k>K || cost>kCostMap.getOrDefault(k*1000+place,Integer.MAX_VALUE)){
                continue;
            }



            for (int i=0;i<n;i++){
                // 边存在，遍历每个以info为起点的边
                if(graph[place][i]>0){
                    int newCost = cost+graph[place][i];
                    if(newCost<kCostMap.getOrDefault((k+1)*1000+i,Integer.MAX_VALUE)){
                        pq.offer(new int[]{newCost,k+1,i});
                        kCostMap.put((k+1)*1000+i,newCost);
                    }


                }
            }

        }


      return -1;
    }


    public static void main(String[] args) {
        int n=3;
        int[][] edges = {{0,1,100},{1,2,100},{0,2,500}};
        int src = 0,dst =2 ,k=0;
        System.out.println(findCheapestPrice(n,edges,src,dst,k));
    }
}
