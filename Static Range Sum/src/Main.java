import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(str.nextToken());
        int M = Integer.parseInt(str.nextToken());
        StringTokenizer str2 = new StringTokenizer(in.readLine());
        int x = str2.countTokens();
        long[] ps = new long[N];
        ps[0] = Integer.parseInt(str2.nextToken());
        for (int i = 1; i < N; i++){
            ps[i] += Integer.parseInt(str2.nextToken()) + ps[i - 1];
        }
        for (int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(in.readLine());
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken()) - 1;
            if (one == 0){
                System.out.println(ps[two]);
            } else{
                System.out.println(ps[two] - ps[one - 1]);
            }
        }
    }
}