import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 邻接表 存储图
 */
public class Graph { // 无向图

    private int v;//顶点的个数
    private LinkedList<Integer>[] adj;// 邻接表

    // 初始化一个空图
    public Graph(int v) {
        this.v=v;
        adj=new LinkedList[v];
        for (int i=0;i<v;++i){
            adj[i]=new LinkedList<>();
        }

    }

    /**
     * 无向图 加一条边
     * @param s 顶点1
     * @param t 顶点2
     */
    public void addEager(int s,int t){
        // 双向边
        adj[s].add(t);
        adj[t].add(s);
    }



    /**
     *
     * 广度优先搜索
     * @param s
     * @param t
     */
    public void bfs(int s,int t){
        if(s==t)return;
        boolean[] visited = new boolean[v];
        // 标志数组 避免重复访问
        visited[s]=true;
        // bfs 层的概念
        Queue<Integer> queue=new LinkedList<>();
        queue.add(s);
        // 反向存储 记录当前节点是由哪个节点传递过来
        int[] prev=new int[v];
        Arrays.fill(prev, -1);

        while (!queue.isEmpty()){
            int w=queue.poll();
            for (Integer edge:adj[w]){
                if(!visited[edge]){
                    prev[edge]=w;
                    if(edge==t){
                        print(prev,s,t);
                        return;
                    }


                    queue.add(edge);
                    visited[edge]=true;
                }
            }
        }
    }

    private void print(int[] prev, int s, int t){
        if(prev[t]!=-1&& t!=s ){
            print(prev,s,prev[t]);
        }
        System.out.println(t+" ");
    }

    // 比较特殊的变量 found，它的作用是，当我们已经找到终止顶点 t 之后，我们就不再递归地继续查找了
    boolean found = false;
    /**
     * 回溯的想法
     * @param s
     * @param t
     */
    private void dfs(int s,int t){
        found=false;
        boolean[] visited = new boolean[v];
        int[] prev = new int[v];
        Arrays.fill(prev,-1);

        recurDfs(visited,prev,s,t);
//        print(prev,s,t);
    }

    private void recurDfs(boolean[] visited,int[] prev,int w,int t){
        if(found == true) return;
        visited[w]=true;
        if(w==t){
            found=true;
            return;
        }
        for (Integer edge:adj[w]){
            if(!visited[edge]){
                prev[edge]=w;
                visited[edge]=true;
                recurDfs(visited,prev,edge,t);

            }

        }
    }


    public static void main(String[] args) {
        Graph graph = new Graph(8);
        graph.addEager(0,1);
        graph.addEager(1,2);
        graph.addEager(0,3);
        graph.addEager(3,4);
        graph.addEager(1,4);
        graph.addEager(2,5);
        graph.addEager(4,6);
        graph.addEager(4,5);
        graph.addEager(5,7);
        graph.addEager(6,7);
        graph.dfs(0,8);

    }






}
