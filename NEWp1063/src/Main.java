import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // input
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());

        // initiate
        int n = Integer.parseInt(st.nextToken());
        // ans starts with n + 1 because each individual as a group + all of them in a group
        long ans = n + 1;

        // Lists
        int[][] g = new int[n][2];
        int[][] xs = new int[n][2];
        int[][] ys = new int[n][2];

        // initiate lists
        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(r.readLine());
            xs[i] = new int[]{Integer.parseInt(st.nextToken()), i};
            ys[i] = new int[]{Integer.parseInt(st.nextToken()), i};
        }

        // Sort
        Arrays.sort(xs, (x1, x2) -> x1[0] - x2[0]);
        Arrays.sort(ys, (x1, x2) -> x1[0] - x2[0]);

        // Graph
        for (int i = 0; i < n; ++i) {
            g[xs[i][1]][0] = i;
            g[ys[i][1]][1] = i;
        }

        // Make Prefix Sum
        // initiate the list
        int[][] ps = new int[n + 1][n + 1];

        // Prefix sum
        for (int i = 0; i < n; ++i) {
            ++ps[g[i][0] + 1][g[i][1] + 1];
        }

        // Start from i = 1, j = 1 so i-1 and j-1 cannot IndexOutOfBounds
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                ps[i][j] += ps[i - 1][j] + ps[i][j - 1] - ps[i - 1][j - 1];
            }
        }
        // START

        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int t = Math.min(g[i][0], g[j][0]);
                int b = Math.max(g[i][0], g[j][0]);
                int l = Math.min(g[i][1], g[j][1]);
                int ri = Math.max(g[i][1], g[j][1]);
                // Logic :
                // (0, l, t, ri) * (b, l, n - 1, ri)

                int x = (ps[t + 1][ri + 1] - ps[t + 1][l] - ps[0][ri + 1] + ps[0][l]);
                int y = (ps[n][ri + 1] - ps[n][l] - ps[b][ri + 1] + ps[b][l]);

                ans += x * y;
            }
        }

        // END
        // PRINT
        out.println(ans);
        out.close();
        System.exit(0);
    }
}