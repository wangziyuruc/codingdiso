package src;

/**
 * 爱生气的书店老板dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddhyuyyyyyyyyyyyyyyyyy
 */
public class leetcode1052 {
    public static int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int left = 0, right = 0,
                maxCustomers = 0, maxLeft = 0,curCustomers=0;
        // 窗口计算 期望最高的窗口
        while (right < customers.length) {
            // 窗口内生气的顾客价值
            if(grumpy[right]==1){
                curCustomers+=customers[right];
            }
            // 缩小窗口
            while (right - left+1 > X) {
                if(grumpy[left]==1){
                    curCustomers-=customers[left];
                }
                left++;
            }
            // 保存期望最大的窗口
            if(curCustomers>maxCustomers){
                maxCustomers=curCustomers;
                maxLeft=left;
            }
            right++;



        }
        int reslut = 0;
        for (int i = 0; i < customers.length; i++) {
            if (i >= maxLeft && i < maxLeft + X) {
                reslut += customers[i];
            } else {
                if (grumpy[i] == 0) {
                    reslut += customers[i];
                }
            }
        }

        return reslut;
    }

    public static void main(String[] args) {
        int[] customers = {7,8,8,6};
        int[] grumpy = {0,1,0,1};
        int X = 3;

        System.out.println(maxSatisfied(customers, grumpy, X));
    }
}
