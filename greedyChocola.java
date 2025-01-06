import java.util.*;
public class greedyChocola {
    public static void main (String args[]) {
        Integer costVer[] = {2, 1, 3, 1, 4}; //m-1
        Integer costHor[] = {4, 1, 2}; //n-1

        //sorting 
        Arrays.sort(costVer, Comparator.reverseOrder());
        Arrays.sort(costHor, Comparator.reverseOrder());

        int h = 0, v = 0; // h = horizontal cut and v = vertical cut
        int hp = 1, vp = 1;
        int cost = 0;

        while(h < costHor.length && v < costVer.length){
            //vertical cost < horizontal cost
            if(costVer[v] <= costHor[h]){ //horizontal cut
                cost += (costHor[h] * vp);
                hp++;
                h++;
            } else{ //vertical cut
                cost += (costVer[v] * hp);
                vp++;
                v++;
            }
        }
        // reman<ing horizontal and vertical cut
        while(h < costHor.length) {
            cost += (costHor[h] * vp);
            hp++;
            h++;
        }
        while(v < costVer.length) {
            cost += (costVer[v] * hp);
            vp++;
            v++;
        }
        System.out.println("min cost : " + cost);
    }
}
