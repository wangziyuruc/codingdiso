package src;

/**
 * 最长湍流子数组
 */
public class leetcode978 {

    public static int maxTurbulenceSize(int[] A) {
        // 处理特殊情况
        if (A.length == 1) {
            return 1;
        }
        // 双左指针
        int minLeft = 0,
                maxLeft = 0,
                right = 0,
                maxLength = 0;
        // 易错点做指针的移动
        while (right + 1 < A.length) {

            maxLength = Math.max(maxLength, right - minLeft+1);
            maxLength = Math.max(maxLength, right - maxLeft+1);

            if (right % 2 == 0) {
                // 偶数
                if (A[right] >= A[right + 1]) {
                    // 缩小窗口
                    minLeft = right+1;
                }
                if (A[right] <= A[right + 1]) {
                    maxLeft = right+1;
                }
            } else {
                // 奇数
                if (A[right] <= A[right + 1]) {
                    // 缩小窗口
                    minLeft = right+1;
                }
                if (A[right] >= A[right + 1]) {
                    maxLeft = right+1;
                }
            }

            right++;
        }
        // right遍历到数组尾部处理
        maxLength = Math.max(maxLength, right - minLeft+1);
        maxLength = Math.max(maxLength, right-maxLeft+1);


        return maxLength;
    }

    public static void main(String[] args) {

        int[] a = {0, 8, 45, 88, 48, 68, 28, 55, 17, 24};
        int[] b = {9, 4, 2, 10, 7, 8, 8, 1, 9};
        int[] c = {37,199,60,296,257,248,115,31,273,176}; //5
        int[] d = {9,9};
        int[] e = {0,1,1,0,1,0,1,1,0,0};

        System.out.println(maxTurbulenceSize(e));
    }
}
