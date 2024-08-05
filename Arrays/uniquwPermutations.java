class Solution {
    static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> nums , int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Collections.sort(nums); // Sort the array to handle duplicates
        boolean[] used = new boolean[nums.size()];
        backtrack(nums, used, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(ArrayList<Integer> nums, boolean[] used, ArrayList<Integer> current, ArrayList<ArrayList<Integer>> result) {
        if (current.size() == nums.size()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.size(); i++) {
            if (used[i]) continue;  
            if (i > 0 && nums.get(i).equals(nums.get(i - 1)) && !used[i - 1]) continue; // Skip duplicates

            used[i] = true;
            current.add(nums.get(i));
            backtrack(nums, used, current, result);
            used[i] = false;
            current.remove(current.size() - 1);
        }
    
    }
}
