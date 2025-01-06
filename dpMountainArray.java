import java.util.Arrays;

public class dpMountainArray {
    
    public static int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0;  // A valid mountain array must have at least 3 elements
        
        // Step 1: Compute LIS (Longest Increasing Subsequence) for each element
        int[] lis = new int[n];
        Arrays.fill(lis, 1);  // Every element is at least a subsequence of length 1
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }

        // Step 2: Compute LDS (Longest Decreasing Subsequence) for each element
        int[] lds = new int[n];
        Arrays.fill(lds, 1);  // Every element is at least a subsequence of length 1

        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (nums[i] > nums[j]) {
                    lds[i] = Math.max(lds[i], lds[j] + 1);
                }
            }
        }

        // Step 3: Find the maximum length of a bitonic subsequence
        int maxMountainLength = 0;
        for (int i = 1; i < n - 1; i++) {  // i should not be the first or last index
            if (lis[i] > 1 && lds[i] > 1) {  // Ensure there's an increasing and decreasing part
                maxMountainLength = Math.max(maxMountainLength, lis[i] + lds[i] - 1);
            }
        }

        // Step 4: The minimum number of removals is the total length minus the length of the mountain
        return n - maxMountainLength;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 1};  // Example input
        System.out.println("Minimum elements to remove to make a mountain array: " + minimumMountainRemovals(nums));  // Output: 0
    }
}
