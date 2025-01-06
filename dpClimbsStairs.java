import java.util.Arrays;

public class dpClimbsStairs {
    
    public static int ways(int n, int ways[]) {

        if(n == 0) {
            return 1;
        }

        if(n < 0) {
            return 0;
        }

        if(ways[n] != -1) {
            return ways[n];
        }
        ways[n] = ways(n-1, ways) + ways(n-2, ways);
        return ways[n];
    }

    public static int waysTab(int n) {

        int dp[] = new int[n+1]; // 0 to n

        dp[0] = 1;

        for(int i=1; i<=n; i++) {
            if(i == 1) {
                dp[i] = dp[i-1] + 0;
            } else {
            dp[i] = dp[i-1] + dp[i-2];
            }
        }
        return dp[n];
    } 

    public static void main(String args[]) {
        int n = 5;
        int ways[] = new int[n+1];   // by default at every index in array 0 is stored
        Arrays.fill(ways, -1);     // here -1 will get stored
        System.out.println(ways(n, ways)); 

        System.out.println(waysTab(n));
    }
}
