import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 559. N叉树的最大深度
 */
public class LeetCode559 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    public int maxDepth(Node root) {
        if(root == null){
            return 0;
        }else if(root.children.isEmpty()){
            return 1;
        }else {
            List<Integer> height = new ArrayList<>();
            for (Node child : root.children) {
                height.add(maxDepth(child));
            }
            return Collections.max(height)+1;
        }

    }
}
