public class LongestDecreasingSubsequence {

    public static int longestSubsequence(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        
        for (int i = 0; i < n; i++) {
            dp[i] = 1;  // Initialize the length of longest subsequence ending at i to 1
            for (int j = 0; j < i; j++) {
                if (nums[i] < nums[j] && nums[j] - nums[i] <= k) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
        int maxLength = 0;
        for (int len : dp) {
            maxLength = Math.max(maxLength, len);
        }
        
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {8, 5, 4, 2, 1, 4, 3, 4, 3, 1, 15};
        int k = 3;
        int output = longestSubsequence(nums, k);
        System.out.println(output);  
    }
}
