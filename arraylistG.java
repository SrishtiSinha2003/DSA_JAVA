import java.util.*;

public class arraylistG {
    public static void main(String[] args) {
        // Multi Dimentional ArrayList
        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        // Single ArrayList
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();

        // insert elements
        for (int i = 1; i <= 5; i++) {
            list1.add(i * 1); // 1 2 3 4 5
            list1.add(i * 2); // 2 4 6 8 10
            list1.add(i * 3); // 3 6 9 12 15
        }

        // add in mainList
        mainList.add(list1);
        mainList.add(list2);
        mainList.add(list3);

        // Print Main list
        System.out.println(mainList);
        for (int i = 0; i < mainList.size(); i++) {
            // get index on main list
            ArrayList<Integer> currList = mainList.get(i);
            for (int j = 0; j < currList.size(); j++) {
                System.out.print(currList.get(j) + " ");
            }
            System.out.println();
        }
    }
}