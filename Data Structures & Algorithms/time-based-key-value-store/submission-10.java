class TimeMap {
    private Map<String, HashMap<Integer, String>> store;
    public TimeMap() {
        store = new HashMap<>();
        
    }
    
    public void set(String key, String value, int timestamp) {
        if(!store.containsKey(key)){
            store.put(key, new HashMap<>());
        }
        store.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if(!store.containsKey(key)){
            return "";
        }
        while(!store.get(key).containsKey(timestamp) && timestamp >= 0){
            timestamp--;
        }
        if(timestamp<0) return "";
        return store.get(key).get(timestamp); 
    }
}
