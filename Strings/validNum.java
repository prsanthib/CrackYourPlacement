class Solution {
    public boolean isNumber(String s) {
                String np = "^[+-]?((\\d+(\\.\\d*)?)|(\\.\\d+))([eE][+-]?\\d+)?$";

    return s.matches(np);
    }
}