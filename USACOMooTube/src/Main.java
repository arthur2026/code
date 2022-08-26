import java.io.*;
import java.util.*;

public class Main {
    public static int bfs(int x, int minR, int[] seen, ArrayList<ArrayList<int[]>> g){
        seen[x] = 1;
        Deque<Integer> q = new ArrayDeque<>();
        q.addLast(x);
        int ans = 0;
        while (q.size() != 0) {
            x = q.removeFirst();
            ans += 1;
            for (int[] t: g.get(x)) {
                int n = t[0];
                int r = t[1];
                if (minR > r) {
                    continue;
                }

                if (seen[n] != 0) {
                    continue;
                }
                seen[n] = 1;
                q.addLast(n);
            }
        }
        return ans - 1;
    }

    public static void main(String[] args) throws Exception {
        // write your code here
        // System.out.println("Working Directory = " + System.getProperty("user.dir"));
        BufferedReader f = new BufferedReader(new FileReader("mootube.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mootube.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        ArrayList<ArrayList<int[]>> g = new ArrayList<>();
        int ans = 0;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++){
            g.add(new ArrayList<>());
        }
        for (int i = 0; i < N - 1; i++){
            StringTokenizer str = new StringTokenizer(f.readLine());
            int x = Integer.parseInt(str.nextToken()) - 1;
            int y = Integer.parseInt(str.nextToken()) - 1;
            int r = Integer.parseInt(str.nextToken());
            g.get(x).add(new int[] {y, r});
            g.get(y).add(new int[] {x, r});
        }
        for (int i = 0; i < M; i++) {
            int[] seen = new int[N];
            StringTokenizer str = new StringTokenizer(f.readLine());
            int minRelevance = Integer.parseInt(str.nextToken());
            int COW = Integer.parseInt(str.nextToken()) - 1;
            out.println(bfs(COW, minRelevance, seen, g));
        }
        out.close();
        System.exit(0);
    }
}