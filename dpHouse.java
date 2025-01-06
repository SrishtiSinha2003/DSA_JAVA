public class dpHouse {

    public static int rob(int[] nums) {
        if (nums.length == 0) return 0;  // No houses to rob
        if (nums.length == 1) return nums[0];  // Only one house, rob it
        
        // Variables to store the max amount robbed up to the previous house (dp[i-1]) and the house before that (dp[i-2])
        int prev1 = Math.max(nums[0], nums[1]);  // The maximum amount for the first two houses
        int prev2 = nums[0];  // For the first house

        // Iterate over the remaining houses, starting from house 2
        for (int i = 2; i < nums.length; i++) {
            int current = Math.max(prev1, nums[i] + prev2);  // Max of robbing or not robbing current house
            prev2 = prev1;  // Move prev1 to prev2
            prev1 = current;  // Move current to prev1
        }
        
        return prev1;  // The max amount is stored in prev1
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};  // Example input
        System.out.println("Maximum amount of money that can be robbed: " + rob(nums));  // Output: 12
    }
}