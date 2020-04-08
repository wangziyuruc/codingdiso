package src;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 滑动窗口中位数
 */
public class leetcode480 {
    public static double[] medianSlidingWindow(int[] nums, int k) {
        double[] result = new double[nums.length-k+1];
        ArrayList<Integer> arrayList = new ArrayList<>(k);
        int left=0,right=0;
        int num =0;
        while (right<nums.length){
            arrayList.add(nums[right]);

            if(right-left+1==k){
                // 计算当前数组的中位数字
                result[num]=median(arrayList,k);
                arrayList.remove(0);
                num++;
                left++;
            }

            right++;
        }
        return result;
    }

    public static double median(ArrayList<Integer> medianList,int k){
        ArrayList<Integer> arrayList = new ArrayList<>(medianList);
        Collections.sort(arrayList);
        if(k%2==0){
            double left = arrayList.get(k/2-1);
            double right = arrayList.get(k/2);
            return (left+right)/2;
        }else {
            return arrayList.get(k/2);
        }
    }

    public static void main(String[] args) {
        int[] a={1,3,-1,-3,5,3,6,7};
        int k = 3;
        double[] result = medianSlidingWindow(a,k);
        for (double r :result){
            System.out.println(r);
        }
    }
}
