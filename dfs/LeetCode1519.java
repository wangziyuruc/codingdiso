import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1519. 子树中标签相同的节点数
 */
public class LeetCode1519 {


    public int[] countSubTrees(int n, int[][] edges, String labels) {
        Map<Integer,List<Integer>> edgesMap = new HashMap<>();
        for (int[] edge : edges) {
            int node = edge[0],node1 = edge[1];
            List<Integer> list = edgesMap.getOrDefault(node,new ArrayList<>());
            List<Integer> list1 = edgesMap.getOrDefault(node1,new ArrayList<>());
            list.add(node1);
            list1.add(node);
            edgesMap.put(node,list);
            edgesMap.put(node1,list1);

        }
        int[] counts = new int[n];
        boolean[] visited = new boolean[n];
        dfs(0,counts,visited,edgesMap,labels);
        return counts;

    }

    public int[] dfs(int node, int[] counts, boolean[] visted,
                     Map<Integer, List<Integer>> edgesMap,String labels){
        visted[node] = true;
        int[] curCunts = new int[26];
        curCunts[labels.charAt(node)-'a']++;
        List<Integer> nodeList = edgesMap.get(node);
        for (Integer nextNode : nodeList) {
            if (!visted[nextNode]){
                int[] childCounts = dfs(nextNode,counts,
                        visted,edgesMap,labels);
                for (int i = 0;i<26;i++){
                    curCunts[i] += childCounts[i];
                }
            }

        }
        counts[node] = curCunts[labels.charAt(node)-'a'];
        return curCunts;
    }
}
