import java.io.*;
import java.util.*;

public class Main {

    public static int [] visit(int l, int j, boolean[][] seen, String[] g) {
        //pre

        int N = seen.length;
        int[] ans = new int[2];
        Deque<int[]> st = new ArrayDeque<int[]>();
        st.addLast(new int[]{l, j});

        // initiate

        while (st.size() != 0) {
            // LOOP
            int[] t = st.removeFirst();
            l = t[0];
            j = t[1];
            ans[0] += 1;
            for (int[] d : new int[][]{{l + 1, j}, {l - 1, j}, {l, j - 1}, {l, j + 1}}) {

                // pre check
                int ni = d[0];
                int nj = d[1];
                if (ni < 0 || ni >= N || nj < 0 || nj >= N) {
                    ans[1] += 1;
                    continue;
                }
                // Blob
                if (g[ni].charAt(nj) != '#') {
                    ans[1] += 1;
                    continue;
                }

                // seen?
                if (seen[ni][nj]) {
                    continue;
                }

                // set seen
                seen[ni][nj] = true;
                st.addLast(new int[]{ni, nj});
            }
        }
        return ans;
    }

    public static void main(String[] args) throws Exception {
        // write your code here
        // System.out.println("Working Directory = " + System.getProperty("user.dir"));

        // input
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
        boolean[][] haveSeen = new boolean[N][N];

        // start
        for (int i = 0; i < N; i ++) {
            for (int j = 0; j < N; j ++) {

                if (g[i].charAt(j) != '#') {
                    continue;
                }

                // if already seen, continue
                if (haveSeen[i][j]) {
                    continue;
                }

                // set as Seen
                haveSeen[i][j] = true;

                int[] t = visit(i, j, haveSeen, g);
                if (t[0] > ans[0] || t[0] == ans[0] && t[1] < ans[1]) {

                    // ans
                    ans = t;
                }
            }
        }

        // PRINT
        out.println(ans[0] + " " + ans[1]);
        out.close();
        System.exit(0);
    }
}