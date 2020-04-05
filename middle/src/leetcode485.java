package src;

public class leetcode485 {
    public static int findMaxConsecutiveOnes(int[] nums) {

        int max = 0;
        int num=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==0){
                num=0;
            }else {
                num++;
            }
            max=Math.max(num,max);
        }

        return max;

    }

    public static void main(String[] args) {
        int[] a= {1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(a));
    }
}
