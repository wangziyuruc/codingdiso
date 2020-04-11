package src;

import java.util.*;

/**
 * 313. 超级丑数
 */
public class leetCode313 {
    public int nthSuperUglyNumber2(int n, int[] primes) {
        HashSet<Integer> set = new HashSet<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<Integer> reslut = new ArrayList<>();
        pq.offer(1);
        set.add(1);
        while (true) {
            Integer num = pq.poll();
            reslut.add(num);
            if (reslut.size() == n) {
                break;
            }
            for (int p : primes) {
                int tmp = p * num;
                if (!set.contains(tmp)) {
                    set.add(tmp);
                    pq.offer(tmp);
                }
            }
        }
        return reslut.get(reslut.size() - 1);
    }

    public static int nthSuperUglyNumber1(int n, int[] primes) {
        HashSet<Integer> set = new HashSet<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.offer(1);
        set.add(1);

        Integer reslut = null;
        while (n > 0) {
            Integer num = pq.poll();
            reslut = num;

            for (int p : primes) {
                int tmp = p * num;
                if (!set.contains(tmp)) {
                    set.add(tmp);
                    pq.offer(tmp);
                }
            }
            n--;
        }
        return reslut.intValue();

    }

    public static int nthSuperUglyNumber(int n, int[] primes) {
        int[] nums = new int[n];

        nums[0] = 1;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int prime : primes) {
            map.put(prime, 0);

        }
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            // 获取当前最小的值
            for (int j = 0; j < map.size(); j++) {
                int prime = primes[j];
                int tmp = nums[map.get(prime)] * prime;
                if (min > tmp) {
                    min = tmp;
                }
            }
            // 更新各个质因子的指针的偏移，该出注意不要定向指针更新 因为存在重复值
            for (Map.Entry<Integer, Integer> e : map.entrySet()) {
                int tmp = nums[e.getValue()] * e.getKey();
                if (tmp == min) {
                    e.setValue(e.getValue() + 1);
                }
            }

            nums[i] = min;

        }
        return nums[nums.length - 1];

    }

    public static void main(String[] args) {
        int[] primes = {2, 7, 13, 19};
        int[] primes2 = {3, 5, 7, 11, 19, 23, 29, 41, 43, 47};
        int n = 12;
        int n2 = 15;
        System.out.println(nthSuperUglyNumber(n2, primes2));
    }

}