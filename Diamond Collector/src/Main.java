import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader("diamond.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("diamond.out")));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int ans = 0;
        int[] s = new  int[n];

        for (int i = 0; i < n; i++){
            s[i] = Integer.parseInt(in.readLine());
        }
        Arrays.sort(s);

        int[] f = new int[n];
        // two pointer
        int j = 0;
        for (int i = 0; i < n; i++){
            while (s[i] - s[j] > k){
                j++;
            }
            f[i] = i - j + 1;
            if (i > 0 && f[i] < f[i - 1]){
                f[i] = f[i - 1];
            }
        }
        int[] g = new int[n];
        j = n - 1;
        for (int i = n - 1; i >= 0; i--){
            while (s[j] - s[i] > k){
                j--;
            }
            g[i] = j - i + 1;
            if (i < n - 1 && g[i] < g[i + 1]){
                g[i] = g[i + 1];
            }
        }
        for (int i = 0; i < n; i++){
            int t = f[i];
            if (i + 1 < n){
                t += g[i + 1];
            }
            ans = Math.max(t, ans);
        }

        out.println(ans);
        out.close();
        System.exit(0);
    }
}