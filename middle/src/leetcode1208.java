package src;

/**
 * 尽可能使字符串相等
 */
public class leetcode1208 {
    public static int equalSubstring(String s, String t, int maxCost) {
        char[] charT = t.toCharArray();
        char[] charS = s.toCharArray();
        int left = 0,
                right = 0,
                maxLength = 0,
                curCost = 0;

        while (right < s.length()) {

            curCost += Math.abs(charT[right] - charS[right]);
            // 当前预算是否超过最大预算，如果超过缩小窗口
            while (curCost > maxCost) {
                curCost -= Math.abs(charT[left] - charS[left]);
                left++;
            }

            // 计算当前满足花费是的最长字符串
            maxLength = Math.max(maxLength, right - left + 1);

            // 滑动窗口 窗口增
            right++;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "abcd",
                t="acde";
        int cost = 0;
        System.out.println(equalSubstring(s,t,cost));
    }
}
