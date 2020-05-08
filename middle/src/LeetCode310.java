package src;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * 310. 最小高度树
 */
public class LeetCode310 {

    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {

        List<Integer> reslut = new ArrayList<>();

        if(n==1){
            reslut.add(0);
            return reslut;
        }
        HashMap<Integer, List<Integer>> edgeMap = new HashMap<>();
        int[] inDegree = new int[n];
        for (int i = 0; i < n; i++) {
            edgeMap.put(i, new ArrayList<>());
        }
        // 构造边集合
        for (int[] e : edges) {
            int x = e[0];
            int y = e[1];
            edgeMap.get(x).add(y);
            edgeMap.get(y).add(x);
            inDegree[x]++;
            inDegree[y]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 1) {
                queue.add(i);
                inDegree[i]--;
            }
        }




        //  以每个点做树的根 进行bfs 计算树的高度
        while (!queue.isEmpty()) {
            reslut = new ArrayList<>();
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int v = queue.poll();
                reslut.add(v);
                List<Integer> edgeList = edgeMap.get(v);
                for (Integer e : edgeList) {
                    inDegree[e]--;
                    if (inDegree[e] == 1) {
                        queue.add(e);

                    }
                }
            }
        }


        return reslut;

    }


    public static void main(String[] args) {
//        int n = 4;
//        int[][] edges = {
//                {1, 0},
//                {1, 2},
//                {1, 3}
//        };
        int n = 6;
        int[][] edges = {
                {0, 3},
                {1, 3},
                {2, 3},
                {4, 3},
                {5, 4}
        };
        findMinHeightTrees(n, edges).forEach(System.out::println);
    }
}
