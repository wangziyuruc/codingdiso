package src;

import java.util.Random;

/**
 *398. 随机数索引
 * 首先从最简单的例子出发：数据流只有一个数据。我们接收数据，发现数据流结束了，直接返回该数据，该数据返回的概率为1。
 *
 * 看来很简单，那么我们试试难一点的情况：假设数据流里有两个数据。我们读到了第一个数据，这次我们不能直接返回该数据，因为数据流没有结束。我们继续读取第二个数据，发现数据流结束了。因此我们只要保证以相同的概率返回第一个或者第二个数据就可以满足题目要求。因此我们生成一个0到1的随机数R,如果R小于0.5我们就返回第一个数据，如果R大于0.5，返回第二个数据。
 *
 * 接着我们继续分析有三个数据的数据流的情况。为了方便，我们按顺序给流中的数据命名为1、2、3。我们陆续收到了数据1、2和前面的例子一样，我们只能保存一个数据，所以必须淘汰1和2中的一个。应该如何淘汰呢？不妨和上面例子一样，我们按照二分之一的概率淘汰一个，例如我们淘汰了2。继续读取流中的数据3，发现数据流结束了，我们知道在长度为3的数据流中，如果返回数据3的概率为1/3,那么才有可能保证选择的正确性。也就是说，目前我们手里有1,3两个数据，我们通过一次随机选择，以1/3的概率留下数据3，以2/3的概率留下数据1。那么数据1被最终留下的概率是多少呢？
 *
 * 数据1被留下：（1/2）(2/3) = 1/3
 * 数据2被留下概率：（1/2）(2/3) = 1/3
 * 数据3被留下概率：1/3
 * 这个方法可以满足题目要求，所有数据被留下返回的概率一样！
 *
 * 因此，我们做一下推论：
 *
 * 假设当前正要读取第n个数据，则我们以1/n的概率留下该数据，否则留下前n-1个数据中的一个。
 * 以这种方法选择，所有数据流中数据被选择的概率一样。
 *
 * 作者：wangziyuruc-5n
 * 链接：https://leetcode-cn.com/problems/random-pick-index/solution/398-sui-ji-shu-suo-yin-by-wangziyuruc-5n/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class LeetCode398 {
    int[] nums;
    public LeetCode398(int[] nums) {
        this.nums=nums;
    }

    public int pick1(int target) {
        int index=0,start=0,finish=nums.length-1;
        for (int i=0;i<nums.length;i++){
            if (nums[start]!=target){
                start++;
            }
            if(nums[finish]!=target){
                finish--;
            }
        }
        index = new Random().nextInt(finish-start+1);
        return start+index;

    }

    public int pick(int target) {
        int index=0,n=0;
        for (int i=0;i<nums.length;i++){
            if(nums[i]==target){
                n++;
                if(new Random().nextInt()%n==0)
                    index=i;
            }
        }

        return index;

    }


    public static void main(String[] args) {
        int[] a = {1};
        LeetCode398 leetCode398=new LeetCode398(a);
        leetCode398.pick(1);
     }
}
