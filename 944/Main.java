import java.io.*;
import java.util.*;

public class Main {

    public static void dfs(int i, boolean[] seen, ArrayList<ArrayList<Integer>> g, int[][] cows, int[] b) {
        if (seen[i]) {
            return;
        }
        b[0] = Math.min(b[0], cows[i][0]);
        b[1] = Math.max(b[1], cows[i][0]);
        b[2] = Math.min(b[2], cows[i][1]);
        b[3] = Math.max(b[3], cows[i][1]);
        seen[i] = true;
        for (int j: g.get(i)) {

            dfs(j, seen, g, cows, b);
        }
    }
    public static void main(String[] args) throws Exception {
        // write your code here
        // System.out.println("Working Directory = " + System.getProperty("user.dir"));
        BufferedReader f = new BufferedReader(new FileReader("fenceplan.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("fenceplan.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] cows = new int[N][2];
        HashSet<Integer> all = new HashSet<>(0);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(f.readLine());
            cows[i][0] = Integer.parseInt(st.nextToken());
            cows[i][1] = Integer.parseInt(st.nextToken());
            all.add(i);
        }
        boolean[] seen = new boolean[N];

        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        for (int i = 0; i < N; i ++) {
            g.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < M; i ++) {
            st = new StringTokenizer(f.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            g.get(u).add(v);
            g.get(v).add(u);
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            if (seen[i]) {
                continue;
            }
            int[] b = new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE};
            dfs(i, seen, g, cows, b);
            ans = Math.min(ans,  2 * (b[3] - b[2]) +  2 * (b[1] - b[0]));
        }
        out.println(ans);
        out.close();
        System.exit(0);
    }
}
