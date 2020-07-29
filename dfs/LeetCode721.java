import java.lang.reflect.Array;
import java.util.*;

/**
 * 721. 账户合并
 */
public class LeetCode721 {



    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String,String> emailToName = new HashMap<>();
        Map<String, ArrayList<String>> graph = new HashMap<>();

        for (List<String> account : accounts) {
            String name = "";

            for (String email : account) {
                if (name.equals("")){
                    name = email;
                    continue;
                }
                graph.computeIfAbsent(email,x -> new ArrayList<String>()).add(account.get(1));
                graph.computeIfAbsent(account.get(1),x->new ArrayList<String>()).add(email);
                emailToName.put(email,name);

            }
        }


        Set<String> seen = new HashSet<>();
        List<List<String>> ans = new ArrayList<>();

        for (String email : graph.keySet()) {
            if(!seen.contains(email)){
                seen.add(email);
                Stack<String> stack = new Stack<>();
                stack.push(email);
                List<String> component = new ArrayList<>();
                while (!stack.isEmpty()){
                    String node = stack.pop();
                    component.add(node);
                    for (String s : graph.get(node)) {
                        if(!seen.contains(s)){
                            seen.add(s);
                            stack.push(s);
                        }
                    }
                }
                Collections.sort(component);
                component.add(0,emailToName.get(email));
                ans.add(component);
            }
        }

        return ans;


    }


}
