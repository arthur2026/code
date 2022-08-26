import java.io.*;
import java.util.*;

public class Main {
    public static boolean check(int[] cid, int mid, ArrayList<ArrayList<int[]>> c){
        int[] cid2 = new int[cid.length];
        int id = 1;
        for (int i = 0; i < cid2.length; i++){
            if (cid2[i] != 0){
                continue;
            }
            cid2[i] = id;
            Deque<Integer> q = new ArrayDeque<>();
            q.addLast(i);
            while (q.size() != 0){
                int p = q.removeFirst();
                for (int[] j: c.get(p)){
                    if (cid2[j[0]] != 0){
                        continue;
                    }
                    if (j[1] < mid){
                        continue;
                    }
                    cid2[j[0]] = id;
                    q.addLast(j[0]);
                }
            }
            id += 1;
        }
        Map<Integer, Integer> h = new HashMap<>();
        for (int i = 0; i < cid.length; i++){
            if (h.containsKey(cid[i])){
                if (h.get(cid[i]) != cid2[i]){
                    return false;
                }
            } else{
                h.put(cid[i], cid2[i]);
            }
        }
        return true;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader f = new BufferedReader(new FileReader("wormsort.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("wormsort.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] L = f.readLine().split(" ");
        ArrayList<ArrayList<int[]>> c = new ArrayList<>();
        for (int i = 0; i < N; i++){
            c.add(new ArrayList<>());
        }
        int l = Integer.MAX_VALUE;
        int r = Integer.MIN_VALUE;
        for (int i = 0; i < M; i++){
            StringTokenizer str = new StringTokenizer(f.readLine());
            int x = Integer.parseInt(str.nextToken()) - 1;
            int y = Integer.parseInt(str.nextToken()) - 1;
            int z = Integer.parseInt(str.nextToken());
            l = Math.min(l, z);
            r = Math.max(r, z);
            c.get(x).add(new int [] {y, z});
            c.get(y).add(new int [] {x, z});
        }
        ArrayList<ArrayList<Integer>> c2 = new ArrayList<>();
        for (int i = 0; i < N; i++){
            c2.add(new ArrayList<>());
        }
        for (int i = 0; i < N; i++){
            Integer t = Integer.parseInt(L[i]) - 1;
            if (i == t) {
                continue;
            }
            c2.get(i).add(t);
            c2.get(t).add(i);
        }
        int[] cid = new int[N]; int id = 1;
        for (int i = 0; i < N; i++){
            if (cid[i] != 0){
                continue;
            }
            cid[i] = id;
            Deque<Integer> q = new ArrayDeque<>();
            q.addLast(i);
            while (q.size() != 0){
                int p = q.removeFirst();
                for (int j: c2.get(p)){
                    if (cid[j] != 0){
                        continue;
                    }
                    cid[j] = id;
                    q.addLast(j);
                }
            }
            id += 1;
        }

        int ans = -1;
        if (id != N + 1) {
            while (l <= r) {
                int mid = (l + r + 1) / 2;
                if (check(cid, mid, c)) {
                    if (l == mid) {
                        ans = r;
                        break;
                    }
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
        }
        out.println(ans);
        out.close();
        System.exit(0);
    }
}