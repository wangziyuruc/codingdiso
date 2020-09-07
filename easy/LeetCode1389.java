import java.util.ArrayList;
import java.util.List;

/**
 * 1389. 按既定顺序创建目标数组
 */
public class LeetCode1389 {


    public int[] createTargetArray(int[] nums, int[] index) {
        int length = nums.length;
        int[] target = new int[length];
        List<Integer> ta = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            ta.add(index[i],nums[i]);

        }
        for (int i = 0; i < length; i++) {
            target[i]=ta.get(i);

        }


        return target;

    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4};
        int[] index = {0,1,2,2,1};

    }
}
