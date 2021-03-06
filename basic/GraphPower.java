import java.util.*;


/**
 * 带权图
 */
public class GraphPower {
    private int v;//顶点个数
    private LinkedList<Edge>[] adj;// 邻接表

    public GraphPower(int v) {
        this.v = v;
        this.adj = new LinkedList[v];
        for (int i = 0; i < adj.length; i++) {
            this.adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t, int w) {
        Edge edge = new Edge(s, t, w);
        this.adj[s].add(edge);
    }

    private static class Edge {
        public int sid;// 边的起始顶点
        public int tid; // 边的终止顶点

        public int w;// 权重

        public Edge(int sid, int tid, int w) {
            this.sid = sid;
            this.tid = tid;
            this.w = w;
        }
    }

    // 下面这个类是为了dijkstra实现用
    private class Vertex {
        public int id;// 顶点编号id
        public int dist;// 从起始点到这个顶点的距离

        public Vertex(int id, int dist) {
            this.id = id;
            this.dist = dist;
        }
    }

    /**
     * 小顶堆
     */
    private class PriorityQueue {
        // 根据vertex.dist构建小顶堆，堆得起始节点重1开始
        private Vertex[] nodes;
        private int count;

        public PriorityQueue(int v) {
            this.nodes = new Vertex[v + 1];
            this.count = 0;
        }

        /**
         * 弹出距离最小的顶点，从上向下堆化
         *
         * @return
         */
        public Vertex poll() {
            Vertex vertex = nodes[1];
            nodes[1] = nodes[count];
            count--;
            int i = 1;
            // 从上到下堆化
            while (true) {
                int minPos = i;
                if (i * 2 <= this.count && nodes[minPos].dist > nodes[i * 2].dist) {
                    minPos = i * 2;
                }

                if (i * 2 + 1 <= this.count && nodes[minPos].dist > nodes[i * 2 + 1].dist) {
                    minPos = i * 2 + 1;
                }
                if (minPos == i) {
                    break;
                }
                swap(nodes, i, minPos);
                i = minPos;

            }
            return vertex;
        }

        public void swap(Vertex[] v, int i, int j) {
            Vertex tmp = nodes[i];
            nodes[i] = nodes[j];
            nodes[j] = tmp;
        }

        /**
         * 从下向上堆化
         *
         * @param vertex 添加到末尾
         */
        public void add(Vertex vertex) {
            if (count == nodes.length) return;
            count++;
            nodes[count] = vertex;
            // 从下向上堆化
            int i = count;
            while (i / 2 > 0 && nodes[i].dist < nodes[i / 2].dist) {
                swap(nodes, i, i / 2);
                i = i / 2;
            }


        }

        // 更新结点的值，并且从下往上堆化，重新符合堆的定义。时间复杂度O(logn)。
        public void update(Vertex vertex) {
            int position = 0;
            for (int i = 1; i < this.count; i++) {
                if (nodes[i].id == vertex.id) {
                    position = i;
                    break;
                }
            }
            // 从下向上堆化
            for (int i = position; i > 0; i = i / 2) {
                if (nodes[i].dist < nodes[i * 2].dist) {
                    swap(nodes, i, i / 2);
                }
            }
        }

        public boolean isEmpty() {
            return this.count == 0;
        }


    }

    /**
     * 单源最短路径
     *
     * @param s 源点
     * @param t 目标点
     */
    public void dijkstra(int s, int t) {
        boolean[] visits = new boolean[this.v];// 标志位 图是否全部访问过
        Vertex[] vertices = new Vertex[this.v];// 单元点到各个顶点的距离
        int[] predecessor = new int[this.v];//顶点s到顶点t的最短路径
        for (int i = 0; i < vertices.length; i++) { // 初始化最短路径中的数据
            vertices[i] = new Vertex(i, Integer.MAX_VALUE);
        }
        Arrays.fill(predecessor, -1);// 初始化路径数组
        PriorityQueue pq = new PriorityQueue(this.v);// 做个小顶堆 不断弹出  权值最小的边
        vertices[s].dist = 0;// 初始化原点到自己的距离为零
        visits[s] = true;// 初始化原点已经被访问过了
        pq.add(vertices[s]);// 源点添加到优先级队列中
        while (!pq.isEmpty()) {
            Vertex minVertex = pq.poll(); // 获取源点到目标点权值最小的哪个目标点
            if (minVertex.id == t) {
                break;
            }
            for (Edge edge : adj[minVertex.id]) {// 循环弹出点的相关的边
                Vertex nextVertex = vertices[edge.tid];

                // 判断当前目标点权值和当前点到目标点的权值+该店的距离如果小于更新
                // 该过程可能存在已经访问过的点 需要同步更新
                if (minVertex.dist + edge.w < nextVertex.dist) {
                    nextVertex.dist = minVertex.dist + edge.w;
                    predecessor[nextVertex.id] = minVertex.id;
                    if (visits[edge.tid]) {
                        pq.update(nextVertex);
                    } else {
                        pq.add(nextVertex);
                        visits[edge.tid] = true;
                    }

                }
            }
        }
        // 输出最短路径
        System.out.print(s);
        print(s, t, predecessor);
    }

    public void print(int s, int t, int[] predecessor) {
        if (predecessor[t] != -1 && t != s) {
            print(s, predecessor[t], predecessor);
        }
        System.out.println(t + " ");
    }


    // 拓扑排序  kahn算法 & dfs 深度优先遍历

    /**
     * 定义数据结构的时候，如果 s 需要先于 t 执行，那就添加一条 s 指向 t 的边。
     * 所以，如果某个顶点入度为 0， 也就表示，没有任何顶点必须先于这个顶点执行，那么这个顶点就可以执行了。
     * 我们先从图中，找出一个入度为 0 的顶点，将其输出到拓扑排序的结果序列中（对应代码中就是把它打印出来），
     * 并且把这个顶点从图中删除（也就是把这个顶点可达的顶点的入度都减 1）。
     * 我们循环执行上面的过程，直到所有的顶点都被输出。最后输出的序列，就是满足局部依赖关系的拓扑排序。
     */
    public void topoSortByKahn() {
        int[] inDegree = new int[v];// 入度计算
        // 初始化入度
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                Edge w = adj[i].get(j);
                inDegree[w.tid]++;

            }
        }

