
public class arraysex{
  public static void maxsubarrays(int numbers[]) {
    int currSum = 0;
    int maxSum = Integer.MIN_VALUE;
    int prefix [] = new int [numbers.length];

    prefix[0] = numbers[0];

    //calculate prefix

    for(int i=1; i<prefix.length; i++) {
      prefix[i] = prefix[i-1] + numbers[i];

    }
    


        for(int i=0; i<numbers.length; i++) {
      int start = i;
      for(int j = i+1; j<numbers.length; j++) {
        int end = j;

        currSum = start==0?  prefix[end] : prefix[end] - prefix[start-1];



       // currSum = 0;
        //for(int k = start; k<=end; k++) { //print
          //currSum += numbers[k];
            // subarray sum
       // }
       // System.out.println(currSum);
        if(maxSum < currSum) {
          maxSum = currSum;
        }
        
      }
      
    }
    System.out.println("max summ = " + maxSum);
  }







  //public static void printpairs(int numbers[]) {
    //int tp =0;
    //for(int i=0; i<numbers.length; i++) {
      //int curr = numbers[i]; // 2, 4, 6, 8, 10
      //for(int j=i+1; j<numbers.length; j++) {
        //System.out.print("(" + curr + ","   + numbers[j]   + ")");
        //tp++;
      //}
     // System.out.println();

   // }
    //System.out.println(" total pairs= " + tp);
  //}






 // public static void reverse(int numbers[]) {
   // int first = 0, last = numbers.length-1;

    //while(first<last) {

      //swap

      //int temp = numbers[last];
      //numbers[last] = numbers[first];
      //numbers[first] = temp;
      //first++;
     // last--;


  //  }
//  }






 // public static int binarysearch(int numbers[], int key) {
   // int start = 0, end = numbers.length-1;

    //while(start <= end ) {
      //int mid = (start + end) / 2;

      //comparison
      //if(numbers[mid] == key) { //found
        //return mid;
      //}
      //if(numbers[mid] < key) { //right
        //start = mid+1;

      //}else { //end
        //end = mid-1;

      //}
 
    //}
    //return -1;
  //}
 



 // public static int largest(int numbers[]) {
   // int largest = Integer.MIN_VALUE; // - INFINITY
    //int smallest = Integer.MAX_VALUE; // + infinity
    //for(int i = 0; i<numbers.length; i++) {
      //if(largest < numbers[i]) {
        //largest = numbers[i]; 
      //} 
     // if(smallest > numbers[i]) {
        //smallest = numbers[i];
     // }
   // }
   // System.out.println("smallest value is :"  +    smallest);
    //return largest;
  
  



 // public static int linearsearch(int numbers[], int key) {
   // for(int i =0; i<numbers.length; i++) {
     // if(numbers[i] == key) {
       // return i;
      //}
    //}
    //return -1;



 // }


   // public static void update(int marks[]) {
      //  for(int i=0; i<marks.length; i++) {
        //    marks[i] = marks[i] + 1;
        //}
    //}
    //public static void main(String args[]) {
       // int marks[] = { 97, 98, 99};
      //  update(marks);
        // to print marks
        //for(int i=0; i<marks.length; i++) {
          //  System.out.print(marks[i] + " ");
        //}
        //System.out.println();
    //}


    public static int kadanes(int numbers[]) {
      int ms = Integer.MIN_VALUE;
      int cs = 0;
      for(int i=0; i<numbers.length; i++) {
        cs = cs + numbers[i];
        if(cs < 0) {
          cs = 0;
        }
        ms = Math.max(cs, ms);
        cs = Math.max(cs,ms);

      }
      System.out.println("our max subarray sum is : " + ms);
      return cs;


    }

    
    public static void main(String args[]){
      int numbers[] = {-2, -3,  -1, -2,  -3};
      kadanes(numbers);


      
    }
  }




      //printpairs(numbers);



      //reverse(numbers);
      //for(int i =0; i<numbers.length; i++){
        //System.out.print(numbers[i]+ " ");
      


     // System.out.println();




      //int key = 900;
      //System.out.println("index for the key is : " + binarysearch(numbers, key));



     // System.out.println("largest value is : " + largest(numbers));




    
//  }
      
  




     // int key = 30;
      //int index = linearsearch(numbers, key);
      //if(index == -1) {
       // System.out.println("not found");
     // } else {
       // System.out.println("key is at index : " + index);
      //}





    

