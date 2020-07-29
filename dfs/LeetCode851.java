import java.util.ArrayList;
import java.util.Arrays;

/**
 * 851. 喧闹和富有
 */
public class LeetCode851 {


    ArrayList<Integer>[] graph;
    int[] answer;
    int[] quiet;

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int N = quiet.length;
        graph = new ArrayList[N];
        answer = new int[N];
        this.quiet = quiet;
        // 初始化节点
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] ints : richer) {
            graph[ints[1]].add(ints[0]);

        }
        Arrays.fill(answer,-1);
        for (int i = 0; i < N; i++) {

            dfs(i);
        }
        return answer;
    }


    public int dfs(int node){
        if(answer[node] == -1){
            answer[node] = node;
            for (Integer child : graph[node]) {
                int cand = dfs(child);
                if(quiet[cand]< quiet[answer[node]]){
                    answer[node] = cand;
                }

            }
        }
        return answer[node];
    }
}
