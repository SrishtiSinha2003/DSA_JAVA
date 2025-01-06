public class greedyLexico {
    public static void main(String args[]) {
        int n = 5;
        int k = 42;
        int kk = k-n;
        String s = "";
        for(int i=n-1; i>=0; i--) {
            if(kk>=25){
                s+='z';
                kk-=25;
            } else {
                s+=(char)('a'+kk);
                kk -= kk;
            }
        }
        String ans = "";
        for(int i=n-1; i>=0; i--) {
            ans+=s.charAt(i);
        }
        System.out.println(ans);
    }
}
