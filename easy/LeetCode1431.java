import java.util.ArrayList;
import java.util.List;

/**
 * 1431. 拥有最多糖果的孩子
 */
public class LeetCode1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandie = 0;
        for (int candy : candies) {
            if (candy > maxCandie) {
                maxCandie = candy;
            }
        }
        List<Boolean> res = new ArrayList<>();
        for (int candy : candies) {
            res.add(candy + extraCandies >= maxCandie);
        }
        return res;
    }
}
