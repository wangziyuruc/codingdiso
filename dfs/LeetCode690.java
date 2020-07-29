import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 690. 员工的重要性
 */
public class LeetCode690 {

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };

    Map<Integer,Employee> emap;

    public int getImportance(List<Employee> employees, int id) {
        emap = new HashMap<>();
        for (Employee employee : employees) {
            emap.put(employee.id,employee);
        }
        return dfs(id);

    }

    public int dfs(int eid){
        Employee employee = emap.get(eid);
        int ans = employee.importance;
        for (Integer subId:employee.subordinates){
            ans += dfs(subId);
        }
        return ans;

    }

}
