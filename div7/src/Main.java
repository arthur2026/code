import java.io.*;
import java.util.*;

public class Main {
    public static int query(int l, int r, int[] p){
        int ans = p[r];
        if (l != 0){
            ans -= p[l];
        }
        return ans;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader f = new BufferedReader(new FileReader("div7.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("div7.out")));
        int N = Integer.parseInt(f.readLine()) - 1;
        int[] p = new int[]{1, 3, 5, 7, 9};
        for (int i = 0; i < p.length; i++){
            if (i > 0){
                p[i] += p[i-1];
            }
        }

        out.println(query(0, 2, p));
        out.close();
        System.exit(0);
    }
}