        Queue<Integer> vZero = new ArrayDeque<>();
        // 寻找入度为0的点
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                vZero.add(i);
            }
        }


        while (!vZero.isEmpty()) {
            int i = vZero.poll();
            System.out.print("->" + i);
            for (int j = 0; j < adj[i].size(); j++) {
                Edge e = adj[i].get(j);
                inDegree[e.tid]--;
                if (inDegree[e.tid] == 0) {
                    vZero.add(e.tid);
                }
            }
        }
    }

    /**
     * 第一部分是通过邻接表构造逆邻接表。邻接表中，边 s->t 表示 s 先于 t 执行，也就是 t 要依赖 s。
     * 在逆邻接表中，边 s->t 表示 s 依赖于 t，s 后于 t 执行。为什么这么转化呢？
     * 这个跟我们这个算法的实现思想有关。第二部分是这个算法的核心，也就是递归处理每个顶点。
     * 对于顶点 vertex 来说，我们先输出它可达的所有顶点，也就是说，先把它依赖的所有的顶点输出了，然后再输出自己。
     */
    public void topoSortByDFS() {
        // 先构建 逆邻接表 边s->t s 依赖于t t先于s
        LinkedList<Edge> inverseAdj[] = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            inverseAdj[i] = new LinkedList<>();
        }

        // 通过邻接表生产逆 邻接表
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                Edge e = adj[i].get(j);
                inverseAdj[e.tid].add(new Edge(e.tid, e.sid, 0));
            }
        }
        boolean[] visited = new boolean[v];
        Arrays.fill(visited, false);
        for (int i = 0; i < v; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                dfs(i, inverseAdj, visited);
            }
        }


    }

    private void dfs(int vertex, LinkedList<Edge>[] inverseAdj, boolean[] visited) {
        for (int i = 0; i < inverseAdj[vertex].size(); i++) {
            Edge e = inverseAdj[vertex].get(i);
            if (visited[e.tid] == true) {
                continue;
            }
            visited[e.tid] = true;
            dfs(e.tid,inverseAdj,visited);

        }
        // 先把vertex这个顶点可达的所有顶点都打印出来之后，再打印它自己
        System.out.println("->" + vertex);
    }

    public static void main(String[] args) {
        GraphPower graphPower = new GraphPower(6);
        graphPower.adj[0].add(new Edge(0, 1, 10));
        graphPower.adj[0].add(new Edge(0, 4, 15));
        graphPower.adj[1].add(new Edge(1, 3, 2));
        graphPower.adj[1].add(new Edge(1, 2, 15));
        graphPower.adj[2].add(new Edge(2, 5, 5));
        graphPower.adj[3].add(new Edge(3, 2, 1));
        graphPower.adj[3].add(new Edge(3, 5, 12));
        graphPower.adj[4].add(new Edge(4, 5, 10));

        graphPower.topoSortByDFS();


    }
}
