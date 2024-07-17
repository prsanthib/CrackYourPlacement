class RandomizedCollection {

    public static ArrayList<Integer> multiset = new ArrayList<>();
    public RandomizedCollection() {
        multiset.clear();
    }
    
    public boolean insert(int val) {
        if(multiset.contains(val))
        {
            multiset.add(val);
            return false;
        }
        multiset.add(val);
        return true;
    }
    
    public boolean remove(int val) {

        return multiset.remove(Integer.valueOf(val));
    }
    
    public int getRandom() {
        Random random = new Random();
        int k = multiset.get(random.nextInt(multiset.size()));
        return k;
    }
    public static void main(String args[])
    {
        RandomizedCollection obj = new RandomizedCollection();
        boolean param_1 = obj.insert(val);
        boolean param_2 = obj.remove(val);
        int param_3 = obj.getRandom();
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */