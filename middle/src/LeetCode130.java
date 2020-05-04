package src;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 130. 被围绕的区域
 */
public class LeetCode130 {


    public static void solve(char[][] board) {
        if(board.length==0){
            return;
        }

        Queue<int[]> queue = new ArrayDeque<>();
        // 寻找边界0 列
        for (int i = 0; i < board[0].length; i++) {
            // 第一行
            if (board[0][i] == 'O') {
                queue.add(new int[]{0, i});
                board[0][i] = 'A';
            }
            // 最后一行
            if (board[board.length - 1][i] == 'O') {
                queue.add(new int[]{board.length - 1, i});
                board[board.length - 1][i] = 'A';
            }

        }
        // 寻找边界0 行
        for (int i =0;i<board.length;i++){
            // 第一列
            if (board[i][0] == 'O') {
                queue.add(new int[]{i, 0});
                board[i][0] = 'A';
            }
            // 最后一列
            if (board[i][board[0].length - 1] == 'O') {
                queue.add(new int[]{i, board[0].length - 1});
                board[i][board[0].length - 1] = 'A';
            }
        }
        while (!queue.isEmpty()){
            int[] point = queue.poll();
            int x = point[0];
            int y = point[1];
            // 上
            if(x-1>=0&&board[x-1][y]=='O'){
                queue.add(new int[]{x-1,y});
                board[x-1][y] = 'A';
            }
            // 下
            if(x+1<board.length&&board[x+1][y]=='O'){
                queue.add(new int[]{x+1,y});
                board[x+1][y] = 'A';
            }
            // 左
            if(y-1>=0&&board[x][y-1]=='O'){
                queue.add(new int[]{x,y-1});
                board[x][y-1] = 'A';
            }
            // 右
            if(y+1<board[x].length&&board[x][y+1]=='O'){
                queue.add(new int[]{x,y+1});
                board[x][y+1] = 'A';
            }
        }

        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[i].length;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                if(board[i][j]=='A'){
                    board[i][j]='O';
                }
            }
        }

    }


    public static void main(String[] args) {
//        char[][] board = {{'X','X','X','X'},
//                {'X','O','O','X'},
//                {'X','X','O','X'},
//                {'X','O','X','X'}};
        char[][] board ={
                {'X','O','O','X','X','X','O','X','O','O'},
                {'X','O','X','X','X','X','X','X','X','X'},
                {'X','X','X','X','O','X','X','X','X','X'},
                {'X','O','X','X','X','O','X','X','X','O'},
                {'O','X','X','X','O','X','O','X','O','X'},
                {'X','X','O','X','X','O','O','X','X','X'},
                {'O','X','X','O','O','X','O','X','X','O'},
                {'O','X','X','X','X','X','O','X','X','X'},
                {'X','O','O','X','X','O','X','X','O','O'},
                {'X','X','X','O','O','X','O','X','X','O'}};
        solve(board);

        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[i].length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
}
