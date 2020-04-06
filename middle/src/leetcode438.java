package src;

import java.util.ArrayList;
import java.util.List;

public class leetcode438 {
    public static List<Integer> findAnagrams(String s, String p) {
        if(s.length()<p.length()) return new ArrayList<>();
        int[] ints = new int[26];
        int[] intp = new int[26];
        char[] charsA = s.toCharArray();
        char[] charsB = p.toCharArray();
        for (int i=0;i<charsB.length;i++){
            intp[charsB[i]-'a']++;
        }
        List<Integer> index=new ArrayList<>();

        int left=0,right=0;
        // 滑动窗口
        while (right<s.length()){
            int curR = charsA[right]-'a';
            ints[curR]++;
            // 窗口内的某个字符超过p的某个字符，当前窗口不符合条件缩小
            while (ints[curR]>intp[curR]){
                ints[charsA[left]-'a']--;
                left++;
            }
            // 窗口和p长度一致，字母表中字符一致，添加left为index
            if(right-left+1==p.length()){
                index.add(left);
            }
            right++;
        }
        return index;
    }

    public static void main(String[] args) {
        List<Integer> index = findAnagrams("ababababab","aab");
        index.forEach(System.out::println);
    }
}
