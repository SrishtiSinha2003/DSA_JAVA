public class super keyword {
    public static void main (String args[]) {
        Horse h = new Horse();
    }
}

class Animal {
    animal() {
        System.out.println("animal constructor is callled ");
    }
}

class Horse extends Animal {
    Horse () {
        System.out.println("horse constructor is called");
    }
}

