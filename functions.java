
public class functions {
    public static void printhello() {
        System.out.println("hello");
    }
    public static int calculatesum( int num1, int num2) { //parameters or formal parameters // this is function definitions
        int sum = num1 + num2;
        return sum;
    }
    public static void swap(int a, int b) {
        //swap
        int temp = a;
        a = b;
        b = temp;
        System.out.println( "a = " + a);
        System.out.println( "b = " + b);


     }
     public static int multiply(int a, int b) {
        int product = a * b;
        return product;
     }
     public static int factorial(int n){
        int f=1;
        for( int i=1; i<=n; i++){
            f = f * i;

        }
        return f;
     }
     public static int bicoff( int n, int r) {
        int fact_n = factorial(n);
        int fact_r = factorial(r);
        int fact_nmr = factorial(n - r);

        int bicoff = fact_n / (fact_r * fact_nmr);
        return bicoff;
    } 
    // function to calculate
    //sum of two numbers 
   // public static int sum(int a, int b) {
        //return a + b;
   // }

    // function to calculate sum of three numbers 

   // public static int sum(int a, int b, int c) {
     //   return a + b + c;
   // }

    // function to calculate integer values

    public static int sum(int a, int b) {
        return a+b;
    }

    // function to calculate float values
     
    public static float sum( float a, float b){
        return a+b;
    }

   // public static boolean isPrime(int n) {
        //corner cases
        //2
      //  if(n == 2) {
       //     return true;

       // }
       // boolean isPrime = true;
        //for (int i=2; i<=n-1; i++) {
          //  if(n % i == 0) {
            //    isPrime = false;
              //  break;
            //}
         //}
        // return isPrime;
   // } 
    public static boolean isPrime(int n) {
        if(n == 2) {
            return true; 
        }
        for (int i=2; i<=Math.sqrt(n); i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static  void primesinrange(int n) {
        for( int i=2; i<=n; i++) {
            if(isPrime(i)){ //true
                System.out.print(i+ " ");
            }
        }
        System.out.println();
    }
    public static void bintodec(int binNum) {
        int myNum = binNum;
        int pow = 0;
        int decNum = 0;
        while(binNum > 0) {
            int lastDigit = binNum % 10;
            decNum = decNum + (lastDigit * (int) Math.pow(2, pow));

            pow++;
            binNum = binNum/10;
        }
        System.out.println("decimal of " + myNum + " = " + decNum);

    }
    public static void decTobin(int n) {
        int myNum = n;
        int pow = 0;
        int binNum = 0;

        while(n > 0) {
            int rem = n % 2;
            binNum = binNum + (rem * (int)Math.pow(10, pow));
            pow++;
            n = n/2;

        }
        System.out.println("binary form of " + myNum + " = " + binNum);
    }
    public static void main(String args[]) {
       //swap - values exchange
       //int a = 5;
      // int b = 10;
      // swap(a, b);

     // int a =3;
      //int b =5;
      //int prod = multiply(a, b);
      //System.out.println(" a * b =" + prod);

      // System.out.println(factorial(4));
     // System.out.println(bicoff(5, 2));

     //System.out.println(sum (3 , 5));
     //System.out.println(sum (3, 5, 4));
     
    //System.out.println(sum(3, 5));
    //System.out.println(sum(3.5f, 6.9f));

    //primesinrange(20);
    //bintodec(101);
    decTobin(8);

    }
}

