class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, List<int[]>> columnTable = new TreeMap<>();
        
        Queue<Object[]> queue = new LinkedList<>();
        queue.offer(new Object[] {root, 0, 0});
        
        while (!queue.isEmpty()) {
            Object[] tuple = queue.poll();
            TreeNode node = (TreeNode) tuple[0];
            int row = (int) tuple[1];
            int col = (int) tuple[2];
            
            if (!columnTable.containsKey(col)) {
                columnTable.put(col, new ArrayList<>());
            }
            columnTable.get(col).add(new int[] {row, node.val});
            
            if (node.left != null) {
                queue.offer(new Object[] {node.left, row + 1, col - 1});
            }
            if (node.right != null) {
                queue.offer(new Object[] {node.right, row + 1, col + 1});
            }
        }
        
        List<List<Integer>> result = new ArrayList<>();
        for (List<int[]> col : columnTable.values()) {

            Collections.sort(col, (a, b) -> {
                if (a[0] == b[0]) {
                    return Integer.compare(a[1], b[1]);
                } else {
                    return Integer.compare(a[0], b[0]);
                }
            });

            List<Integer> sortedColumn = new ArrayList<>();
            for (int[] tuple : col) {
                sortedColumn.add(tuple[1]);
            }
            result.add(sortedColumn);
        }
        
        return result;
    }
}
