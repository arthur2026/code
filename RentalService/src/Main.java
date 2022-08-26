import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader f = new BufferedReader(new FileReader("rental.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("rental.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        long ans = 0;

        ArrayList<Integer> cows = new ArrayList<>();
        ArrayList<ArrayList<Long>> sell = new ArrayList<>();
        ArrayList<Integer> rent = new ArrayList<>();

        for (int i = 0; i < n; i++){
            cows.add(Integer.parseInt(f.readLine()));
        }
        Collections.sort(cows, Collections.reverseOrder());

        for (int i = 0; i < m; i++){
            ArrayList<Long> temp = new ArrayList<>();
            StringTokenizer str = new StringTokenizer(f.readLine());
            temp.add((long) Integer.parseInt(str.nextToken()));
            temp.add((long)Integer.parseInt(str.nextToken()));
            sell.add(temp);
        }
        Collections.sort(sell, (x1, x2) -> (int) (x2.get(1) - x1.get(1)));

        for (int i = 0; i < R; i++){
            rent.add(Integer.parseInt(f.readLine()));
        }
        Collections.sort(rent, Comparator.reverseOrder());

        // prefix sum no1
//        for (int i = 1; i < R; i++){
//            rent.set(i, rent.get(i-1) + rent.get(i));
//        }
        long[] ss = new long[n];
        for (int i = 0; i < R; ++i) {
            if (n - i - 1 >= 0) {
                ss[n - i - 1] = rent.get(i);
            } else {
                break;
            }
        }
        for (int i = n - 2; i >= 0; --i) {
            ss[i] += ss[i + 1];
        }
//
//        Collections.sort(rent, Collections.reverseOrder());

        // prefix sum no2
        int idx = 0;
        long[] p = new long[n];
        for (int i = 0; i < n; i++){
            int g = cows.get(i);
//            if (i > 0){
//                for (int j = 0; j < sell.get(i - 1).get(0); j++){
//                    ps.add(ps.get(p) + sell.get(i - 1).get(1));
//                    p += 1;
//                }
//            } else{
//                int x = sell.get(0).get(0);
//                ps.add(sell.get(0).get(1));
//                sell.get(0).set(0, x - 1);
//            }
            while (idx < m){
                long e = sell.get(idx).get(0);
                if (g < sell.get(idx).get(0)){
                    sell.get(idx).set(0, e - g);
                    long t = p[i];
                    p[i] = t + g*(sell.get(idx).get(1));
                    break;
                } else if (g == sell.get(idx).get(0)) {
                    sell.get(idx).set(0, e - g);
                    long t = p[i];
                    p[i] = t + g*(sell.get(idx).get(1));
                    idx += 1;
                    break;
                } else if (g > sell.get(idx).get(0)){
                    g -= sell.get(idx).get(0);
                    long t = p[i];
                    p[i] = t + (sell.get(idx).get(0) * sell.get(idx).get(1));
                    idx += 1;
                }
            }
        }
        for (int i = 1; i < n; i++){
            p[i] += p[i - 1];
        }

        // SCAN
        for (int i = n - 1; i >= 0; --i){
            long sel = p[i];
            long ren = ss[i];
            if (i + 1 < n){
                sel += ss[i + 1];
            }
            if (i > 0){
                ren += p[i - 1];
            }
            ans = Math.max(ren, sel);
            if (ren < sel){
                // ans = ren;
                break;

            }
        }


        out.println(ans);
        out.close();
        System.exit(0);
    }
}