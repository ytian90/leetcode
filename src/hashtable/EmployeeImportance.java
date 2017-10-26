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
        return helper(id, map);
    }
    
    private int helper(int id, Map<Integer, Employee> map) {
        Employee e = map.get(id);
        int total = e.importance;
        
        for (int n : e.subordinates) {
            total += helper(n, map);
        }
        return total;
    }
    
    // bfs
    public int getImportance2(List<Employee> employees, int id) {
    	int total = 0;
    	Map<Integer, Employee> map = new HashMap<>();
    	for (Employee e : employees) {
    		map.put(e.id, e);
    	}
    	Queue<Employee> q = new LinkedList<>();
    	q.offer(map.get(id));
    	while (!q.isEmpty()) {
    		Employee curr = q.poll();
    		total += curr.importance;
    		for (int s : curr.subordinates) {
    			q.offer(map.get(s));
    		}
    	}
    	return total;
    }

	public static void main(String[] args) {

	}
	
	class Employee {
	    // It's the unique id of each node;
	    // unique id of this employee
	    public int id;
	    // the importance value of this employee
	    public int importance;
	    // the id of direct subordinates
	    public List<Integer> subordinates;
	};

}
