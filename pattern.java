
public class pattern{
    public static void hollow_rectangle(int totRows, int totCols) {
        //outer loop
        for(int i=1; i<=totRows; i++) {
            // inner rows
            for(int j=1; j<=totCols; j++) {
                //cell i,j
                if(i == 1 || i == totRows || j ==1 || j == totCols) {
                    // boundary cell condition
                    System.out.print("*");

                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    public static void inverted_rotated_half_pyramid(int n) {
        for(int i=1; i<=n; i++){
            // spaces
            for( int j=1; j<=n-i; j++) {
                System.out.print(" ");
            }
            // stars
            for(int j=1; j<=i; j++) {
                System.out.print("*");
            }
            System.out.println();
        } 
        
    }
    public static void inverted_half_pyramid_with_numbers(int n) {
        //outer loop
        for(int i=1; i<=n; i++) {
            //inner loop
            for(int j=1; j<=n-i+1; j++) {
                System.out.print(j+ " ");
            }
            System.out.println();
        }
    }
    public static void floyds_triangle(int n) {
        //outer loop
        int counter=1;
        for(int i=1; i<=n; i++) {
            //inner loop
            for(int j=1; j<=i; j++) {
                System.out.print(counter+ " ");
                counter++;
            }
            System.out.println();
        }
    }
    public static void zero_one_pattern (int n) {
        for(int i=1; i<=n; i++) {
            for (int j=1; j<=i; j++) {
                if((i+j) % 2== 0) {
                    //even
                    System.out.print("1");
                } else {
                    // odd
                    System.out.print("0");
                }
            }
            System.out.println();
        }
    } 
    public static void butterfly(int n) {
        //outer loop of first half
        for(int i=1; i<=n; i++) {
            //stars - i
            for(int j=1; j<=i; j++) {
                System.out.print("*");
            }
            //spaces - 2 * (n-1)
            for(int j=1; j<=2*(n-i); j++) {
                System.out.print(" ");
            }
            //stars - i
            for(int j=1; j<=i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        //second half
        for(int i=n; i>=1; i--){
            //stars - i
            for(int j=1; j<=i; j++) {
                System.out.print("*");
            }
            //spaces - 2 * (n-1)
            for(int j=1; j<=2*(n-i); j++) {
                System.out.print(" ");
            }
            //stars - i
            for(int j=1; j<=i; j++) {
                System.out.print("*");
            }
            System.out.println();
            
        }
    }
    public static void solid_rhombus(int n) {
        for(int i=1; i<=n; i++){
            //spaces
            for(int j=1; j<=(n-i); j++) {
                System.out.print(" ");
            }
            //spaces
            for(int j=1; j<=n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void hollow_rhombus(int n) {
        for(int i=1; i<=n; i++) {
            // spaces
            for(int j=1; j<=(n-i); j++) {
                System.out.print(" ");
            }

            // hollow rectangle 
            for(int j=1; j<=n; j++) {
                if(i==1 || i==n || j==1 || j==n) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    public static void diamond(int n) {
        //1st half
        for(int i=1; i<=n; i++) {
            //spaces
            for(int j=1; j<=(n-i); j++) {
                System.out.print(" ");
            }
            //stars
            for(int j=1; j<=(2*i)-1; j++) {
                System.out.print("*");
            }
            System.out.println();

        }
        // second half
        for(int i=n; i>=1; i--) {
            for(int j=1; j<=(n-i); j++) {
                System.out.print(" ");
            }
            //stars
            for(int j=1; j<=(2*i)-1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void main(String args[]) {
       // hollow_rectangle(8, 6);
       //inverted_rotated_half_pyramid(8);
       //inverted_half_pyramid_with_numbers(5);
       //floyds_triangle(5);
      // zero_one_pattern(5);
      //butterfly(4);
      //solid_rhombus(5);
      //hollow_rhombus(10);
      diamond(4);

    }
}