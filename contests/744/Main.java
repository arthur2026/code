import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        // System.out.println("Working Directory = " + System.getProperty("user.dir"));
        BufferedReader in = new BufferedReader(new FileReader("art.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("art.out")));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] g = new int[n][n];
        Set<Integer> colors = new HashSet<>();
        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < n; ++j) {
                g[i][j] = Integer.parseInt(st.nextToken());
                if (g[i][j] != 0) {
                    colors.add(g[i][j]);
                }
            }
        }
        int m = colors.size();
        Integer[] d = colors.toArray(new Integer[0]);
        Map<Integer, Integer> h = new HashMap<>();
        for (int i = 0; i < m; ++i) {
            h.put(d[i], i);
        }
        int[][] b = new int[m][4]; // x_min, x_max, y_min, y_max
        for (int i = 0; i < m; ++i) {
            b[i] = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE};
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (g[i][j] == 0) {
                    continue;
                }
                int idx = h.get(g[i][j]);
                b[idx][0] = Math.min(b[idx][0], i);
                b[idx][1] = Math.max(b[idx][1], i);
                b[idx][2] = Math.min(b[idx][2], j);
                b[idx][3] = Math.max(b[idx][3], j);
            }
        }
        int[][] a = new int[n + 1][n + 1];

        for (int i = 0; i < m; ++i) {
            a[b[i][0]][b[i][2]] += 1;
            a[b[i][1] + 1][b[i][3] + 1] += 1;
            a[b[i][0]][b[i][3] + 1] += -1;
            a[b[i][1] + 1][b[i][2]] += -1;
        }
        int[][] ps = new int[n + 1][n + 1];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                ps[i + 1][j + 1] = a[i][j] + ps[i][j + 1] + ps[i + 1][j] - ps[i][j];
            }
        }
        int ans = n * n;
        boolean[] r = new boolean[m];

        if (m == 1) {
            ans -= 1;
        }
        else {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    int c = g[i][j];
                    if (c == 0) {
                        continue;
                    }
                    int idx = h.get(c);
                    if (r[idx]) {
                        continue;
                    }
                    if (ps[i + 1][j + 1] > 1) {
                        r[idx] = true;
                    }
                }
            }
            for (int i = 0; i < m; ++i) {
                if (r[i]) {
                    ans -= 1;
                }
            }
        }
        out.println(ans);
        out.close();
        System.exit(0);
    }
}
