public class backtrackingRatMaze{

    public static boolean checker(int maze[][], int i, int j, int sol[][]) {
        int n = maze.length;
        // check for out of bound
        if (i < 0 || j < 0 || i >= n || j >= n) {
            return false;
        }
        // check for path is available in maze and path not repeated in solution matrix
        if (maze[i][j] == 0 || sol[i][j] == 1) {
            return false;
        }
        return true;
    }

    public static void solve(int maze[][], int i, int j, int sol[][]) {
        // base case
        int n = maze.length - 1;
        if (i == n && j == n) {
            PrintArray(sol);
            return;
        }
        // kaam
        // check right turn
        if (checker(maze, i, j + 1, sol)) {
            sol[i][j + 1] = 1; // update value
            solve(maze, i, j + 1, sol);
            sol[i][j + 1] = 0; // backtracking
        }

        // check left turn
        if (checker(maze, i, j - 1, sol)) {
            sol[i][j - 1] = 1; // update value
            solve(maze, i, j - 1, sol);
            sol[i][j - 1] = 0; // backtracking
        }

        // check down turn
        if (checker(maze, i + 1, j, sol)) {
            sol[i + 1][j] = 1; // update value
            solve(maze, i + 1, j, sol);
            sol[i + 1][j] = 0; // backtracking
        }

        // check up turn
        if (checker(maze, i - 1, j, sol)) {
            sol[i - 1][j] = 1; // update value
            solve(maze, i - 1, j, sol);
            sol[i - 1][j] = 0; // backtracking
        }
    }

    public static void PrintArray(int array[][]) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        int maze[][] = { { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 0, 1, 0, 0 },
                { 1, 1, 1, 1 } };
        int sol[][] = new int[4][4];
        for (int i = 0; i < sol.length; i++) {
            for (int j = 0; j < sol.length; j++) {
                sol[i][j] = 0;
            }
        }
        sol[0][0] = 1; // starting point
        solve(maze, 0, 0, sol);
    }
}