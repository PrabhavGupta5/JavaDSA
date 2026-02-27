package Heap;
import java.util.*;

// https://leetcode.com/problems/design-twitter/description/

public class DesignTwitter {

    // We are using a class Tweet to store the time and the tweetId, and a class User to store the userId, the list of followers and the list of tweets.
    // The Twitter class contains a HashMap to store the userId and the User object, and a timeCounter to keep track of the time of the tweets.
    // The postTweet method adds a new tweet to the user's list of tweets, and increments the timeCounter.
    // The getNewsFeed method uses a priority queue to store the tweets of the user and the followers, and returns the 10 most recent tweets.
    // The follow method adds a followee to the user's list of followers, and the unfollow method removes a followee from the user's list of followers.
    // Time complexity: O(N log 10) where N is the number of followers and 10 is the number of tweets we want to return
    // Space complexity: O(N) for the priority queue and the result list
    // We are using a max heap to store the tweets of the user and the followers, and return the 10 most recent tweets. We are using a timeCounter to keep track
    // of the time of the tweets, and a HashMap to store the userId and the User object.
    class Tweet{
        int time;
        int tweetId;
        Tweet(int t, int id){
            time = t;
            tweetId = id;
        }
    }
    class User {
        int userId;
        HashSet<Integer> followers;
        List<Tweet> tweets;
        public User(int userId){
            this.userId = userId;
            followers = new HashSet<>();
            followers.add(userId);//add self also as follower;
            tweets = new LinkedList<>();
        }
        public void addTweet(Tweet t){
            tweets.addFirst(t); //insertion at the head
        }
        public void addFollower(int followeeId){
            followers.add(followeeId);
        }
        public void removeFollower(int followeeId){
            followers.remove(followeeId);
        }
    }

    class Twitter {
        HashMap<Integer,User> userMap;
        int timeCounter;
        public Twitter() {
            userMap = new HashMap<>();
            timeCounter=0;
        }

        public void postTweet(int userId, int tweetId) {
            timeCounter++;
            //checking if user exists, if not create a new user and add the tweet to the user's list of tweets
            if(!userMap.containsKey(userId)){
                userMap.put(userId, new User(userId));
            }

            User user = userMap.get(userId);
            user.addTweet(new Tweet(timeCounter, tweetId));
        }

        // N*(10log10)
        public List<Integer> getNewsFeed(int userId) {

            if(!userMap.containsKey(userId)){
                return new ArrayList<>();
            }
            PriorityQueue<Tweet> pq = new PriorityQueue<>((a,b)->b.time - a.time); //max heap
            //add self tweets + followers tweets
            User user = userMap.get(userId);
            // N*10log10
            for(int followerId : user.followers){
                int count=0;
                for(Tweet tweet : userMap.get(followerId).tweets){
                    pq.offer(tweet); //logT
                    count++;
                    if(count>10){
                        break;
                    }
                }
            }
            //10log10
            List<Integer> res = new ArrayList<>();
            int index=0;
            while(!pq.isEmpty() && index<10){
                Tweet tweet = pq.poll();
                res.add(tweet.tweetId);
                index++;
            }
            return res;

        }

        public void follow(int followerId, int followeeId) {
            //const
            if(!userMap.containsKey(followerId)){
                userMap.put(followerId, new User(followerId));
            }
            if(!userMap.containsKey(followeeId)){
                userMap.put(followeeId, new User(followeeId));
            }
            // add followee to follower's list of followers
            // we are adding followee to follower's list of followers because in getNewsFeed we are iterating through the followers and getting their tweets
            // its basically userId is following followeeId, so we need to add followeeId to userId's list of followers
            User user = userMap.get(followerId);
            user.addFollower(followeeId);
        }

        public void unfollow(int followerId, int followeeId) {
            //const
            if(!userMap.containsKey(followerId) || !userMap.containsKey(followeeId)){
                return;
            }
            // remove followee from follower's list of followers
            User user = userMap.get(followerId);
            user.removeFollower(followeeId);
        }
    }
}
