package src;

import java.util.*;

/**
 * 133. 克隆图
 */
public class LeetCode133 {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }


    public Node cloneGraph(Node node) {
        Queue<Node> queue = new ArrayDeque<>();
        HashMap<Node,Node> visited = new HashMap<>();
        queue.add(node);
        // 判断该节点是否访问,避免重复访问
        visited.put(node,new Node(node.val,new ArrayList<>()));
        while (!queue.isEmpty()){
            Node n= queue.poll();

            for (Node neighbor : n.neighbors){
                // 避免节点重复访问
                if(!visited.containsKey(neighbor)){
                    visited.put(neighbor,new Node(neighbor.val,new ArrayList<>()));
                    queue.add(neighbor);
                }
                // 添加相邻节点
                visited.get(n).neighbors.add(visited.get(neighbor));
            }
        }
        return visited.get(node);


    }
}
