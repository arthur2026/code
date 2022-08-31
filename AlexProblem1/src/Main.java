import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(str.nextToken());
        int m = Integer.parseInt(str.nextToken());

        //matrix 1
        int[][] m1 = new int[n][m];
        //matrix 2
        int[][] m2 = new int[n][m];

        for (int i = 0; i < n; i++){
            StringTokenizer str2 = new StringTokenizer(in.readLine());
            for (int j = 0; j < m; j++){
                m1[i][j] = Integer.parseInt(str2.nextToken());
            }
        }

        in.readLine();

        for (int i = 0; i < n; i++){
            StringTokenizer str2 = new StringTokenizer(in.readLine());
            for (int j = 0; j < m; j++){
                m2[i][j] = Integer.parseInt(str2.nextToken());
            }
        }

        int[][] sum = new int[n][m];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                sum[i][j] = m1[i][j] + m2[i][j];
            }
        }

        for (int i = 0; i < n; i++){
            String s = "";
            for (int j = 0; j < m; j++){
                s += sum[i][j] + " ";
            }
            System.out.println(s);
        }
    }
}