public class dpTribo{

    public static void printTrib(int n) {

        int dp[] = new int[n];
        dp[0]=dp[1]=0;
        dp[2]=1;

        for(int i=3; i<n; i++){
            dp[i] = dp[i-1]+dp[i-3]+dp[i-3];

            for(int j=0; j<n; j++) {
                System.out.println(dp[i]+" ");
            }
        }
    }

    public static void main(String args[]) {
        int n = 7;
        printTrib(n);
    }
}