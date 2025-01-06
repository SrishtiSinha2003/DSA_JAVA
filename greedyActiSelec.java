import java.util.*;
public class greedyActiSelec {
    public static void main(String args[]) {
        // array for start and end
        int start[] = {1, 3, 0, 5, 8, 5};
        int end[] = {2, 4, 6, 7, 9, 9};

        //sorting
        int activities[][] = new int [start.length][3]; // 2D array of 3x3 column
        for(int i=0; i<start.length; i++) {
            activities[i][0] = i;             // index at 0th column
            activities[i][1] = start[i];      // start ar 1st column
            activities[i][2] = end[i];        // end at 2nd coulmn
        }
        
        //lambda function -> shortform of a function in java which helps in sorting in 2D array
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2])); // sorting on the basis of column 2 ie end time

        //end time sorted
        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        //1st activity
        maxAct = 1;

        //ans.add(0); //1st activity ko add kr diye 0 index wala

        ans.add(activities[0][0]); // 1st activity of 0 index add hua

        //int lastEnd = end[0]; // ending time

        int lastEnd = activities[0][2]; // end time of the activities stored in column 2

        for(int i=1; i<end.length; i++) {

           // if(start[i] >= lastEnd) {

            if(activities[i][1] >= lastEnd) {

                // select the activity
                maxAct++;

                //ans.add(i);

                ans.add(activities[i][0]);

                //lastEnd = end[i]; // end time hogya last activity jo add hua uska end time

                lastEnd = activities[i][2];
            }
        }
        System.out.println("max activities = " + maxAct);
        for(int i=0; i<ans.size(); i++) {
            System.out.print("A" + ans.get(i) + " ");
        }
    }
}
