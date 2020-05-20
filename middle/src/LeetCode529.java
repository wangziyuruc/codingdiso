package src;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 529. 扫雷游戏
 */
public class LeetCode529 {


    public static char[][] updateBoard(char[][] board, int[] click) {
        int m = click[0];
        int n = click[1];
        if (board[m][n] == 'M') {
            board[m][n] = 'X';
            return board;
        }
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{m, n});
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] p = queue.poll();
                int x = p[0];
                int y = p[1];
                int thunderNum =0;

                // 上
                if(x-1>=0){
                    if(board[x-1][y]=='M'){
                        thunderNum++;
                    }
                }
                // 下
                if(x+1<board.length){
                    if(board[x+1][y]=='M'){
                        thunderNum++;
                    }
                }
                // 左
                if(y-1>=0){
                    if(board[x][y-1]=='M'){
                        thunderNum++;
                    }
                }
                // 右
                if(y+1<board[x].length){
                    if(board[x][y+1]=='M'){
                        thunderNum++;
                    }
                }
                // 左上
                if(x-1>=0&&y-1>=0){
                    if(board[x-1][y-1]=='M'){
                        thunderNum++;
                    }
                }
                // 右上
                if(x-1>=0&&y+1<board[x].length){
                    if(board[x-1][y+1]=='M' ){
                        thunderNum++;
                    }
                }
                // 左下
                if(x+1<board.length&&y-1>=0){
                    if(board[x+1][y-1]=='M' ){
                        thunderNum++;
                    }
                }
                // 右下
                if(x+1<board.length&&y+1<board[x].length){
                    if(board[x+1][y+1]=='M' ){
                        thunderNum++;
                    }
                }

                if(thunderNum>0){
                    board[x][y]= (char) (thunderNum+'0');
                    continue;
                }else {
                    board[x][y]='B';
                }
                // 上
                if(x-1>=0){
                    if(board[x-1][y]=='E'){
                        queue.add(new int[]{x-1,y});
                        board[x-1][y]='B';
                    }
                }
                // 下
                if(x+1<board.length){
                    if(board[x+1][y]=='E'){
                        queue.add(new int[]{x+1,y});
                        board[x+1][y]='B';
                    }

                }
                // 左
                if(y-1>=0){
                    if(board[x][y-1]=='E'){
                        queue.add(new int[]{x,y-1});
                        board[x][y-1]='B';
                    }
                }
                // 右
                if(y+1<board[x].length){
                    if(board[x][y+1]=='E'){
                        queue.add(new int[]{x,y+1});
                        board[x][y+1]='B';
                    }

                }
                // 左上
                if(x-1>=0&&y-1>=0){
                    if(board[x-1][y-1]=='E'){
                        queue.add(new int[]{x-1,y-1});
                        board[x-1][y-1]='B';
                    }

                }
                // 右上
                if(x-1>=0&&y+1<board[x].length){
                    if(board[x-1][y+1]=='E'){
                        queue.add(new int[]{x-1,y+1});
                        board[x-1][y+1]='B';
                    }

                }
                // 左下
                if(x+1<board.length&&y-1>=0){
                    if(board[x+1][y-1]=='E'){
                        queue.add(new int[]{x+1,y-1});
                        board[x+1][y-1]='B';
                    }

                }
                // 右下
                if(x+1<board.length&&y+1<board[x].length){
                    if(board[x+1][y+1]=='E'){
                        queue.add(new int[]{x+1,y+1});
                        board[x+1][y+1]='B';
                    }

                }

            }

        }
        return board;

    }


    public static void main(String[] args) {
        int[] click ={3,0};
        char[][] board = {
                {'E','E','E','E','E'},
                {'E','E','M','E','E'},
                {'E','E','E','E','E'},
                {'E','E','E','E','E'}};
        for (char[] chars : updateBoard(board,click)) {
            for (char aChar : chars) {
                System.out.print(aChar+" ");
            }
            System.out.println();

        }
    }
}
