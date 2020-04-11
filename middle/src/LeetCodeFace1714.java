package src;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * 面试题 17.14. 最小K个数
 */
public class LeetCodeFace1714 {

    public  static int[] smallestK(int[] arr, int k) {

        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        for (int n : arr){
            pq.offer(n);
            if(pq.size()>k){
                pq.poll();
            }
        }
        int[] smallK=new int[k];
        int i=0;
        while (!pq.isEmpty()){
            smallK[i]=pq.poll();
            i++;
        }
        return smallK;
    }
    public static void main(String[] args) {
        int[] arr = {1,3,5,7,2,4,6,8};
        int k =4;
        for (int i : smallestK(arr, k)) {
            System.out.println(i);

        }
    }
}
