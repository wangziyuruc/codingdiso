package src;

import java.util.*;

/**
 * 查找和最小的K对数字
 */
public class LeetCode373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<MinSum> pq = new PriorityQueue<>((o1, o2) -> o1.add()-o2.add());
        for (int i =0;i<nums1.length;i++){
            for (int j=0;j<nums2.length;j++){
                pq.offer(new MinSum(Arrays.asList(nums1[i], nums2[j])));
            }
        }

        List<List<Integer>> result= new ArrayList<>();

        while (k>0&&!pq.isEmpty()){
            result.add(pq.poll().list);
            k--;
        }
        return result;

    }
    static class MinSum {
        List<Integer> list;
        public MinSum(List<Integer> list) {
            this.list = list;
        }

        public int add(){
            return list.get(0)+list.get(1);
        }
    }


    public static void main(String[] args) {
        LeetCode373 leetCode373=new LeetCode373();
        int[] nums1={1,7,11};
        int[] nums2={2,4,6};
        int k =3;

        List<List<Integer>> result = leetCode373.kSmallestPairs(nums1,nums2,k);
        for (List<Integer> r :result){
            System.out.println(r.get(0)+" "+r.get(1));
        }

    }
}
