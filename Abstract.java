public class Abstract {
    public static void main (String args[]) {
        Horse h = new Horse();
        h.eat();
        h.walk();

       System.out.println(h.color);
    }
}

abstract class Animals {
    String color;

    Animals() {
        color = "brown";
    }
    void eat () {
        System.out.println("animal eats");    // non abstract method
    }

    abstract void walk(); // abstract method doesnt have sopln line
}

class Horse extends Animal {
    public String color;
    void changeColor() {
        color = "dark brown";
    }
    void walk() {
        System.out.println("walks on 4 legs");
    }
}

class Chicken extends Animal {
    void changeColor () {
    }
    void walk() {
        System.out.println("walks on 2 legs");
    }
}