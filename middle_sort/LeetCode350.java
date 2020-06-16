import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 350. 两个数组的交集 II
 */
public class LeetCode350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            return intersect(nums2,nums1);
        }

        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i : nums1) {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int k=0;
        for (int i : nums2) {
            int count = map.getOrDefault(i,0);
            if (count>0){
                nums1[k++]=i;
                map.put(i,count-1);
            }
        }

        return Arrays.copyOfRange(nums1,0,k);

    }
}
