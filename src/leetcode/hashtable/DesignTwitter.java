package leetcode.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 355. Design Twitter
 * @author yutian
 * @since Jul 16, 2016
 */
public class DesignTwitter {
	
	private static int timeStamp = 0;
	private Map<Integer, User> userMap;
	
	private class Tweet {
		public int tweetId;
		public int time;
		public Tweet next;
		public Tweet(int tweetId) {
			this.tweetId = tweetId;
			time = timeStamp++;
			next = null;
		}
	}
	
	public class User {
		public int userId;
		public Set<Integer> followed;
		public Tweet tweetHead;
		
		public User(int userId) {
			this.userId = userId;
			followed = new HashSet<>();
			follow(userId);
			tweetHead = null;
		}
		
		public void follow(int userId) {
			followed.add(userId);
		}
		
		public void unfollow(int userId) {
			followed.remove(userId);
		}
		
		public void post(int tweetId) {
			Tweet t = new Tweet(tweetId);
			t.next = tweetHead;
			tweetHead = t;
		}
	}
	
	/** Initialize your data structure here. */
    public DesignTwitter() {
        userMap = new HashMap<>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)) {
        	User u = new User(userId);
        	userMap.put(userId, u);
        }
        userMap.get(userId).post(tweetId);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new LinkedList<>();
        if (!userMap.containsKey(userId)) return res;
        Set<Integer> users = userMap.get(userId).followed;
        PriorityQueue<Tweet> pq = new PriorityQueue<>
        			((a, b) -> (b.time - a.time));
        for (int user: users) {
        	Tweet t = userMap.get(user).tweetHead;
        	if (t != null) pq.add(t);
        }
        int count = 0;
        while (!pq.isEmpty() && count < 10) {
        	Tweet t = pq.poll();
        	res.add(t.tweetId);
        	count++;
        	if (t.next != null) pq.add(t.next);
        }
        return res;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
        	User u  = new User(followerId);
        	userMap.put(followerId, u);
        }
        if (!userMap.containsKey(followeeId)) {
        	User u = new User(followeeId);
        	userMap.put(followeeId, u);
        }
        userMap.get(followerId).follow(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId) || followerId == followeeId) {
        	return;
        }
        userMap.get(followerId).unfollow(followeeId);
    }

	public static void main(String[] args) {
		DesignTwitter t = new DesignTwitter();
		t.postTweet(1, 123);
		t.postTweet(1, 333);
		List<Integer> param_2 = t.getNewsFeed(1);
		for (int i : param_2) {
			System.out.println(i);
		}
		
	}

}
