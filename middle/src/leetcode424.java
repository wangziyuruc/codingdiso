package src;

/**
 * 替换后的最长重复字符
 */
public class leetcode424 {
    public static int characterReplacement(String s, int k) {
        char[] str = s.toCharArray();
        int[] charCount = new int[26];

        int left=0,
                right=0,
                maxCount=0,result=0;
        // 滑动窗口 解决数组和字符串子元素问题
        while (right<str.length){
            charCount[str[right]-'A']++;
            // 当前窗口的的重复字符最大数量
            maxCount  = Math.max(charCount[str[right]-'A'],maxCount);

            // 缩小当前窗口
            if(right-left+1-maxCount>k){
                // 窗口缩小,一出窗口的字符减1
                charCount[str[left]-'A']--;
                left++;
            }

            // 最长重复字符 等价 窗口滑动过程中的最大值
            result=Math.max(result,right-left+1);
            // 增加滑动窗口范围
            right++;
        }
        return result;
    }


    public static void main(String[] args) {
        String s = "AABABBA";

        System.out.println(characterReplacement(s,1  ));
    }


}
