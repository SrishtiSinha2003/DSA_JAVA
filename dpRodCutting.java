public class dpRodCutting {
    
    public static int rodCutting(int length[], int price[], int totalRod) {

        // weigth = length,  val = price,  W = totalRod

        int n = length.length;
        int dp[][] = new int[n+1][totalRod + 1];

        for(int i=0; i<dp.length; i++) {   // initialization
            dp[i][0] = 0;
        }

        for(int j=0; j<dp[0].length; j++) {
            dp[0][j] = 0;
        }

        for(int i=1; i<n+1; i++) {
            for(int j=1; j<totalRod+1; j++) {

                if(length[i-1] <= j) {
                    dp[i][j] = Math.max(price[i-1] + dp[i][j-length[i-1]], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        print(dp);
        return dp[n][totalRod];
    }

    public static void print(int[][] dp) {
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main (String args[]) {

        int length[] = {1, 2, 3, 4, 5, 6, 7, 8};
        int price[] = {1, 5, 8, 9, 10, 17, 17, 20};
        int totalRod = 8;

        System.out.println(rodCutting(length, price, totalRod));
    }
}
