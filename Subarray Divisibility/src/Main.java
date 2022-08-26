import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        StringTokenizer str = new StringTokenizer(in.readLine());
        long ans = 0;
        long ps = 0;
        HashMap<Long, Long> l = new HashMap<>();
        for (int i = 0; i < n; i++){
            ps += Integer.parseInt(str.nextToken());;
            ps %= n;
            if (ps < 0) {
                ps += n;
            }
            if (ps == 0){
                ans += 1;
            }
            ans += l.getOrDefault(ps, (long) 0);
            l.put(ps, l.getOrDefault(ps, (long) 0) + 1);
//            if (s[i] == 0){
//                z += 1;
//            } else{
//                z = 0;
//            }
//            if (ps % n == 0){
//                if (s[i] % n == 0){
//                    ans += z * (z + 1) / 2 - z * (z - 1) / 2;
//                } else{
//                    ans += 1;
//                }
//                continue;
//            }
//            if (s[i] % n == 0){
//                ans += 1 + z * (z + 1) / 2 - z * (z - 1) / 2;
//                continue;
//            }
//            if (l.containsKey(ps % n)){
//                if (ps - (ps % n) >= n){
//                    ans += l.get(ps % n) + z * (z + 1) / 2 - z * (z - 1) / 2;
//                }
//            }
////            if (l.containsKey(s[i] % n)){
////                if ()
////                ans += l.get(s[i] % n);
////            }
//            l.put(ps % n, l.getOrDefault(ps % n, (long) 0) + 1);
        }

        System.out.println(ans);
    }
}