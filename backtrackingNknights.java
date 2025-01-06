public class backtrackingNknights {

    // Size of the chessboard
    static int BOARD_SIZE = 8;

    // Function to check if a move is valid on the chessboard
    public static boolean isValidMove(int row, int col, int[][] board) {
        return (row >= 0 && row < BOARD_SIZE && col >= 0 && col < BOARD_SIZE && board[row][col] == -1);
    }

    // Function to print the solution matrix
    public static void printSolution(int[][] board) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Recursive function to find the Knight's Tour
    public static boolean solveKTUtil(int row, int col, int moveNumber, int[][] board) {

        // Arrays to represent possible moves of a knight
        int[] ROW_MOVES = { 2, 1, -1, -2, -2, -1, 1, 2 };
        int[] COL_MOVES = { 1, 2, 2, 1, -1, -2, -2, -1 };

        // base case
        if (moveNumber == BOARD_SIZE * BOARD_SIZE) {
            // All cells are visited
            printSolution(board);
            return true;
        }

        for (int k = 0; k < 8; k++) {
            int nextRow = row + ROW_MOVES[k];
            int nextCol = col + COL_MOVES[k];

            if (isValidMove(nextRow, nextCol, board)) {
                // Mark the current move
                board[nextRow][nextCol] = moveNumber;

                // Recur for the next move
                if (solveKTUtil(nextRow, nextCol, moveNumber + 1, board)) {
                    return true;
                }

                // Backtrack if the current move doesn't lead to a solution
                board[nextRow][nextCol] = -1;
            }
        }

        return false;
    }

    // Function to solve the Knight's Tour problem
    public static void solveKT() {
        int[][] board = new int[BOARD_SIZE][BOARD_SIZE];

        // Initialize the board
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = -1;
            }
        }

        // Starting position
        int startRow = 0;
        int startCol = 0;

        // Mark the starting position
        board[startRow][startCol] = 0;

        // Start the recursion from the initial position
        if (!solveKTUtil(startRow, startCol, 1, board)) {
            System.out.println("No solution exists");
        }
    }

    // Main method to test the Knight's Tour
    public static void main(String[] args) {
        solveKT();
    }
}