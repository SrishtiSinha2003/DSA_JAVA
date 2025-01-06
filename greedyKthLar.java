public class greedyKthLar {
    public static void main(String args[]) {
        int l=-3;
        int r=3;
        int k=9; // k=5 means we have to find the 5th kargest odd no
        int x; // largest odd no ( k = 1 )
        int ans;
        if(r%2==1) {
            x=r;
        } else {
            x=r-1;
        }
        ans = x-(k-1)*2;
        if(ans<l) {
            System.out.println(0);
        } else {
            System.out.println(ans);
        }
    }
}
