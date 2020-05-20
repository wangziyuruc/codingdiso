package src;

import java.util.*;

/**
 * 909. 蛇梯棋
 */
public class LeetCode909 {
    public int snakesAndLadders(int[][] board) {
        int N = board.length;

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        Map<Integer,Integer> dist = new HashMap<>();
        dist.put(1,0);
        // bfs逐层遍历，碰到snake|| bridge  直接拉取到当前层
        while (!queue.isEmpty()){
            int s = queue.poll();
            if(s==N*N) return dist.get(s);
            // 步长 1,2,3,4,5,6
            for (int i = s+1;i<=Math.min(s+6,N*N);i++){
                int rc = get(i,N);
                int row = rc/N;
                int column =rc%N;
                int p = board[row][column] ==-1?i:board[row][column];
                if(!dist.containsKey(p)){
                    dist.put(p,dist.get(s)+1);
                    queue.add(p);
                }
            }
        }
        return -1;

    }

    /**
     *
     * 该问处理的重点
     * 行号每 N 个方格改变一次，所以只依赖于 quot = (s2-1) / N；同样列号依赖于 rem = (s2-1) % N。
     */
    public int get(int s, int N) {

        // Given a square num s, return board coordinates (r, c) as r*N + c
        int quot = (s - 1) / N;
        int rem = (s - 1) % N;
        int row = N - 1 - quot;
        int col = row % 2 != N % 2 ? rem : N - 1 - rem;

        return row * N + col;
    }


}
