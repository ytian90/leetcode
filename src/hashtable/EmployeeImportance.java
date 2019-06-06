package hashtable;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 690. Employee Importance
 * @author ytian
 *
 */
public class EmployeeImportance {
	
	// dfs
	public int getImportance(List<Employee> employees, int id) {
		Map<Integer, Employee> map = new HashMap<>();
		for (Employee e : employees) {
			map.put(e.id, e);
		}
		return helper(map, id);
    }
    
    private int helper(Map<Integer, Employee> map, int id) {
		Employee e = map.get(id);
		int sum = e.importance;
		for (int n : e.subordinates) {
			sum += helper(map, n);
		}
		return sum;
    }
    
    // bfs
    public int getImportance2(List<Employee> employees, int id) {
		Map<Integer, Employee> map = new HashMap<>();
		for (Employee e : employees) {
			map.put(e.id, e);
		}
		Queue<Employee> q = new LinkedList<>();
		int sum = 0;
		q.add(map.get(id));
		while (!q.isEmpty()) {
			Employee e = q.poll();
			sum += e.importance;
			for (int sub : e.subordinates) {
				q.add(map.get(sub));
			}
		}
		return sum;
    }

	public static void main(String[] args) {

	}
	
	class Employee {
	    // It's the unique userId of each node;
	    // unique userId of this employee
	    public int id;
	    // the importance value of this employee
	    public int importance;
	    // the userId of direct subordinates
	    public List<Integer> subordinates;
	};

}
