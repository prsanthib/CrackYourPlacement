class Solution {
     static class Info implements Comparable<Info>
    {
        int i;
        int j;
        double val;
        public Info(int i , int j , double val)
        {
            this.i = i;
            this.j = j;
            this.val = val;
        }

        @Override
        public int compareTo(Info i2)
        {
            return Double.compare(this.val,i2.val);
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Info> pq = new PriorityQueue<>();
        for(int i = 0 ; i < points.length ; i++)
        {
            double sol = Math.sqrt(Math.pow(points[i][0],2)+Math.pow(points[i][1],2));
            pq.add(new Info(points[i][0],points[i][1],sol));
        }

        int temp[][] = new int[k][2];
        int i = 0;
        while(i < k && !pq.isEmpty())
        {
            Info curr = pq.remove();
            temp[i][0] = curr.i;
            temp[i][1] = curr.j;
            i++;
        }

        return temp;

    }
}