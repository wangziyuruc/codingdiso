import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * 1466. 重新规划路线
 */
public class LeetCode1466 {
    HashSet<Integer> visit = new HashSet<>();
    int ans = 0;

    public int minReorder(int n, int[][] connections) {
        // 无向图
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        // 有向图
        HashMap<Integer,HashSet<Integer>> map2 = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(i,new ArrayList<>());
            map2.put(i,new HashSet<>());
        }
        // 初始化有向图 和 无向图
        for (int[] net : connections) {
            map.get(net[1]).add(net[0]);
            map.get(net[0]).add(net[1]);
            map2.get(net[0]).add(net[1]);
        }

        Reorder(0,map,map2);


        return ans;
    }


    public void Reorder(int cur, HashMap<Integer, List<Integer>> map,
                        HashMap<Integer,HashSet<Integer>> map2){
        visit.add(cur);
        for (Integer next : map.get(cur)) {
            if (!visit.contains(next)) {
                if (map2.get(cur).contains(next)){
                    ans++;
                }
                Reorder(next,map,map2);
            }

        }
    }
}
