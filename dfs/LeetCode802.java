import java.util.ArrayList;
import java.util.List;

/**
 * 802. 找到最终的安全状态
 */
public class LeetCode802 {


    public List<Integer> eventualSafeNodes(int[][] graph) {
        int N = graph.length;
        int[] color = new int[N];
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if(dfs(i,color,graph)){
                ans.add(i);
            }
        }
        return ans;

    }


    public boolean dfs(int node,int[] color,int[][] graph){
        if(color[node]>0){
            return color[node]==2;
        }
        color[node]=1;

        for (int n : graph[node]) {
            if (color[node]==2){
                continue;
            }
            if (color[n]==1||!dfs(n,color,graph)){
                return false;
            }
        }
        color[node]=2;
        return true;
    }

}
