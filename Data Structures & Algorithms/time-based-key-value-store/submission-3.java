class TimeMap {
        HashMap<String, TreeMap<Integer, String>> store;
    public TimeMap() {
        store = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(store.containsKey(key)){
            TreeMap<Integer, String> tmp = store.get(key);
            tmp.put(timestamp, value);
        }else{
            TreeMap<Integer, String> tmp = new TreeMap<>();
            tmp.put(timestamp,value);
            store.put(key,tmp);
        }

    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer, String> tmp = store.get(key);
        if (tmp == null) return "";

        Integer k = tmp.floorKey(timestamp);   // largest stored timestamp <= timestamp, or null
        if (k == null) return "";

        return tmp.get(k);
        
    }
}
