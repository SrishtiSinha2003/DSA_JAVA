public class dpParaComb {

    // Function to count the number of valid parenthesis combinations using DP
    public static int countParenthesisCombinations(int N) {
        // dp array where dp[i] will store the number of combinations for i pairs of parentheses
        int[] dp = new int[N + 1];
        
        // Base case: 1 combination for 0 pairs of parentheses (empty string)
        dp[0] = 1;
        
        // Fill the dp array using the Catalan recurrence relation
        for (int i = 1; i <= N; i++) {
            dp[i] = 0;
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        
        return dp[N]; // Return the result for N pairs
    }

    public static void main(String[] args) {
        int N = 4; // Example: N pairs of parentheses
        int result = countParenthesisCombinations(N);
        System.out.println("Number of valid combinations for " + N + " pairs of parentheses: " + result);
    }
}
