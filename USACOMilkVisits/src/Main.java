import java.io.*;
import java.util.*;

public class Main {
    public static void bfs(int x, int id,int[] seen, ArrayList<ArrayList<Integer>> g, String t){
        // If already seen, ignore
//        if (seen[x] != 0){
//            return;
//        }
        seen[x] = id;
        Deque<Integer> q = new ArrayDeque<>();
        q.addLast(x);
        while (q.size() != 0) {
            x = q.removeFirst();
            for (Integer n: g.get(x)) {
                if (t.charAt(x) != t.charAt(n)) {
                    continue;
                }
                if (seen[n] != 0) {
                    continue;
                }
                seen[n] = id;
                q.addLast(n);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        // write your code here
        // System.out.println("Working Directory = " + System.getProperty("user.dir"));
        BufferedReader f = new BufferedReader(new FileReader("milkvisits.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        //ArrayList<String> p = new ArrayList<>();
        String ans = "";
        String t = f.readLine();
        ArrayList<ArrayList<Integer>> c = new ArrayList<>();
        for (int i = 0; i < N; i++){
            c.add(new ArrayList<>());
        }
        for (int i = 0; i < N - 1; i++){
            StringTokenizer str = new StringTokenizer(f.readLine());
            int x = Integer.parseInt(str.nextToken()) - 1;
            int y = Integer.parseInt(str.nextToken()) - 1;
            c.get(x).add(y);
            c.get(y).add(x);
        }
        // farmer paths
        // farmer preference (milk)
        int[] seen = new int[N];
        int id = 1;
        for (int i = 0; i < N; i++) {
            if (seen[i] != 0) {
                continue;
            }
            bfs(i, id, seen, c, t);
            id += 1;
        }
        for (int i = 0; i < M; i++){
            StringTokenizer string = new StringTokenizer(f.readLine());
            int o = Integer.parseInt(string.nextToken()) - 1;
            int w = Integer.parseInt(string.nextToken()) - 1;
            String r = string.nextToken();
            if (seen[o] == seen[w] && r.charAt(0) != t.charAt(o)){
                ans += "0";
            } else {
                ans += "1";
            }
        }


        out.println(ans);
        out.close();
        System.exit(0);
    }
}