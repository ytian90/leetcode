package leetcode.mj.google;

import java.util.*;

/**
 * 15. 王位继承
 */
public class Kings {
    // key: parent, value: children
    Map<String, List<String>> tree = new HashMap<>();
    Set<String> dead = new HashSet<>();
    String root = "king";

    public Kings() {
        tree.put(root, new ArrayList<>());
    }

    public void birth(String parent, String name) {
        if (!tree.containsKey(parent)) {
            return;
        } else {
            tree.get(parent).add(name);
            tree.put(name, new ArrayList<>());
        }
    }

    public void death(String name) {
        dead.add(name);
    }

    public List<String> getOrder() {
        List<String> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    private void dfs(String curr, List<String> res) {
        if (!dead.contains(curr)) {
            res.add(curr);
        }
        for (String child : tree.get(curr)) {
            dfs(child, res);
        }
    }
}
