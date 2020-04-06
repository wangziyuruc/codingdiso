package src;

import java.util.HashSet;

public class leetcode3 {
    public static int lengthOfLongestSubstring(String s) {
        char[] chars =s.toCharArray();
        // 记录当前滑动窗口内的字符类型
        HashSet<String> hashSet = new HashSet<>();
        int left=0,
                right=0,
                maxLength = 0;
        while (right<chars.length){
            // 增加窗口时判断存在重复类型 缩小窗口 left++
            if(hashSet.contains(String.valueOf(chars[right]))){
                while (hashSet.contains(String.valueOf(chars[right]))){
                    hashSet.remove(String.valueOf(chars[left]));
                    left++;

                }
            }
            // 增加窗口并添加该元素
            hashSet.add(String.valueOf(chars[right]));
            // 记录窗口最大值
            maxLength=Math.max(maxLength,right-left+1);

            right++;

        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }


}
