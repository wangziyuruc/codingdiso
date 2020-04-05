package src;

/**
 * https://www.zhihu.com/question/314669016
 */
public class leetcode1004 {

    public static int longestOnes(int[] A, int K) {
        int left = 0,
                right = 0,
                count = 0,
                reslut = 0;

        while (right < A.length) {
            if (A[right] == 0) {
                count++;
            }
            // 滑动窗口缩小，从左边
            while (count > K) {
                if (A[left] == 0) {
                    count--;
                }
                left++;
            }

            // 每次比较当前最长子串
            reslut = Math.max(reslut, right - left + 1);
            // 滑动窗口增加 右边
            right++;


        }

        return reslut;


    }

    public static void main(String[] args) {
        int[] a = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int K = 3;
        System.out.println(longestOnes(a,K));

    }
}
