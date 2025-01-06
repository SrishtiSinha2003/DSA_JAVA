import java.util.*;

public class hashPair {

public static int[] twoSum(int[]arr, int target) { 

    Map<Integer,Integer> visited = new HashMap<>(); 
    for(int i=0; i < arr.length; i++) { 

        //diff = given target - number given at ith index

        int diff = target - arr[i]; 

        // check if found difference is present in the MAP list 

        if(visited.containsKey(diff)) { 

            //if difference in map matches withthe ith index element in array

            return new int[] {i,visited.get(diff)};
        }

        //add arr element in map to match withfuture element if forms a pair 

        visited.put(arr[i],i);
    }
    //if no matches are found
    return new int[] {0,0};
}
public static void main(String args[]) {
    int arr[] = { 1, 4, 45, 6, 10, 8 };
    int target = 16;
    int[] result = hashPair.twoSum(arr, target);

    System.out.println("pair : [ " + result[0] + " , " + result[1] + "]");
}
}
