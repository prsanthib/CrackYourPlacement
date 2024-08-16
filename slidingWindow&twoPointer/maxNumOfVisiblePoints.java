class Solution {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        int sameLocationCount = 0;
        List<Double> angles = new ArrayList<>();
        
        for (List<Integer> point : points) {
            int x = point.get(0);
            int y = point.get(1);
            
            if (x == location.get(0) && y == location.get(1)) {
                sameLocationCount++;
            } else {
                double angleToPoint = Math.atan2(y - location.get(1), x - location.get(0));
                angles.add(Math.toDegrees(angleToPoint));
            }
        }
        
        Collections.sort(angles);
        
        List<Double> extendedAngles = new ArrayList<>(angles);
        for (double angleValue : angles) {
            extendedAngles.add(angleValue + 360);
        }
        
        int maxVisible = 0;
        int start = 0;
        
        for (int end = 0; end < extendedAngles.size(); end++) {
            while (extendedAngles.get(end) - extendedAngles.get(start) > angle) {
                start++;
            }
            maxVisible = Math.max(maxVisible, end - start + 1);
        }
        
        return maxVisible + sameLocationCount;
    }
}