import java.util.*;
public class greedyCoins {
    public static void main(String args[]) {
        Integer coins[] = {1, 2, 5, 10, 20, 50, 100, 500, 2000};

        Arrays.sort(coins, Comparator.reverseOrder()); // arrays.sort() works with array of objects such as integer not with primitive array like int

        int countOfCoins = 0; //variable to store no of coins
        int amount = 890;
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=0; i<coins.length; i++) {
            if(coins [i] <= amount) {
                while(coins[i] <= amount) { //tb tk hi wo coin use hoga jb tk wo amount se chota hai
                    countOfCoins++;
                    ans.add(coins[i]); //coin ko add kiye
                    amount -= coins[i]; //amount m se coin ka value minus kr denge
                }
            }
        }
        System.out.println("total (min) coins used = " + countOfCoins);

        //print the coins and notes used

        for(int i=0; i<ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }
}
