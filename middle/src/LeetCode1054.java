package src;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 1054. 距离相等的条形码
 */
public class LeetCode1054 {
    public static int[] rearrangeBarcodes(int[] barcodes) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int b:barcodes){
            if(map.containsKey(b)){
                map.put(b,map.get(b)+1);
            }else {
                map.put(b,1);
            }
        }


        PriorityQueue<Map.Entry<Integer,Integer>> pq=
                new PriorityQueue<>((a,b)->
                        a.getValue().equals(b.getValue())?b.getKey()-a.getKey():
                        b.getValue()-a.getValue());
        // 构造堆
        for (Map.Entry e:map.entrySet()){
            pq.offer(e);
        }
        int[] reslut = new int[barcodes.length];
        int i=0;
        while (pq.size()>1){

            Map.Entry<Integer,Integer> e =pq.poll();
            Map.Entry<Integer,Integer> e1=pq.poll();
            reslut[i]=e.getKey();
            i++;
            reslut[i]=e1.getKey();
            int numE=e.getValue()-1;
            int numE1=e1.getValue()-1;
            if(numE>0){
                e.setValue(numE);
                pq.offer(e);
            }
            if(numE1>0){
                e1.setValue(numE1);
                pq.offer(e1);
            }
            i++;
        }
        if(pq.size()==1){
            reslut[i]=pq.poll().getKey();
        }
        return reslut;

    }

    public static void main(String[] args) {
        int[] barcdes={1,1,1,2,2,2};
        for (int i :rearrangeBarcodes(barcdes)){
            System.out.println(i);

        }
    }
}
