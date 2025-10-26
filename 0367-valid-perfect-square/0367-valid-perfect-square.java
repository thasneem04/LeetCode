class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 2) return true; // 0 and 1 are perfect squares

        long left = 2, right = num / 2; // start from 2 to num/2
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long square = mid * mid;

            if (square == num) {
                return true; // found perfect square
            } else if (square < num) {
                left = mid + 1; // search right half
            } else {
                right = mid - 1; // search left half
            }
        }
        return false; // not a perfect square
    }
}
