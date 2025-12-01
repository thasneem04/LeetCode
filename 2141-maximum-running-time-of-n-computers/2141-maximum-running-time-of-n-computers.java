class Solution {
    public long maxRunTime(int n, int[] batteries) {

        long totalPower = 0;
        for(int b : batteries) {
            totalPower += b;
        }

        long min = 0;
        long max = totalPower / n;

        while(min < max) {
            long mid = (min + max + 1) / 2;

            if(canRun(batteries, n, mid)) {
                min = mid;     // go right (bigger time)
            } else {
                max = mid - 1; // go left (smaller time)
            }
        }

        return min; // min == max here
    }

    private boolean canRun(int[] batteries, int n, long time) {
        long total = 0;
        for(int b : batteries) {
            total += Math.min(b, time);
        }
        return total >= n * time;
    }
}
