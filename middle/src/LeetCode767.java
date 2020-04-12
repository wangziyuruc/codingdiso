package src;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 767. 重构字符串
 */
public class LeetCode767 {

    public static String reorganizeString(String S) {

        char[] chars = S.toCharArray();
        HashMap<String, Integer> charMap = new HashMap<>();
        for (char c : chars) {
            String str = String.valueOf(c);
            if (charMap.containsKey(str)) {
                charMap.put(str, charMap.get(str) + 1);
            } else {
                charMap.put(str, 1);
            }
        }
        PriorityQueue<Map.Entry<String,Integer>> pq = new PriorityQueue<>(
                (a,b)->a.getValue().equals(b.getValue())?b.getKey().compareTo(a.getKey()):
                        b.getValue()-a.getValue()
        );

        StringBuilder stringBuilder= new StringBuilder();
        String lastStr="";
        for (Map.Entry e:charMap.entrySet()){
            pq.offer(e);
        }

        while (!pq.isEmpty()){
            if(pq.size()==1){
                Map.Entry<String,Integer> entry = pq.poll();
                if(entry.getValue()>1 || lastStr.equals(entry.getKey())){
                    return "";
                }else {
                    stringBuilder.append(entry.getKey());
                    break;
                }
            }
            Map.Entry<String,Integer> entry = pq.poll();
            Map.Entry<String,Integer> entry2 = pq.poll();

            String s = entry.getKey();
            String s2 = entry2.getKey();
            if(!lastStr.equals(s)){
                stringBuilder.append(s);
                stringBuilder.append(s2);
                lastStr = s2;
                if(entry.getValue()-1>0){
                    entry.setValue(entry.getValue()-1);
                    pq.offer(entry);
                }
                if(entry2.getValue()-1>0){
                    entry2.setValue(entry2.getValue()-1);
                    pq.offer(entry2);
                }

            }else {
                return "";
            }
        }


        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String a= "bbbb";
        System.out.println(reorganizeString(a));
    }
}
