import java.io.*;
import java.util.*;

public class Main {
    static int ans = 0;
    public static void dfs(int x, boolean[] seen, ArrayList<ArrayList<Integer>> g, int p){
        // If already seen, ignore
        if (seen[x]){
            return;
        }
        // Mark as seen
        seen[x] = true;
        p += 1;
        ans = Math.max(ans, p);
        // Go through neighboors dfs
        for (Integer n: g.get(x)){
            dfs(n, seen, g, p);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader f = new BufferedReader(new FileReader("moocast.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("moocast.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        //int M = Integer.parseInt(st.nextToken());
        //int ans = 0;
        ArrayList<ArrayList<Integer>> all = new ArrayList<>();
        ArrayList<ArrayList<Integer>> n = new ArrayList<>();
        // input
        for (int i = 0; i < N; i++){
            StringTokenizer str = new StringTokenizer(f.readLine());
            ArrayList<Integer> inp = new ArrayList<>();
            int x = Integer.parseInt(str.nextToken());
            int y = Integer.parseInt(str.nextToken());
            int r = Integer.parseInt(str.nextToken());
            inp.add(x);
            inp.add(y);
            inp.add(r);
            all.add(inp);
            n.add(new ArrayList<>());
        }

        // Adjacent list

        for (int i = 0; i < N; i++){
            int x = all.get(i).get(0);
            int y = all.get(i).get(1);
            int r = all.get(i).get(2);
            for (int j = 0; j < N; j++){
                if (i == j){
                    continue;
                }
                int x1 = all.get(j).get(0);
                int y1 = all.get(j).get(1);
                int r1 = all.get(j).get(2);
                if (Math.abs(x1 - x) * Math.abs(x1 - x) + Math.abs(y1 - y) * Math.abs(y1 - y)  <= r * r || Math.abs(x1 - x) * Math.abs(x1 - x) + Math.abs(y1 - y) * Math.abs(y1 - y)  <= r1 * r1){
                    n.get(i).add(j);
                }
            }
        }


        // start dfs
        for (int i = 0; i < N; i++) {
            int p = 0;
            boolean[] seen = new boolean[N];
//            if (seen[i]){
//                continue;
//            }
            dfs(i, seen, n, p);
        }

        out.println(ans);
        out.close();
        System.exit(0);
    }
}