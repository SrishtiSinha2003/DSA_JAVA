public class Interface {
    public static void main (String args []) {
        Queen q = new Queen();
        q.moves();
    }
}

interface ChessPlayer {
    void moves ();
}

class Queen implements ChessPlayer {
  public void moves() {
        System.out.println("up, down, right, left, diagonal");
    }
}
class rook implements ChessPlayer {
    public void moves() {
          System.out.println("up, down, right, left");
    }
}

class king implements ChessPlayer {
    public void moves() {
          System.out.println("up, down, right, left, diah=ginal by one step");
    }
}