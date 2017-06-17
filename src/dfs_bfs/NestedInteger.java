package dfs_bfs;

import java.util.ArrayList;
import java.util.List;

public class NestedInteger {
	
	private Integer value;
	private List<NestedInteger> list;
	
	public NestedInteger() {
		value = null;
		list = new ArrayList<>();
	}
	
	public NestedInteger(int value) {
		this.value = value;
		
	}
	
	public boolean isInteger() {
		return value != null;
	}
	
	public Integer getInteger() {
		return value;
	}
	
	public void setInteger(int value) {
		this.value = value;
	}
	
	public void add(NestedInteger ni) {
		list.add(ni);
	}
	
	public List<NestedInteger> getList() {
		return new ArrayList<NestedInteger>();
	}
	
}
