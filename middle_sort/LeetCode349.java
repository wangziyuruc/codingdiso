import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 349. 两个数组的交集
 */
public class LeetCode349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            set2.add(i);
        }
        int[] res = null;
        int index = 0;
        if (set1.size()>set2.size()){
            res= new int[set2.size()];

            for (Integer integer : set2) {
                if(set1.contains(integer)){
                    res[index++]=integer;

                }

            }
            return Arrays.copyOf(res,index);
        }else {
            res= new int[set1.size()];

            for (Integer integer : set1) {
                if(set2.contains(integer)){
                    res[index++]=integer;

                }

            }
            return Arrays.copyOf(res,index);
        }

    }
}
