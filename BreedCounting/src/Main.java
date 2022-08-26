import java.io.*;
import java.util.*;

public class Main {
    public static int[] rSum(int[][] ps, int l, int r){
        int[] ans = new int[3];
        for (int i = 0; i < 3; i++){
            ans[i] = ps[r][i];
            if (l != 0){
                ans[i] -= ps[l - 1][i];
            }
        }
        return ans;
    }

    public static void main(String[] args) throws Exception {
        // write your code here
        // System.out.println("Working Directory = " + System.getProperty("user.dir"));
        BufferedReader f = new BufferedReader(new FileReader("bcount.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("bcount.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int ans = 0;
        //ArrayList<int[]> l = new ArrayList<>();
        int[][] ps = new int[N][3];

        for (int i = 0; i < N; i++){
            //l.add(new int []{i, Integer.parseInt(f.readLine())});
            int num = Integer.parseInt(f.readLine());
            if (num == 1){
                ps[i][0] += 1;
            }
            if (num == 2){
                ps[i][1] += 1;
            }
            if (num == 3){
                ps[i][2] += 1;
            }
        }
        for (int i = 0; i < N; i++){
            if (i > 0){
                ps[i][0] += ps[i - 1][0];
                ps[i][1] += ps[i - 1][1];
                ps[i][2] += ps[i - 1][2];
            }
        }
        for (int i = 0; i < M; i++){
            st = new StringTokenizer(f.readLine());
            int l = Integer.parseInt(st.nextToken()) - 1;
            int r = Integer.parseInt(st.nextToken()) - 1;
            int[] t = rSum(ps, l, r);
            out.println(t[0] + " " + t[1] + " " + t[2]);
        }
        out.close();
        System.exit(0);
    }
}