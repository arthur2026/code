import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        // System.out.println("Working Directory = " + System.getProperty("user.dir"));
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] g = new int[n][2];
        int[][] xs = new int[n][2];
        int[][] ys = new int[n][2];
        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(r.readLine());
            xs[i] = new int[]{Integer.parseInt(st.nextToken()), i};
            ys[i] = new int[]{Integer.parseInt(st.nextToken()), i};
        }
        Arrays.sort(xs, (x1, x2) -> x1[0] - x2[0]);
        for (int i = 0; i < n; ++i) {
            g[xs[i][1]][0] = i;
        }
        Arrays.sort(ys, (x1, x2) -> x1[0] - x2[0]);
        for (int i = 0; i < n; ++i) {
            g[ys[i][1]][1] = i;
        }
        int[][] ps = new int[n + 1][n + 1];
        for (int i = 0; i < n; ++i) {
            ++ps[g[i][0] + 1][g[i][1] + 1];
        }
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                ps[i][j] += ps[i - 1][j] + ps[i][j - 1] - ps[i - 1][j - 1];
                System.out.print(ps[i][j] + " ");
            }
            System.out.println();
        }
        int ans = n + 1;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int t = Math.min(g[i][0], g[j][0]), b = Math.max(g[i][0], g[j][0]);
                int l = Math.min(g[i][1], g[j][1]), ri = Math.max(g[i][1], g[i][1]);
                // (0, 0, t, ri) * (l, b, ri, n - 1)
                int x = (ps[t + 1][ri + 1] - ps[t + 1][0] - ps[0][ri + 1] + ps[0][0]);
                int y = (ps[n][ri + 1] - ps[b][ri + 1] - ps[n][l] + ps[b][l]);
                System.out.println(l + " " + ri + " " + t + " " + b + " " + x + " " + y);
                ans += x * y;
            }
        }
        out.println(ans);
        out.close();
        System.exit(0);
    }
}
