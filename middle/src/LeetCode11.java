package src;

/**
 * 11. 盛最多水的容器
 */
public class LeetCode11 {
    public static int maxArea(int[] height) {
        int left=0,right = height.length-1;
        // 面积计算 木桶原理中面积大小决定于高度最矮的
        int result =Math.min(height[left],height[right])*(right-left);
        while (left<right){
            result=Math.max(Math.min(height[left],height[right])*(right-left),result);
            // 指针移动
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }


}
