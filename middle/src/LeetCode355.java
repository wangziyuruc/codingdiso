package src;

import java.util.*;

/**
 * 355. 设计推特
 */
public class LeetCode355 {

    HashMap<Integer, List<Integer>> users;
    HashMap<Integer, List<TW>> twitters;

    public static Integer time=0;

    /**
     * Initialize your data structure here.
     */
    public LeetCode355() {
        users = new HashMap<>();
        twitters = new HashMap<>();
    }
    public class TW {
        Integer id;
        Integer createTime;

        public TW(Integer id) {
            this.id = id;
            time++;
            this.createTime = time;
        }
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        twitters.computeIfAbsent(userId, k -> new ArrayList<>());
        twitters.get(userId).add(new TW(tweetId));
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();


        PriorityQueue<TW> pq = new PriorityQueue<>((a, b)->a.createTime.compareTo(b.createTime));
        twitters.computeIfAbsent(userId, k -> new ArrayList<>());

        twitters.get(userId).forEach(pq::offer);

        List<Integer> user = users.get(userId);
        if(user==null){
            user=new ArrayList<>();
        }
        for (Integer u : user) {
            if(userId == u){
                continue;
            }
            List<TW> twitter = twitters.get(u);
            if(twitter==null){
                twitter=new ArrayList<>();
            }
            for (TW t : twitter) {
                pq.offer(t);

            }
            while (pq.size() > 10) {
                pq.poll();
            }
        }
        while (pq.size() > 10) {
            pq.poll();
        }

        while (!pq.isEmpty()) {
            result.add(0,pq.poll().id);
        }
        return result;
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if(users.get(followerId)==null){
            users.put(followerId,new ArrayList<>());
        }else{
            users.get(followerId).removeIf(id->id==followeeId);
        }


    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {

        users.computeIfAbsent(followerId, k -> new ArrayList<>());
        if(users.get(followerId).contains(followeeId)){
            return;
        }
        users.get(followerId).add(followeeId);
    }


    public static void main(String[] args) {
        LeetCode355 twitter = new LeetCode355();
        // 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
        twitter.postTweet(1, 5);
        twitter.postTweet(1, 3);
        twitter.postTweet(1, 101);
        twitter.postTweet(1, 13);
        twitter.postTweet(1, 10);
        twitter.postTweet(1, 2);
        twitter.postTweet(1, 94);
        twitter.postTweet(1, 505);
        twitter.postTweet(1, 33);
        twitter.postTweet(1,22);
        twitter.postTweet(1,11);
        twitter.getNewsFeed(1).forEach(System.out::println);

    }
}
