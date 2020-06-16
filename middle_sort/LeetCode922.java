/**
 *922. 按奇偶排序数组 II
 */
public class LeetCode922 {
    public int[] sortArrayByParityII(int[] A) {
        int oddIndex =1;
        int evenIndex = 0;
        int[] res = new int[A.length];
        for (int i : A) {
            if(i%2 ==0){
                res[evenIndex]=i;
                evenIndex=evenIndex+2;
            }else {
                res[oddIndex]=i;
                oddIndex=oddIndex+2;
            }
        }
        return res;

    }
}
