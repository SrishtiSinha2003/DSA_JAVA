public class greedyMaxBalString {
    public static void main(String args[]) {
        String s = "LRRRRLLRLLRL";
            int n = 12;
            int l=0;
            int r=0;
            int ans=0;
            int i;
            for(i=0; i<n; i++) {
                if(s.charAt(i)=='L') {
                    l++;
                } else {
                    r++;
                } if(l==r) {
                    ans++;
                    l=0;
                    r=0;
                }
            }
            System.out.println(ans);
        }
}
