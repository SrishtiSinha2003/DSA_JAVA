public class greedySplit {
    static int ans;
    public static void solve(int a[], int n, int k, int i, int sum, int maxsum) {
        if(k==1) {
            maxsum = Math.max(maxsum, sum);
            sum = 0;
            for(i=1; i<n; i++) {
                sum += a[i];
            }
            maxsum = Math.max(maxsum, sum);
            solve(a, n, k-1, i+1, sum, maxsum);
        }
    }
    public static void main(String args[]) {
        int arr[] = {1, 1, 2};
        int k = 2;
        int n = 3;
        solve(arr, n, k, 0, 0, 0);
        System.out.println("the ans is : " + ans);
    }
}
