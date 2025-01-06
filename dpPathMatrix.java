import java.util.Arrays;

public class dpPathMatrix {

    // Function to find the longest increasing path from the top-left corner (0,0)
    public static int longestIncreasingPath(int[][] matrix) {
        int N = matrix.length;
        int M = matrix[0].length;
        
        // dp array to store the longest increasing path starting at each cell
        int[][] dp = new int[N][M];
        for (int[] row : dp) {
            Arrays.fill(row, -1); // Initialize dp with -1 (unvisited cells)
        }
        
        // Find the longest path starting from (0,0)
        return findLongestPath(matrix, 0, 0, dp, N, M);
    }

    // Helper function to recursively find the longest path from a given cell
    private static int findLongestPath(int[][] matrix, int i, int j, int[][] dp, int N, int M) {
        // If the value has already been computed, return it
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        
        // Initialize the length of the longest path starting from (i, j)
        int maxLength = 1;
        
        // Move Down: (i+1, j)
        if (i + 1 < N && matrix[i + 1][j] > matrix[i][j]) {
            maxLength = Math.max(maxLength, 1 + findLongestPath(matrix, i + 1, j, dp, N, M));
        }
        
        // Move Right: (i, j+1)
        if (j + 1 < M && matrix[i][j + 1] > matrix[i][j]) {
            maxLength = Math.max(maxLength, 1 + findLongestPath(matrix, i, j + 1, dp, N, M));
        }
        
        // Store the computed result in dp array and return it
        dp[i][j] = maxLength;
        return dp[i][j];
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2},
            {3, 4}
        };
        
        int result = longestIncreasingPath(matrix);
        System.out.println("The length of the longest increasing path is: " + result);
    }
}
