import java.util.*;
public class hashMajorityEle{
    public static void main(String args[]) {
        int arr[] = {1, 3, 2, 5, 1, 3, 1, 5, 1};
        HashMap<Integer, Integer> map = new HashMap<>();

         for(int i=0; i<arr.length; i++) {

       //     if(map.containsKey(arr[i])) {
       //         map.put(arr[i], map.get(arr[i]) + 1); // arr[i] index pe map.get(arr[i])ka value and + 1
       //     } else {
       //          map.put(arr[i], 1);
       //      }

            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1); // agr key hoga to uska value m one add hoga nae to default value 0 hai to 0 m one add hoga
        }


        //Set<Integer> keySet = map.keySet();

        for(Integer key : map.keySet()) {
        //for(int key=0; key<map.keySet().size(); key++) {
            if(map.get(key) > arr.length/3) {
                System.out.println(key);
            }
        }
    }
}
