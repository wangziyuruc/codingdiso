/**
 *   547. 朋友圈
 */
public class LeetCode547 {


    public void dfs(int[][] M,int[] visited,int i){
        for (int i1 = 0; i1 < M.length; i1++) {
            if(M[i][i1] ==1 && visited[i1]==0){
                visited[i1]=1;
                dfs(M,visited,i1);
            }
        }
    }

    public int findCircleNum(int[][] M) {

        int[] visited = new int[M.length];
        int count =0;
        for (int i = 0; i < M.length; i++) {
            if(visited[i]==0){
                dfs(M,visited,i);
                count++;
            }
        }

        return count;
    }
}
