import java.util.List;
import java.util.Stack;

/**
 * 841. 钥匙和房间
 */
public class LeetCode841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] seen = new boolean[rooms.size()];
        seen[0]=true;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        while (!stack.isEmpty()){
            int node = stack.pop();
            for (Integer integer : rooms.get(node)) {
                if(!seen[integer]){
                    seen[integer] = true;
                    stack.push(integer);
                }
            }
        }

        for (boolean b : seen) {
            if (!b) return false;
        }
        return true;

    }
}
