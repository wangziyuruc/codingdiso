package src;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * 659. 分割数组为连续子序列
 */
public class LeetCode659 {
    public  boolean isPossible(int[] nums) {
        //  nums中的数字进行 统计
       Counter counter = new Counter();
       // chain的尾部的下一个数字
       Counter tail = new Counter();

       // 初始化 统计值
       for (int n : nums){
           counter.add(n,1);
       }
       // 遍历所有的数字
       for (Integer num :nums){
           // 全部加入chain中
           if(counter.get(num) == 0){
               continue;
           }else if(tail.get(num)>0){
               // 增加之前的chain num添加进去
               tail.add(num,-1);
               tail.add(num+1,1);
           }else if(counter.get(num+1)>0 &&counter.get(num+2)>0){ // 链的长度3
               counter.add(num+1,-1);
               counter.add(num+2,-1);
               tail.add(num+3,1);
           }else {
               // 进过上述过程后依然存在统计值
               return false;
           }

           // 已经添加到链中  统计值-1
           counter.add(num,-1);

       }
        return true;

    }

    // 封装
    class  Counter extends HashMap<Integer, Integer> {
        public Integer get(Integer x){
            return containsKey(x)?super.get(x):0;
        }

        public void add(Integer k,Integer x){
            put(k,get(k)+x);
        }
    }


    public static void main(String[] args) {
        LeetCode659 leetCode659 = new LeetCode659();
        int[] a= {1,2,3,3,4,5};
        System.out.println(leetCode659.isPossible(a));
    }
}
