import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        StringTokenizer str = new StringTokenizer(br.readLine());
        long ans = 0;
        HashMap<Long, Integer> s = new HashMap<>();
        long ps = 0;
        for (int i = 0; i < n; i++){
            ps += Integer.parseInt(str.nextToken());
            if (ps == m){
                ans += 1;
            }
            ans += s.getOrDefault(ps - m, 0);
            s.put(ps, s.getOrDefault(ps, 0) + 1);
        }

//        for (int i = 0; i < n; i++){
//            s[i] = Integer.parseInt(str.nextToken());
//        }
//        if (s[1] == m){
//            ans += 1;
//        }
//        for (int i = 1; i < n; i++){
////            if (i == 17){
////                System.out.println("seventeen");
////            }
//            s[i] += s[i - 1];
//            if (s[i] == m){
//                ans += 1;
//                System.out.println(i);
//            }
//            for (int j = 0; j < i; j++){
//                if (s[i] - s[j] == m){
//                    ans += 1;
//                    System.out.println(i + " " + j);
//                }
//            }
//        }
        System.out.println(ans);
    }
}