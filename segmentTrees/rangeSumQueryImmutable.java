class NumArray {
    private int[] segmentTree;
    private int n;

    public NumArray(int[] nums) {
        if (nums.length > 0) {
            n = nums.length;
            segmentTree = new int[2 * n];
            buildTree(nums);
        }
    }

    private void buildTree(int[] nums) {
        // Insert leaf nodes in segment tree
        for (int i = 0; i < n; i++) {
            segmentTree[n + i] = nums[i];
        }
        // Build the tree by calculating parents
        for (int i = n - 1; i > 0; i--) {
            segmentTree[i] = segmentTree[2 * i] + segmentTree[2 * i + 1];
        }
    }

    public void update(int index, int val) {
        // Update the leaf node
        index += n;
        segmentTree[index] = val;
        // Update the parents
        while (index > 1) {
            index /= 2;
            segmentTree[index] = segmentTree[2 * index] + segmentTree[2 * index + 1];
        }
    }

    public int sumRange(int left, int right) {
        left += n;
        right += n;
        int sum = 0;
        while (left <= right) {
            if ((left % 2) == 1) {
                sum += segmentTree[left];
                left++;
            }
            if ((right % 2) == 0) {
                sum += segmentTree[right];
                right--;
            }
            left /= 2;
            right /= 2;
        }
        return sum;
    }
}