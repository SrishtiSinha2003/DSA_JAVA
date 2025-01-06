public class oops{
    public static void main(String args[]) {
        Deer d = new Deer();
        d.eat();
       // Calculator calc = new Calculator();
        //System.out.println(calc.sum(1,2));
       // System.out.println(calc.sum((float)1.2,(float)2.3));
    }
}
class Animal {
    void eat() {
        System.out.println("eats anythimg");
    }
}
class Deer extends Animal {
    void eat () {
        System.out.println("eats grass");
    }
}
class Calculator {
    int sum(int a, int b) {
        return a + b;
    }
    float sum(float a, float b) {
        return a + b;
    }
}