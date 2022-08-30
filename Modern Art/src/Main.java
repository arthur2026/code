import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader("art.in"));
        PrintWriter out = new PrintWriter("art.out");
        int N = Integer.parseInt(in.readLine());
        int ans = N * N;
        HashSet<Integer> taken = new HashSet<>();

        int[][] canvas = new int[N][N];
        ArrayList<int[]> coords= new ArrayList<>();
        for (int i = 0; i < N * N; i++){
            int[] c = new int[4];
            c[0] = 1001;
            c[1] = 1001;
            coords.add(c);
        }
        HashSet<Integer> temp = new HashSet<>();

        for (int i = 0; i < N; i++){
            StringTokenizer s = new StringTokenizer(in.readLine());
            for (int j = 0; j < N; j++){
                canvas[i][j] = Integer.parseInt(s.nextToken());
                if (canvas[i][j] != 0){
                    temp.add(canvas[i][j]);
                }
            }
        }
        if (temp.size() == 1){
            out.println(ans - 1);
            out.close();
        } else{
            // [x, y, x1, y1], [top left, bottom right]
            for (int i = 0; i < N; i++){
                for (int j = 0; j < N; j++){
                    int n = canvas[i][j];
                    int x = coords.get(n)[0];
                    int y = coords.get(n)[1];
                    int x1 = coords.get(n)[2];
                    int y1 = coords.get(n)[3];
                    if (n == 0){
                        continue;
                    }
                    if (i < x){
                        coords.get(n)[0] = i;
                    }
                    if (j < y){
                        coords.get(n)[1] = j;
                    }
                    if (i > x1){
                        coords.get(n)[2] = i;
                    }
                    if (j > y1){
                        coords.get(n)[3] = j;
                    }
                }
            }

            int[] t = new int[4];
            t[0] = 1001;
            t[1] = 1001;

            int[][] ps = new int[N][N];

            int minx = 1001;
            int miny = 1001;
            int maxx = 0;
            int maxy = 0;
            for (int i = 0; i < N * N; i++){
                int x = coords.get(i)[0];
                int y = coords.get(i)[1];
                int x1 = coords.get(i)[2];
                int y1 = coords.get(i)[3];
                minx = Math.min(x, minx);
                miny = Math.min(y, miny);
                maxx = Math.max(x1, maxx);
                maxy = Math.max(y1, maxy);
                int[] C = new int[4];
                C[0] = x;
                C[1] = y;
                C[2] = x1;
                C[3] = y1;
                if (t[0] == C[0] && t[1] == C[1] && t[2] == C[2] && t[3] == C[3]){
                    continue;
                }
                ps[x][y] += 1;
                if (x1 < N - 1 && y1 < N - 1){
                    ps[x1 + 1][y1 + 1] += 1;
                    ps[x][y1 + 1] -= 1;
                    ps[x1 + 1][y] -= 1;
                    continue;
                }
                if (x1 < N - 1){
                    ps[x1 + 1][y] -= 1;
                    continue;
                }
                if (y1 < N - 1){
                    ps[x][y1 + 1] -= 1;
                }
//                if (x1 >= N - 1 && y1 >= N - 1){
//                    continue;
//                }
//                ps[x1 + 1][y1 + 1] += 1;
//                ps[x][y1 + 1] -= 1;
//                ps[x1 + 1][y] -= 1;
//            if (x1 - x + 1 < 2 || y1 - y + 1 < 2){
//                ps[x][y] += 1;
//                ps[x1][y1] += 1;
//            } else{
//                if (x1 >= N || y1 >= N){
//                    continue;
//                }
//                ps[x][y] += 1;
//                ps[x1][y1] += 1;
//                ps[x][y1] -= 1;
//                ps[x1][y] -= 1;
//            }
            }

            // ps
            for (int i = miny; i < maxy + 1; i++){
                if (i == 0){
                    continue;
                }
                ps[minx][i] += ps[minx][i - 1];
            }
            for (int i = minx; i < maxx + 1; i++){
                if (i == 0){
                    continue;
                }
                ps[i][miny] += ps[i - 1][miny];
            }

            for (int i = minx + 1; i < N; i++){
                for (int j = miny + 1; j < N; j++){
                    ps[i][j] += ps[i - 1][j] + ps[i][j - 1] - ps[i - 1][j - 1];
                }
            }

            for (int i = 0; i < N; i++){
                for (int j = 0; j < N; j++){
                    if (ps[i][j] > 1 && !taken.contains(canvas[i][j])){
                        if (canvas[i][j] == 0){
                            continue;
                        }
                        taken.add(canvas[i][j]);
                        ans -= 1;
                    }
                }
            }
        }

        out.println(ans);
        out.close();
    }
}