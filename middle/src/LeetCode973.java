package src;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 最接近原点的 K 个点
 */
public class LeetCode973 {
    public static int[][] kClosest(int[][] points, int K) {

        Map<Integer, Double> row=new HashMap<>();
        int[][] reslut = new int[K][2];

        for (int i=0;i<points.length;i++){
            int x =points[i][0];
            int y =points[i][1];
            row.put(i,Math.sqrt(x*x+y*y));
        }
        PriorityQueue<Map.Entry<Integer,Double>> pq =
                new PriorityQueue<>((a,b)->b.getValue().compareTo(a.getValue()));

        for (Map.Entry e:row.entrySet()){
            pq.offer(e);
            if(pq.size()>K){
                pq.poll();
            }
        }
        int i=0;
       while (!pq.isEmpty()){
           int rowX = pq.poll().getKey();
           reslut[i][0]=points[rowX][0];
           reslut[i][1]=points[rowX][1];
           i++;
       }

       return reslut;
    }

    public static void main(String[] args) {
        int[][] points ={{1,3},{-2,2}};
        kClosest(points,1);
    }
}
