import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new FileReader("cowjog.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowjog.out")));

        StringTokenizer str = new StringTokenizer(in.readLine());
        long N = Long.parseLong(str.nextToken());
        long T = Long.parseLong(str.nextToken());
        int ans = 1;
        long[] end = new long[(int) N];
        for (int i = 0; i < N; i++){
            StringTokenizer str2 = new StringTokenizer(in.readLine());
            long x = Long.parseLong(str2.nextToken());
            long y = Long.parseLong(str2.nextToken());
            end[i] = x + y * T;
        }
        long s = end[(int) (N - 1)];
        for (long i = N - 1; i >= 0; i--){
            if (end[(int) i] < s){
                ans += 1;
            }
            s = Math.min(s, end[(int) i]);
        }

        out.println(ans);
        out.close();
    }
}