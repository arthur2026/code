import java.io.*;
import java.util.*;

public class Main {

    public static class Cow {
        public int x;
        public int y;
        public int p;

        public Cow(int x, int y, int p) {
            this.x = x;
            this.y = y;
            this.p = p;
        }

        public String toString() {
            return this.x + " " + this.y + " " + this.p;
        }
    }
    public static int dfs(int i, boolean[] seen, ArrayList<ArrayList<Integer>> g) {
        if (seen[i]) {
            return 0;
        }
        seen[i] = true;
        int r = 1;
        int N = seen.length;

        for (int j: g.get(i)) {
            r += dfs(j, seen, g);
        }

        return r;
    }

    public static double dist(Main.Cow a, Main.Cow b) {
        int dx = a.x - b.x;
        int dy = a.y - b.y;
        return Math.sqrt((double)(dx * dx + dy * dy));
    }

    public static void main(String[] args) throws Exception {
        BufferedReader f = new BufferedReader(new FileReader("moocast.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("moocast.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        Main.Cow[] cows = new Main.Cow[N];
        Set<Integer> d = new HashSet();
        int ans = 0;

        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(f.readLine());
            cows[i] = new Main.Cow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            d.add(i);
        }

        ArrayList<ArrayList<Integer>> g =  new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < N; ++i) {
            g.add(new ArrayList<>());
            for(int j = 0; j < N; ++j) {
                double t = dist(cows[i], cows[j]);
                if (t <= (double)cows[i].p) {
                    g.get(i).add(j);
                }
            }
        }

        for (int i = 0; i < N; ++i) {
            boolean[] seen = new boolean[N];
            int t = dfs(i, seen, g);
            // System.out.println(i + " " + t);
            ans = Math.max(ans, t);
        }

        out.println(ans);
        out.close();
        System.exit(0);
    }
}

