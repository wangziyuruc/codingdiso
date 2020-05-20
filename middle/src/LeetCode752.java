package src;

import java.util.*;

/**
 * 752. 打开转盘锁
 */
public class LeetCode752 {
    public static int openLock(String[] deadends, String target) {

        Queue<String> queue = new ArrayDeque<>();
        Set<String> seen = new HashSet<>(Arrays.asList(deadends));
        if (seen.contains("0000")){
            return -1;
        }

        queue.offer("0000");
        seen.add("0000");
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String str = queue.poll();
                if (str.equals(target)) {
                    return depth;
                }
                for (int i = 0; i < 4; i++) {
                    for (int d = -1; d <= 1; d += 2) {
                        int y = ((str.charAt(i) - '0') + d + 10) % 10;
                        String middle = str.substring(0, i) + ("" + y) + str.substring(i + 1);
                        if (!seen.contains(middle)) {
                            seen.add(middle);
                            queue.offer(middle);
                        }
                    }
                }

            }
            depth++;

        }
        return -1;


    }

    public static void main(String[] args) {
        String[] dead = {"0201", "0101", "0102", "1212", "2002"};
        String target = "0202";
        System.out.println(openLock(dead, target));

    }
}
