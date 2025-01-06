public class dpPalin {

    public static int longestPalindromeSubseq(String s) {
        int n = s.length();
        // Create a DP table to store the results of subproblems
        int[][] dp = new int[n][n];
        
        // Base case: Every single character is a palindrome of length 1
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // Fill the table: for each possible length of substrings (bottom-up approach)
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;  // Ending index of the substring
                
                // If characters at the start and end are the same
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];  // Include both characters
                } else {
                    // Otherwise, take the maximum of ignoring one of the characters
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        // The result is in dp[0][n-1], which represents the longest palindromic subsequence
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        String s = "bbbab";  // Example input
        System.out.println("Longest Palindromic Subsequence Length: " + longestPalindromeSubseq(s));  // Output: 4
    }
}
