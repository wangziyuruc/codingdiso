package src;

import java.util.*;

/**
 * 1129. 颜色交替的最短路径
 */
public class LeetCode1129must {


    public static int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        HashMap<Integer, List<Integer>> redEdge = new HashMap<>();

        HashMap<Integer, List<Integer>> blueEdge = new HashMap<>();
        // 图 初始化  避免在逻辑中做过多的null判断
        for (int i = 0; i < n; i++) {
            redEdge.computeIfAbsent(i, ArrayList::new);
            blueEdge.computeIfAbsent(i, ArrayList::new);
        }
        // 初始化红图
        for (int[] e : red_edges) {
            int start = e[0];
            int end = e[1];
            redEdge.get(start).add(end);
        }
        // 初始化化蓝图
        for (int[] e : blue_edges) {
            int start = e[0];
            int end = e[1];
            blueEdge.get(start).add(end);
        }

        int[] redDis = new int[n];
        int[] blueDis = new int[n];

        Arrays.fill(redDis, -1);
        Arrays.fill(blueDis, -1);
        Queue<Integer> redQueue = new ArrayDeque<>();
        Queue<Integer> blueQueue = new ArrayDeque<>();
        // 红-蓝开
        redQueue.add(0);
        redDis[0] = 0;

        // 蓝-红开
        blueQueue.add(0);
        blueDis[0] = 0;
        int row = 0;

        while (!redQueue.isEmpty() || !blueQueue.isEmpty()) {
            // 打野红开
            int redSize = redQueue.size();
            for (int i = 0; i < redSize; i++) {
                int v = redQueue.poll();
                // red
                if (row % 2 == 0) {
                    List<Integer> edgeLis = redEdge.get(v);
                    for (Integer e : edgeLis) {
                        // 下一层

                        if (redDis[e] == -1) {
                            redDis[e] = row + 1;
                            redQueue.add(e);
                        }
                    }

                } else {
                    // blue
                    List<Integer> edgeLis = blueEdge.get(v);

                    for (Integer e : edgeLis) {
                        // 下一层

                        if (redDis[e] == -1) {
                            redDis[e] = row + 1;
                            redQueue.add(e);
                        }
                    }
                }
            }
            // 打野蓝开
            int blueSize = blueQueue.size();
            for (int i = 0; i < blueSize; i++) {
                int v = blueQueue.poll();
                if (row % 2 == 0) {
                    // blue
                    List<Integer> edgeLis = blueEdge.get(v);
                    for (Integer e : edgeLis) {
                        // 下一层

                        if (blueDis[e] == -1) {
                            blueDis[e] = row + 1;
                            blueQueue.add(e);
                        }
                    }


                } else {
                    // red
                    List<Integer> edgeLis = redEdge.get(v);
                    for (Integer e : edgeLis) {
                        // 下一层

                        if (blueDis[e] == -1) {
                            blueDis[e] = row + 1;
                            blueQueue.add(e);
                        }
                    }
                }
            }


            row++;

        }
        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        for (int i = 0; i < n; i++) {
            if (redDis[i] >= 0 && blueDis[i] >= 0) {
                answer[i] = Math.min(redDis[i], blueDis[i]);
            } else if (redDis[i] >= 0) {
                answer[i] = redDis[i];
            } else {
                answer[i] = blueDis[i];
            }
        }

        return redDis;


    }


    public static int[] shortestAlternatingPaths1(int n, int[][] red_edges, int[][] blue_edges) {
        HashMap<Integer, List<Integer>> redEdge = new HashMap<>();

        HashMap<Integer, List<Integer>> blueEdge = new HashMap<>();
        // 图 初始化  避免在逻辑中做过多的null判断
        for (int i = 0; i < n; i++) {
            redEdge.computeIfAbsent(i, ArrayList::new);
            blueEdge.computeIfAbsent(i, ArrayList::new);
        }
        // 初始化红图
        for (int[] e : red_edges) {
            int start = e[0];
            int end = e[1];
            redEdge.get(start).add(end);
        }
        // 初始化化蓝图
        for (int[] e : blue_edges) {
            int start = e[0];
            int end = e[1];
            blueEdge.get(start).add(end);
        }
        // 重点 两个数组交替计算，并且需要理解 red {1,2} blue{1,2} 是红蓝两条边
        // 红-蓝开
        int[] redDis = new int[n];
        // 蓝-红开
        int[] blueDis = new int[n];

        Arrays.fill(redDis, -1);
        Arrays.fill(blueDis, -1);
        Queue<Integer> redQueue = new ArrayDeque<>();
        Queue<Integer> blueQueue = new ArrayDeque<>();

        redQueue.add(0);

        blueQueue.add(0);
        redDis[0] = 0;


        blueDis[0] = 0;
        int row = 0;

        while (!redQueue.isEmpty() || !blueQueue.isEmpty()) {

            Queue<Integer> newRed = new ArrayDeque<>();
            Queue<Integer> newBlue = new ArrayDeque<>();
            // 打野蓝开
            int redSize = redQueue.size();
            for (int i = 0; i < redSize; i++) {
                int v = redQueue.poll();
                // red
                List<Integer> edgeLis = blueEdge.get(v);
                for (Integer e : edgeLis) {
                    // 下一层  并更新蓝色边对应的顶点已经访问，
                    if (blueDis[e] == -1) {
                        blueDis[e] = row + 1;
                        newBlue.add(e);
                    }
                }

            }

            // 打野红开
            int blueSize = blueQueue.size();
            for (int i = 0; i < blueSize; i++) {
                int v = blueQueue.poll();

                List<Integer> edgeLis = redEdge.get(v);
                for (Integer e : edgeLis) {
                    // 下一层  并更新红色边对应的顶点已经访问，
                    if (redDis[e] == -1) {
                        redDis[e] = row + 1;
                        newRed.add(e);
                    }
                }

            }
            blueQueue = newBlue;
            redQueue = newRed;


            row++;
        }


        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        for (int i = 0; i < n; i++) {

            if (redDis[i] >= 0 && blueDis[i] >= 0) {
                answer[i] = Math.min(redDis[i], blueDis[i]);
            } else if (redDis[i] >= 0) {
                answer[i] = redDis[i];
            } else {
                answer[i] = blueDis[i];
            }
        }

        return answer;


    }

    public static void main(String[] args) {
//        int n = 5;
        int n = 3;
//        int n = 3;
//        int[][] red_edges = {{0, 1}, {1, 2}, {2, 3}, {3, 4}};
//        int[][] blue_edges = {{1, 2}, {2, 3}, {3, 1}};
        int[][] red_edges = {{0, 1}};
        int[][] blue_edges = {{1, 2}};
//        int[][] red_edges = {{0, 1}, {0, 2}};
//        int[][] blue_edges = {{1, 0}};
        for (int i : shortestAlternatingPaths1(n, red_edges, blue_edges)) {
            System.out.println(i);
        }
    }
}
