public class ClothingCost {

    public static int minCost(int[][] price) {
        int n = price.length;
        
        // Initialize the dp array with the first row of prices
        int[] dp = price[0];
        
        for (int i = 1; i < n; i++) {
            // Calculate the minimum cost for each color for the current person
            int[] newDp = new int[3];
            newDp[0] = price[i][0] + Math.min(dp[1], dp[2]);
            newDp[1] = price[i][1] + Math.min(dp[0], dp[2]);
            newDp[2] = price[i][2] + Math.min(dp[0], dp[1]);
            
            dp = newDp;
        }
        
        // Return the minimum cost among the three colors for the last person
        return Math.min(dp[0], Math.min(dp[1], dp[2]));
    }

    public static void main(String[] args) {
        int[][] price = {
            {14, 4, 11},
            {11, 14, 3},
            {14, 2, 10}
        };
        
        int output = minCost(price);
        System.out.println(output); 
    }
}
