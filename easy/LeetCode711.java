import java.util.HashMap;
import java.util.Map;

/**
 * 771. 宝石与石头
 */
public class LeetCode711 {


    public int numJewelsInStones(String J, String S) {
        char[] chars = S.toCharArray();
        Map<Character, Integer> res = new HashMap<>();
        for (char aChar : chars) {
            res.put(aChar,res.getOrDefault(aChar,0)+1);
        }
        int sum = 0;
        for (char c : J.toCharArray()) {
            sum += res.getOrDefault(c,0);
        }

        return sum;

    }
}
