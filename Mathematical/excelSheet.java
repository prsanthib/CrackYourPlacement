class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder columnTitle = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber--; // Adjust to make it 0-indexed
            int remainder = columnNumber % 26;
            columnTitle.append((char) (remainder + 'A'));
            columnNumber /= 26;
        }

        return columnTitle.reverse().toString();
    }
}