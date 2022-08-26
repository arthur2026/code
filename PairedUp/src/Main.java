import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader f = new BufferedReader(new FileReader("pairup.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("pairup.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int ans = 0;

        ArrayList<ArrayList<Integer>> m = new ArrayList<>();

        for (int i = 0; i < n; i++){
            StringTokenizer str = new StringTokenizer(f.readLine());
            int amo = Integer.parseInt(str.nextToken());
            int num = Integer.parseInt(str.nextToken());
            ArrayList<Integer> g = new ArrayList<>();
            g.add(amo);
            g.add(num);
            m.add(g);
        }
        Collections.sort(m, (x1, x2) -> x1.get(1) - x2.get(1));

        int l = 0;
        int r = n - 1;
        for (int i = 0; i < n/2; i++){
            if (m.get(l).get(0) <= 0){
                l += 1;
            }
            if (m.get(r).get(0) <= 0){
                r -= 1;
            }
            int x = m.get(l).get(0);
            int y = m.get(r).get(0);
            int sub = Math.min(x, y);
            m.get(l).set(0, x - sub);
            m.get(r).set(0, y - sub);
            ans = Math.max(ans, m.get(l).get(1) + m.get(r).get(1));
        }
//        int idx = 0;
//        int idx2 = 0;
//        for (int i = 0; i < 1000000000; i++){
//            if (n == 0){
//                break;
//            }
//            if (m.size() == 1){
//                ans = Math.max(ans, 2 * m.get(0).get(1));
//                break;
//            }
//            int amount = m.get(idx).get(0);
//            int amount2 = m.get(n - 1 - idx2).get(0);
//            int number = m.get(idx).get(1);
//            int number2 = m.get(n - 1 - idx2).get(1);
//            if (amount == amount2){
//                ans = Math.max(ans, number + number2);
//                m.remove(idx);
//                m.remove(idx2 + 1);
//                n -= 2;
//                idx += 1;
//                idx2 += 1;
//                continue;
//            }
////            if (amount == 0){
////                m.remove(idx);
////                amount = m.get(idx).get(0);
////                number = m.get(idx).get(1);
////            }
////            if (amount2 == 0){
////                m.remove(n - idx);
////                amount2 = m.get(n - 1 - idx2).get(0);
////                number2 = m.get(n - 1 - idx2).get(1);
////            }
//            if (amount > amount2){
//                ans = Math.max(ans, number + number2);
//                //amount2 = 0;
//                //amount = m.get(idx).get(0);
//                amount -= amount2;
//                m.get(idx).set(0, amount);
//                m.remove(n - 1 - idx2);
//                n -= 1;
//                idx2 += 1;
//            } else {
//                ans = Math.max(ans, number + number2);
//                //amount = 0;
//                //amount2 = m.get(n - 1 - idx2).get(0);
//                amount2 -= amount;
//                m.get(n - 1 - idx2).set(0, amount2);
//                m.remove(idx);
//                n -= 1;
//                idx += 1;
//            }
//        }

        out.println(ans);
        out.close();
        System.exit(0);
    }
}