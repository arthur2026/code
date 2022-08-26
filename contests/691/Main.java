import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        // System.out.println("Working Directory = " + System.getProperty("user.dir"));
        BufferedReader in = new BufferedReader(new FileReader("hps.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hps.out")));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] ps = new int[3][n + 2];
        int[][] ss = new int[3][n + 2];
        int[] g = new int[n];
        Map<String, Integer> h = new HashMap<>();
        h.put("H", 0);
        h.put("P", 1);
        h.put("S", 2);
        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(in.readLine());
            g[i] = h.get(st.nextToken());
        }
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < n; ++ j) {
                int d = i - g[j];
                if (Math.abs(d) == 2) {
                   d = -d;
                }
                if (d > 0) {
                    ps[i][j + 1] = 1;
                }
                ps[i][j + 1] += ps[i][j];
            }
            for (int j = n - 1; j >= 0; --j) {
                int d = i - g[j];
                if (Math.abs(d) == 2) {
                    d = -d;
                }
                if (d > 0) {
                    ss[i][j + 1] = 1;
                }
                ss[i][j + 1] += ss[i][j + 2];
            }
        }

        int ans = 0;
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                for (int k = 0; k < n + 1; ++k) {
                    ans = Math.max(ans, ps[i][k] + ss[j][k + 1]);
                }
            }
        }

        out.println(ans);
        out.close();
        System.exit(0);
    }
}
