public class Strings {
    public static void printLettersstrings(String str) {
        for(int i=0; i<str.length(); i++) {
            System.out.print(str.charAt(i) + " ");
        }
        System.out.println();
    }  
    
    public static boolean isPalindrome(String str) {
        for(int i=0;i<str.length()/2; i++) {
            int n = str.length();
            if(str.charAt(i) != str.charAt(n-1-i)) {
              // not a palindrome
              return false;  
            }
        }
        return true;
    }

    public static float getShortestPath(String path) {
        int x = 0; int y = 0;

        for(int i=0; i<path.length(); i++) {
            char dir = path.charAt(i);
            //south
            if(dir == 'S') {
                y--;
            }
            //north
            else if(dir == 'N') {
                y++;
            }
            //west
            else if(dir == 'W') {
                x--;
            }
            //east
            else{
                x++;
            }
        }

        int X2 = x*x;
        int Y2 = y*y;
        return (float)Math.sqrt(X2 + Y2);
    }

    public static java.lang.String subString(String str, int si, int ei) {
        java.lang.String substr = "";
        for(int i=si; i<ei; i++) {
            substr += str.charAt(i);
        }
        return substr;
    }

    public static String toUpperCase(String str) {
        StringBuilder sb = new StringBuilder("");

        boolean ch = Character.isUpperCase(str.charAt(0));
        sb.append(ch);
        for(int i=1; i<str.length(); i++ ) {
            if(str.charAt(i) == ' ' && i<str.length()-1) {
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            } else {
                sb.append(str.charAt(i));
            }
        }

        return sb.toString();
    }

    public static String compress(String str) {
        String newStr = "";
        for(int i=0;i<str.length(); i++) {
            Integer count = 1;
            while(i<str.length()-1 && str.charAt(i) == str.charAt(i+1)) {
             count ++;
             i++;   
            }
            newStr += str.charAt(i);
            if(count > 1) {
                newStr += count.toString();
            }
        }
        return newStr;
    }
    public static void main(String args[]) {
        String str = "aaabbbcccddeeeeeffgg";
        System.out.println(str);




       // String str = "hi, i am varsha";
        //System.out.println(toUpperCase(str));
    }



  //   public static void main(String args[]) {
      //  String fruits [] = {"apple", "mango", "banana"};
//
      //  String largest = fruits[0];
     //   for(int i=1; i<fruits.length; i++) {
        //    if(largest.compareTo(fruits[i]) < 0){
         //       largest = fruits[i];
         //   }
 
     //   }   
        
   //     System.out.println(largest);
//}

        //substring
       // String str = "HelloWorld";
      // System.out.println(str.substring(0,5));
      //  System.out.println(subString(str, 0, 5));







      //  String path = "WNEENESENNN";
       // System.out.println(getShortestPath(path));

      // String fullName = "SAIFF";
      // System.out.println(fullName.length());

       //concatenation
       // String firstName = "Saiff";
       // String lastName = "Varsha";
       // String fullName = firstName + " " + lastName;
       // System.out.println(fullName.charAt(3));
      // printLettersstrings(fullName);

     // String str = "saiff";
     // System.out.println(isPalindrome(str));

    }


