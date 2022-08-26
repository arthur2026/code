import java.io.*;
import java.util.*;

public class Main {

    public static int [] visit(int i, int j, boolean[][] seen, String[] g) {
        int N = seen.length;
        int[] ans = new int[2];
        Deque<int[]> st = new ArrayDeque<int[]>();
        st.addLast(new int[]{i, j});
        while (st.size() != 0) {
            int[] t = st.removeFirst();
            i = t[0];
            j = t[1];
            ans[0] += 1;
            for (int[] d : new int[][]{{i + 1, j}, {i - 1, j}, {i, j - 1}, {i, j + 1}}) {
                int ni = d[0];
                int nj = d[1];
                if (ni < 0 || ni >= N || nj < 0 || nj >= N) {
                    ans[1] += 1;
                    continue;
                }

                if (g[ni].charAt(nj) != '#') {
                    ans[1] += 1;
                    continue;
                }
                if (seen[ni][nj]) {
                    continue;
                }
                seen[ni][nj] = true;

                st.addLast(new int[]{ni, nj});
            }
        }
        return ans;
    }

    public static void main(String[] args) throws Exception {
        // write your code here
        // System.out.println("Working Directory = " + System.getProperty("user.dir"));
        BufferedReader f = new BufferedReader(new FileReader("perimeter.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("perimeter.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        String[] g = new String[N];
        for (int i = 0; i <  N; i ++) {
            g[i] = f.readLine();
            // System.out.println();
        }
        int[] ans = new int[2];
        boolean[][] seen = new boolean[N][N];
        for (int i = 0; i < N; i ++) {
            for (int j = 0; j < N; j ++) {
                if (g[i].charAt(j) != '#') {
                    continue;
                }
                if (seen[i][j]) {
                    continue;
                }
                seen[i][j] = true;
                int[] t = visit(i, j, seen, g);
                if (t[0] > ans[0] || t[0] == ans[0] && t[1] < ans[1]) {
                    ans = t;
                }
            }
        }
        out.println(ans[0] + " " + ans[1]);
        out.close();
        System.exit(0);
    }
}
