import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        StringTokenizer str = new StringTokenizer(br.readLine());
        String ans = "";
        int[] s = new int[m];
        for (int i = 0; i < m; i++){
            s[i] = Integer.parseInt(str.nextToken());
        }

        TreeSet<Integer> stops = new TreeSet<>();
        TreeMap<Integer, Integer> gaps = new TreeMap<>();

        stops.add(0);
        stops.add(n);
        gaps.put(n, gaps.getOrDefault(n, 0) + 1);

        for (int i = 0; i < m; i++){
            int x = stops.lower(s[i]), y = stops.higher(s[i]), gap = y - x, stop = s[i];
            int gapL = stop - x, gapR = y - stop;
            stops.add(stop);
            Integer t = gaps.get(gap);
            if (t == 1){
                gaps.remove(gap);
            } else {
                gaps.put(gap, t - 1);
            }
            gaps.put(gapL, gaps.getOrDefault(gapL, 0) + 1);
            gaps.put(gapR, gaps.getOrDefault(gapR, 0) + 1);
//            if (lh.contains(x) || lh.contains(y)){
//                ans[i] = pans;
//                ans[i - 1] = 0;
//            }
//            lh.add(x);
//            lh.add(y);
//            stops.add(s[i]);
//            if (i > 0){
//                int temp1 = Math.max(ans[i - 1], s[i] - x);
//                int temp2 = Math.max(ans[i - 1], y - s[i]);
//                ans[i] = Math.max(temp1, temp2);
//                pans = ans[i];
//            } else{
//                ans[i] = Math.max(ans[i], s[i] - x);
//                ans[i] = Math.max(ans[i], y - s[i]);
//            }
            ans += gaps.lastKey() + " ";
        }
        System.out.println(ans);
    }
}