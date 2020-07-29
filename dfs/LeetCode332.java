import java.util.*;

/**
 * 332. 重新安排行程
 */
public class LeetCode332 {


    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> ans = new LinkedList<>();
        if(tickets == null || tickets.size()==0){
            return ans;
        }
        Map<String,PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            PriorityQueue<String> strings = graph.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>());
            strings.add(ticket.get(1));
        }

        visit(graph,"JFK",ans);
        return ans;

    }

    private void visit(Map<String, PriorityQueue<String>> graph,
                       String src,List<String> ans){
        PriorityQueue<String> nbr = graph.get(src);

        while (nbr!=null&&nbr.size()>0){
            String dest = nbr.poll();
            visit(graph,dest,ans);

        }

        ans.add(0,src);
    }


}
