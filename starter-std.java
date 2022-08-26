import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        // System.out.println("Working Directory = " + System.getProperty("user.dir"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int ans = 0;
        out.println(ans);
        out.close();
        System.exit(0);
    }
}
