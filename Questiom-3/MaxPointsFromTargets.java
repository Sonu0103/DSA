public class MaxPointsFromTargets {
    public static int maxPoints(int[] a) {
        int n = a.length;
        int[] paddedArray = new int[n + 2];
        System.arraycopy(a, 0, paddedArray, 1, n);
        paddedArray[0] = paddedArray[n + 1] = 1;

        int[][] dp = new int[n + 2][n + 2];

        for (int len = 1; len <= n; len++) {
            for (int start = 1; start <= n - len + 1; start++) {
                int end = start + len - 1;
                for (int k = start; k <= end; k++) {
                    dp[start][end] = Math.max(dp[start][end],
                            dp[start][k - 1] + paddedArray[start - 1] * paddedArray[k] * paddedArray[end + 1] + dp[k + 1][end]);
                }
            }
        }

        return dp[1][n];
    }

    public static void main(String[] args) {
        int[] a = {3, 1, 5, 8};
        int output = maxPoints(a);
        System.out.println(output);  
    }
}

