import java.util.*;

public class Q2_Simplify_Path {

    public static String simplifyPath(String path) {
        String[] paths = path.split("/"); // study .split function
        Stack<String> stk = new Stack<>();

        for (int i = 0; i < paths.length; i++) {
            if (paths[i].equals(".")) {
                // current directory
                continue;
            } else if (paths[i].equals("..")) {
                // previous directory
                if (stk.size() > 0) {
                    stk.pop();
                }
            } else {
                stk.push(paths[i]); // push data onto stack
            }
        }

        String res = ""; // empty string
        while (stk.size() > 0) {
            String folder = stk.pop();
            if (!res.isEmpty()) {
                // add forward slash olny if res is not empty
                res = "/" + res;
            }
            res = folder + res;
        }
        if (res.length() == 0) {
            return "/";
        }
        return res;
    }

    public static void main(String[] args) {
        String path = "/c/../D/Downloads/../E/./../Documents/";
        System.out.println(simplifyPath(path));
    }
}