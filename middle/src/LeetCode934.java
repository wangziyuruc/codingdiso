package src;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 934. 最短的桥
 */
public class LeetCode934 {
    public static int shortestBridge(int[][] A) {
        Queue<int[]> queue = new ArrayDeque<>();
        Queue<int[]> init = new ArrayDeque<>();

        for (int i = 0; i < A.length; i++) {
            if (!init.isEmpty()) {
                break;
            }
            for (int j = 0; j < A[i].length; j++) {
                if (A[i][j] == 1) {
                    init.add(new int[]{i, j});
                    A[i][j] = -1;
                    break;
                }

            }
        }
        while (!init.isEmpty()) {
            int[] p = init.poll();
            queue.add(p);
            int x = p[0];
            int y = p[1];
            // 上
            if (x - 1 >= 0 && A[x - 1][y] == 1) {
                init.add(new int[]{x - 1, y});
                A[x - 1][y] = -1;
            }
            // 下
            if (x + 1 < A.length && A[x + 1][y] == 1) {
                init.add(new int[]{x + 1, y});
                A[x + 1][y] = -1;
            }
            // 左
            if (y - 1 >= 0 && A[x][y - 1] == 1) {
                init.add(new int[]{x, y - 1});
                A[x][y - 1] = -1;
            }
            // 右
            if (y + 1 < A[x].length && A[x][y + 1] == 1) {
                init.add(new int[]{x, y + 1});
                A[x][y + 1] = -1;
            }
        }


        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] p = queue.poll();
                int x = p[0];
                int y = p[1];
                // 上
                if (x - 1 >= 0) {
                    if (A[x - 1][y] == 1) {
                        return result;
                    }
                    if (A[x - 1][y] == 0) {
                        queue.add(new int[]{x - 1, y});
                        A[x - 1][y] = -1;
                    }

                }
                // 下
                if (x + 1 < A.length) {
                    if (A[x + 1][y] == 1) {
                        return result;
                    }
                    if (A[x + 1][y] == 0) {
                        queue.add(new int[]{x + 1, y});
                        A[x + 1][y] = -1;
                    }

                }
                // 左
                if (y - 1 >= 0) {
                    if (A[x][y - 1] == 1) {
                        return result;
                    }
                    if (A[x][y - 1] == 0) {
                        queue.add(new int[]{x, y - 1});
                        A[x][y - 1] = -1;
                    }

                }
                // 右
                if (y + 1 < A[x].length) {
                    if (A[x][y + 1] == 1) {
                        return result;
                    }
                    if (A[x][y + 1] == 0) {
                        queue.add(new int[]{x, y + 1});
                        A[x][y + 1] = -1;
                    }
                }
            }
            result++;
        }

        return result;
    }

    public static void main(String[] args) {
//        int[][] A = {
//                {0,1},{1,0}
//        };
//        int[][] A = {
//                {0,1,0},{0,0,0},{0,0,1}
//        };
//        int[][] A = {{1, 1, 1, 1, 1}, {1, 0, 0, 0, 1}, {1, 0, 1, 0, 1}, {1, 0, 0, 0, 1}, {1, 1, 1, 1, 1}};
        int[][] A ={{0,1,0,0,0},{0,1,0,1,1},{0,0,0,0,1},{0,0,0,0,0},{0,0,0,0,0}} ;
        System.out.println(shortestBridge(A));
    }
}
