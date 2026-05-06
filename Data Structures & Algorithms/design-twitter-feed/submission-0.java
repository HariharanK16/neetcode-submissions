class Twitter {

    int count = 0;
    Map<Integer, List<int[]>> tweets;
    Map<Integer, Set<Integer>> followers;

    public Twitter() {
        count = 0;
        tweets = new HashMap<>();
        followers = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        List<int[]> tweet = tweets.getOrDefault(userId, new ArrayList<>());
        tweet.add(new int[]{count++, tweetId});
        tweets.put(userId, tweet);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b)->b[0]-a[0]);

        followers.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);
        for (int followeeId : followers.get(userId)) {
            if (tweets.containsKey(followeeId)) {
                List<int[]> tweetsL = tweets.get(followeeId);
                int index = tweetsL.size() - 1;
                int[] tweet = tweetsL.get(index);
                maxHeap.offer(new int[]{tweet[0], tweet[1], followeeId, index});
            }
        }

        while (!maxHeap.isEmpty() && res.size() < 10) {
            int[] curr = maxHeap.poll();
            res.add(curr[1]);
            int index = curr[3];
            if (index > 0) {
                int[] tweet = tweets.get(curr[2]).get(index - 1);
                maxHeap.offer(new int[]{tweet[0], tweet[1], curr[2], index - 1});
            }
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {

        if(followers.containsKey(followerId)){
            followers.get(followerId).add(followeeId);
        }else {
            Set<Integer> set = new HashSet<>();
            set.add(followeeId);
            followers.put(followerId, set);
        }
        
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followers.containsKey(followerId)){
            followers.get(followerId).remove(followeeId);
        }
    }
}
