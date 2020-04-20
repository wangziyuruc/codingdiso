package src;

import java.util.Random;

/**
 * 382. 链表随机节点
 *1.如果接收的数据量小于m，则依次放入蓄水池。
 *2.当接收到第i个数据时，i >= m，在[0, i]范围内取以随机数d，
 * 若d的落在[0, m-1]范围内，则用接收到的第i个数据替换蓄水池中的第d个数据。
 *3.重复步骤2.
 * 算法的精妙之处在于：当处理完所有的数据时，蓄水池中的每个数据都是以m/N的概率获得的。
 *
 * 第i个接收到的数据最后能够留在蓄水池中的概率=
 * 第i个数据进入过蓄水池的概率*之后第i个数据不被替换的概率（第i+1到第N次处理数据都不会被替换）。
 * 1.当i<=m时，数据直接放进蓄水池，所以第i个数据进入过蓄水池的概率=1。
 * 2.i>m时，在[1,i]内选取随机数d，如果d<=m，
 * 则使用第i个数据替换蓄水池中第d个数据，因此第i个数据进入过蓄水池的概率=m/i。
 * 3.当i<=m时，程序从接收到第m+1个数据时开始执行替换操作，第m+1次处理会替换池中数据的为m/(m+1)，
 * 会替换掉第i个数据的概率为1/m，则第m+1次处理替换掉第i个数据的概率为(m/(m+1))*(1/m)=1/(m+1)，
 * 不被替换的概率为1-1/(m+1)=m/(m+1)。依次，第m+2次处理不替换掉第i个数据概率为(m+1)/(m+2)...
 * 第N次处理不替换掉第i个数据的概率为(N-1)/N。
 * 所以，之后第i个数据不被替换的概率=m/(m+1)*(m+1)/(m+2)*...*(N-1)/N=m/N。
 *4i>m时，程序从接收到第i+1个数据时开始有可能替换第i个数据。则参考上述第3点，之后第i个数据不被替换的概率=i/N。
 *5.结合第1点和第3点可知，当i<=m时，第i个接收到的数据最后留在蓄水池中的概率=1*m/N=m/N。
 * 结合第2点和第4点可知，当i>m时，第i个接收到的数据留在蓄水池中的概率=m/i*i/N=m/N。
 * 综上可知，每个数据最后被选中留在蓄水池中的概率为m/N。
 *
 */
public class LeetCode382 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private ListNode head;
    int[] reservor = new int[1];
    /**
     * @param head The linked list's head.
     *             Note that the head is guaranteed to be not null, so it contains at least one node.
     */
    public LeetCode382(ListNode head) {
        this.head=head;
    }

    /**
     * Returns a random node's value.
     */
    public int getRandom() {
        ListNode s = head;

        int i=0;
        // 蓄水池初始化
        while (s!=null&&i<reservor.length){
            reservor[i]=s.val;
            i++;
            s=s.next;
        }
        // 蓄水池算法
        while (s!=null){
            // 范围选择
            int d= new Random().nextInt(i+1);
            if(d<1){
                reservor[0]=s.val;
            }
            i++;
            s=s.next;
        }
        return reservor[0];





    }
}
