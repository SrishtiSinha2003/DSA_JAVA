public class binary {
    public static int binarysearch(int numbers[], int key) {
        int start = 0, end = numbers.length-1;
    
        while(start <= end ) {
        int mid = (start + end) / 2;
          if(numbers[mid] == key) { //found
            return mid;
          }
          if(numbers[mid] < key) { //right
           start = mid+1;
    
          }else { //end
            end = mid-1;
    
       }
     
       }
       return -1;
   }
   public static void main (String args[]) {
       int numbers[] = {8, 14, 16, 19, 30, 26, 25};
       int key = 25;
       System.out.println("index : " + binarysearch(numbers, key));
   }   
}