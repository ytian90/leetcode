package mj.linkedin;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 Question:
 已知一个函数，输入用户ID，可以返回该用户的所有友好（degree 1 friends），按好友ID从小到大排序。
 要求实现函数来输出返回一个用户的所有好友的好友(degree 2 friends), 以及 degree 3 friends。
 */
public class FindFriends {
    // return friends list according to the user userId
    private List<Integer> getFriend(int id) {
        return new ArrayList<>();
    }

    public List<Integer> secondDegree(int id) {
        if (id < 0) {
            return null;
        }
        List<Integer> res = new ArrayList<>();
        Set<Integer> friends = new HashSet<>(getFriend(id));
        for (int friend : friends) {
            List<Integer> thirdDegree = getFriend(friend);
            for (int third : thirdDegree) {
                if (friends.contains(third) || third == id) {
                    continue;
                }
                res.add(third);
            }
        }
        return res;
    }
    // 这里感觉主要是聊天看思路，中间会临时加一些限制条件，来进行时间或者空间的优化。.
}
