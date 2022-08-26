import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader f = new BufferedReader(new FileReader("paintbarn.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("paintbarn.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] grid = new int[1001][1001];
        int ans = 0;

//        int topX = 0;
//        int topY = 0;
//        int botX = Integer.MAX_VALUE;
//        int botY = Integer.MAX_VALUE;
//        for (int i = 0; i < N; i++){
//            StringTokenizer str = new StringTokenizer(f.readLine());
//            int tx = Integer.parseInt(str.nextToken()) + 1;
//            int ty = Integer.parseInt(str.nextToken()) + 1;
//            int bx = Integer.parseInt(str.nextToken());
//            int by = Integer.parseInt(str.nextToken());
//            topX = Math.max(topX, bx);
//            topY = Math.max(by, topY);
//            botX = Math.min(botX, tx);
//            botY = Math.min(botY, ty);
//            for (int k = tx; k <= bx; k++){
//                for (int l = ty; l <= by; l++){
//                    grid[k][l] += 1;
//                }
//            }
//        }
//        for (int i = botX; i <= topX; i++){
//            for (int j = botY; j <= topY; j++){
//                if (grid[i][j] == K){
//                    ans += 1;
//                }
//            }
//        }
        int topX = 0;
        int topY = 0;
        int botX = Integer.MAX_VALUE;
        int botY = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++){
            StringTokenizer str = new StringTokenizer(f.readLine());
            int tx = Integer.parseInt(str.nextToken());
            int ty = Integer.parseInt(str.nextToken());
            int bx = Integer.parseInt(str.nextToken());
            int by = Integer.parseInt(str.nextToken());
            topX = Math.max(topX, bx);
            topY = Math.max(by, topY);
            botX = Math.min(botX, tx);
            botY = Math.min(botY, ty);
            grid[tx][ty] += 1;
            grid[bx][by] += 1;
            grid[bx][ty] -= 1;
            grid[tx][by] -= 1;
        }
        for (int i = botX; i <= topX; i++){
            if (i > 0){
                grid[i][botY] += grid[i - 1][botY];
            }
        }
        for (int j = botY; j <= topY; j++){
            if (j > 0){
                grid[botX][j] += grid[botX][j - 1];
            }
        }
        for (int i = botX + 1; i <= topX; i++){
            for (int j = botY + 1; j <= topY; j++){
                grid[i][j] += grid[i][j - 1] + grid[i - 1][j] - grid[i - 1][j - 1];
            }
        }
        for (int i = botX; i <= topX; i++){
            for (int j = botY; j <= topY; j++){
                if (grid[i][j] == K){
                    ans += 1;
                }
            }
        }

        out.println(ans);
        out.close();
        System.exit(0);
    }
}