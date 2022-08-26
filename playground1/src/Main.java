import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer l = new StringTokenizer(in.readLine());
        int x = l.countTokens();
        TreeMap<Integer, Integer> T = new TreeMap<>();
        for (int i = 0; i < x; i++){
            int n = Integer.parseInt(l.nextToken());
            if (T.containsKey(n)){
                System.out.println(n);
            } else{
                T.put(n, 0);
            }
        }
    }
}