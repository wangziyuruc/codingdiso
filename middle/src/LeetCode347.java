package src;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 347. 前 K 个高频元素
 */
public class LeetCode347 {


    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            int num = integerIntegerEntry.getKey();
            int count = integerIntegerEntry.getValue();
            if(queue.size() == k){
                if (queue.peek()[1]<count){
                    queue.poll();
                    queue.offer(new int[]{num,count});
                }

            }else {
                queue.add(new int[]{num,count});
            }
        }

        int[] res = new int[k];
        for (int i = 0; i <k ; i++) {
            res[i]=queue.poll()[0];
        }
        return res;

    }
}
