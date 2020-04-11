package src;

import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * 264. 丑数 II
 */
public class LeetCode264 {


    public static int nthUglyNumber(int n) {
        int[] nums =new int[1690];
        PriorityQueue<Long> pq=new PriorityQueue<>();
        HashSet<Long> set = new HashSet<>();
        set.add(1L);
        pq.offer(1L);
        int[] prime ={2,3,5};
        long curUgly;
        for (int i=0;i<1690;i++){
            curUgly=pq.poll();
            nums[i] =(int) curUgly;

            for (int p:prime){
                if(!set.contains(curUgly*p)){
                    pq.offer(curUgly*p);
                    set.add(curUgly*p);
                }
            }

        }

        return nums[n-1];
    }


    public static int nthUglyNumber1(int n) {
        if (n <= 0) {
            return 0;
        }
        int count = 0;
        int digital = 1;
        while (true) {
            if (isUgly(digital)) {
                count++;
            }


            if (count == n) {
                return digital;
            }
            digital++;

        }

    }

    public static boolean isUgly(int digital) {

        while (digital % 2 == 0) {
            digital /= 2;
        }
        while (digital % 3 == 0) {
            digital /= 3;
        }
        while (digital % 5 == 0) {
            digital /= 5;
        }

        return digital == 1 ? true : false;
    }

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(1352));
    }
}
