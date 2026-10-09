class Twitter {
    private int count;
    private Map<Integer, List<int[]>> tweetMap; // list of time, tweetId, sorted by recency
    private Map<Integer, Set<Integer>> followMap; // list of followees

    public Twitter() {
        count = 0; 
        tweetMap = new HashMap<>();
        followMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId,new ArrayList<>());
        tweetMap.get(userId).add(new int[]{count, tweetId});
        count--;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<> (Comparator.comparingInt(a-> a[0]));

        if (!followMap.containsKey(userId)) {
            followMap.put(userId, new HashSet<>());
        }
        followMap.get(userId).add(userId); 

        for(int followeeId : followMap.get(userId)){
            if(tweetMap.containsKey(followeeId)){
                List<int[]> tweets = tweetMap.get(followeeId);
                int index = tweets.size()-1;
                int[] tweet = tweets.get(index);
                minHeap.offer(new int[] {tweet[0], tweet[1], followeeId, index});
            }
        }

        while (!minHeap.isEmpty() && res.size() < 10) {
            int[] curr = minHeap.poll();
            res.add(curr[1]);
            int index = curr[3];
            if (index > 0) {
                int[] tweet = tweetMap.get(curr[2]).get(index - 1);
                minHeap.offer(new int[]{tweet[0], tweet[1], curr[2], index - 1});
            }
        }
        return res;

    }
    
    public void follow(int followerId, int followeeId) {
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followMap.get(followerId) != null && followMap.get(followerId).contains(followeeId)){
            followMap.get(followerId).remove(followeeId);
        }
    }
}
