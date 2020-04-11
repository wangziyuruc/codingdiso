package src;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 378. 有序矩阵中第K小的元素
 */
public class LeetCode378 {

    public static int kthSmallest(int[][] matrix, int k) {
        List<Integer> sort=new ArrayList<>();
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[i].length;j++){
                sort.add(matrix[i][j]);
            }
        }

        sort.sort((a,b)->a.compareTo(b));
        return sort.get(k-1);
    }

    public static int kthSmallest2(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b.compareTo(a));
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[i].length;j++){
                pq.offer(matrix[i][j]);
                if(pq.size()>k){
                    pq.poll();
                }
            }
        }

        return pq.poll();
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};

        System.out.println(kthSmallest(matrix,8));
    }
}
