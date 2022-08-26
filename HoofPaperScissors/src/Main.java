import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader f = new BufferedReader(new FileReader("hps.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hps.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int ans = 0;

        // PREFIX
        int[] p = new int[n];
        int[] h = new int[n];
        int[] s = new int[n];
        // SUFFIX
        int[] p2 = new int[n];
        int[] h2 = new int[n];
        int[] s2 = new int[n];

        ArrayList<String> moves = new ArrayList<>();
        for (int i = 0; i < n; i++){
            moves.add(f.readLine());
            if (Objects.equals(moves.get(i), "P")){
                p[i] = 1;
                p2[i] = 1;
            }
            if (Objects.equals(moves.get(i), "H")){
                h[i] = 1;
                h2[i] = 1;
            }
            if (Objects.equals(moves.get(i), "S")){
                s[i] = 1;
                s2[i] = 1;
            }
        }
        for (int i = 1; i < n; i++){
            p[i] += p[i - 1];
            h[i] += h[i - 1];
            s[i] += s[i - 1];
        }
        for (int i = n - 1; i > 0; i--){
            p2[i - 1] += p2[i];
            h2[i - 1] += h2[i];
            s2[i - 1] += s2[i];
        }

        for (int i = 0; i < n - 1; i++){
            ans = Math.max(ans, p[i] + p2[i + 1]);
        }
        for (int i = 0; i < n - 1; i++){
            ans = Math.max(ans, p[i] + h2[i + 1]);
        }
        for (int i = 0; i < n - 1; i++){
            ans = Math.max(ans, p[i] + s2[i + 1]);
        }

        for (int i = 0; i < n - 1; i++){
            ans = Math.max(ans, h[i] + p2[i + 1]);
        }
        for (int i = 0; i < n - 1; i++){
            ans = Math.max(ans, h[i] + h2[i + 1]);
        }
        for (int i = 0; i < n - 1; i++){
            ans = Math.max(ans, h[i] + s2[i + 1]);
        }

        for (int i = 0; i < n - 1; i++){
            ans = Math.max(ans, s[i] + p2[i + 1]);
        }
        for (int i = 0; i < n - 1; i++){
            ans = Math.max(ans, s[i] + h2[i + 1]);
        }
        for (int i = 0; i < n - 1; i++){
            ans = Math.max(ans, s[i] + s2[i + 1]);
        }

        out.println(ans);
        out.close();
        System.exit(0);
    }
}