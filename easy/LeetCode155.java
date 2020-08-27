import java.util.ArrayList;
import java.util.Optional;
import java.util.Stack;

/**
 * 155. 最小栈
 */
public class LeetCode155 {

    Stack<Integer> stack;

    Stack<Integer> min;
    public LeetCode155() {
        stack = new Stack<Integer>();
        min = new Stack<>();
    }

    public void push(int x) {
        if(min.isEmpty() || x <= min.peek())
            min.push(x);
        stack.push(x);
    }

    public void pop() {
        int x = stack.pop();
        if (x == min.peek()){
            min.pop();
        }

    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
