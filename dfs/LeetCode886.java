import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 886. 可能的二分法
 */
public class LeetCode886 {

    ArrayList<Integer>[] graph;
    Map<Integer,Integer> color;

    public boolean possibleBipartition(int N, int[][] dislikes) {
        graph = new ArrayList[N+1];
        for (int i = 0; i < N+1; i++) {
            graph[i] = new ArrayList<>();

        }
        for (int[] dislike : dislikes) {
            graph[dislike[0]].add(dislike[1]);
            graph[dislike[1]].add(dislike[0]);
        }
        color = new HashMap<>();
        for (int i = 0; i < N+1; i++) {
            if (!color.containsKey(i)&&!dfs(i,0)){
                return false;
            }

        }
        return true;
    }

    public boolean dfs(int node, int c){
        if (color.containsKey(node)){
            return color.get(node) == c;

        }
        color.put(node,c);
        for (Integer nei : graph[node]) {
            if (!dfs(nei,c^ 1)){
                return false;
            }
        }
        return true;
    }
}
