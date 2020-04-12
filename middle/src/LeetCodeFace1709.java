package src;

import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * 面试题 17.09. 第 k 个数
 */
public class LeetCodeFace1709 {
    public static int getKthMagicNumber(int k) {
        long[] primes ={3,5,7};
        PriorityQueue<Long> pq = new PriorityQueue<>();
        HashSet<Long> set = new HashSet<>();
        set.add(1L);
        pq.add(1L);
        long nums = 1;
        for (int i=0;i<k;i++){
            nums = pq.poll();
            for (long prime:primes){
                long tmp = prime*nums;
                if(!set.contains(tmp)){
                    set.add(tmp);
                    pq.add(tmp);
                }
            }
        }
        return (int) nums;
    }

    public static void main(String[] args) {
        System.out.println(getKthMagicNumber(5));
    }
}
