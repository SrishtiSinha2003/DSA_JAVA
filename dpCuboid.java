import java.util.Arrays;

public class dpCuboid {
    
    public static int maxHeight(int[][] cuboids) {
        int n = cuboids.length;

        // Step 1: Normalize each cuboid such that width <= length <= height
        for (int[] cuboid : cuboids) {
            Arrays.sort(cuboid);
        }

        // Step 2: Sort cuboids by width, then length, then height
        Arrays.sort(cuboids, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];  // Sort by width
            if (a[1] != b[1]) return a[1] - b[1];  // Sort by length
            return a[2] - b[2];  // Sort by height
        });

        // Step 3: Apply dynamic programming (LIS approach)
        int[] dp = new int[n];  // dp[i] represents the max height achievable with cuboid[i] at the bottom
        int maxHeight = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = cuboids[i][2];  // Initial height is just the height of cuboid i
            for (int j = 0; j < i; j++) {
                // If cuboid j can be placed on cuboid i
                if (cuboids[j][0] <= cuboids[i][0] &&
                    cuboids[j][1] <= cuboids[i][1] &&
                    cuboids[j][2] <= cuboids[i][2]) {
                    dp[i] = Math.max(dp[i], dp[j] + cuboids[i][2]);
                }
            }
            maxHeight = Math.max(maxHeight, dp[i]);
        }

        return maxHeight;
    }

    public static void main(String[] args) {
        int[][] cuboids = {
            {50, 45, 20},
            {95, 37, 53},
            {45, 23, 12}
        };
        System.out.println("Maximum height of stacked cuboids: " + maxHeight(cuboids));  // Output: 190
    }
}
