package src;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 429. N叉树的层序遍历
 */
public class LeetCode429 {
    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> levels = new ArrayList<>();
        if(root == null){
            return levels;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int levelLength = queue.size();
            levels.add(new ArrayList<>());
            for (int i = 0; i < levelLength; i++) {
                Node node = queue.poll();
                levels.get(level).add(node.val);
                for (Node node1 : node.children) {
                    queue.add(node1);
                }
            }

            level++;

        }
        return levels;
    }
}
