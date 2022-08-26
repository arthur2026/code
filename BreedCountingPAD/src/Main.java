import java.io.*;
import java.util.*;

public class Main {
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
        int[][] ps = new int[N + 1][3];

        for (int i = 0; i < N; i++){
            //l.add(new int []{i, Integer.parseInt(f.readLine())});
            int num = Integer.parseInt(f.readLine());
            ps[i + 1][num - 1] += 1;
        }
        for (int i = 0; i < N; i++){
            for (int j = 0; j < 3; j++){
                ps[i + 1][j] += ps[i][j];
            }
        }
        for (int i = 0; i < M; i++){
            st = new StringTokenizer(f.readLine());
            int l = Integer.parseInt(st.nextToken()) - 1;
            int r = Integer.parseInt(st.nextToken()) - 1;
            int[] t = new int[3];
            for (int j = 0; j < 3; j++){
                t[j] = ps[r + 1][j] - ps[l][j];
            }
            out.println(t[0] + " " + t[1] + " " + t[2]);
        }
        out.close();
        System.exit(0);
    }
}