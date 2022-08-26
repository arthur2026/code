import java.io.*;
import java.util.*;

public class Main {
    static int[][] seen = new int[20][20];
    public static int floodfill(int length, int x, int y, int MAXx, int MAXy, int MINx, int MINy, String[][] grid, String point) {
        if (seen[x][y] == 0){
            if (Objects.equals(point, grid[x][y])){
                seen[x][y] = 1;
                length += 1;
//                if (x + 1 < grid.length && y + 1 < grid.length){
//                    length = floodfill(length, x + 1, y + 1, seen, grid);
//                }
                if (x + 1 < MAXx){
                    length = floodfill(length, x + 1, y, MAXx, MAXy, MINx, MINy, grid, point);
                }
                if (y + 1 < MAXy){
                    length = floodfill(length, x, y + 1, MAXx, MAXy, MINx, MINy, grid, point);
                }
                if (x - 1 >= MINx){
                    length = floodfill(length, x - 1, y, MAXx, MAXy, MINx, MINy, grid, point);
                }
                if (y - 1 >= MINy){
                    length = floodfill(length, x, y - 1, MAXx, MAXy, MINx, MINy, grid, point);
                }
            }
        }
        return length;
    }

    public static boolean isPCL(int brX, int brY, int tlX, int tlY, String[][] grid){
        boolean is = false;
        ArrayList<ArrayList<Integer>> num = new ArrayList<>();
        for (int i = brX; i < tlX; i++) {
            for (int j = brY; j < tlY; j++) {
                int x = floodfill(0, i, j, tlX, tlY, brX, brY, grid, grid[i][j]);
                char y = grid[i][j].charAt(0);
                int z = y - 'a' + 32;
                if (x != 0) {
                    if (num.size() > 0) {
                        boolean found = false;
                        for (int k = 0; k < num.size(); k++) {
                            if (num.get(k).get(0) == z) {
                                int t = num.get(k).get(1);
                                num.get(k).set(1, t + 1);
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            ArrayList<Integer> nu = new ArrayList<>();
                            nu.add(z);
                            nu.add(1);
                            num.add(nu);
                        }
                    } else {
                        ArrayList<Integer> nu = new ArrayList<>();
                        nu.add(z);
                        nu.add(1);
                        num.add(nu);
                    }
                }
            }
        }
        if (num.size() == 2) {
            if (num.get(0).get(1) > 1 && num.get(1).get(1) == 1) {
                is = true;
            }
            if (num.get(0).get(1) == 1 && num.get(1).get(1) > 1) {
                is = true;
            }
        }

        return is;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader("where.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("where.out")));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int ans = 0;
        String[][] grid = new String[n][n];

        for (int i = 0; i < n; i++){
            String[] temp;
            temp = in.readLine().split("");
            for (int j = 0; j < n; j++){
                grid[i][j] = temp[j];
            }
        }
//        System.out.println(isPCL(0, 0, 3, 1, grid));
//        seen = new int[20][20];
//        System.out.println(isPCL(0, 0, 4, 3, grid));
//        seen = new int[20][20];
//        System.out.println(isPCL(0, 2, 4, 4, grid));
//        seen = new int[20][20];
//        System.out.println(isPCL(0, 0, 3, 3, grid));

        ArrayList<int[]> PCLs = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                for (int k = 0; k < n + 1; k++) {
                    for (int l = 0; l < n + 1; l++) {
                        seen = new int[20][20];
//                        if (i == 0 && j == 2 && k == 4 && l == 4){
//                            System.out.println('h');
//                        }
                        if (isPCL(i, j, k, l, grid)){
                            int[] PCL = new int[]{i, j, k, l};
                            PCLs.add(PCL);
                            System.out.println(i + " " + j + " " + k + " " + l);
                        }
                    }
                }
            }
        }
        boolean[] r = new boolean[PCLs.size()];
        for (int i = 0; i < PCLs.size(); i++){
            for (int j = 0; j < PCLs.size(); j++){
                if (i != j){
                    if (PCLs.get(i)[0] <= PCLs.get(j)[0] && PCLs.get(i)[1] <= PCLs.get(j)[1] && PCLs.get(i)[2] >= PCLs.get(j)[2] && PCLs.get(i)[3] >= PCLs.get(j)[3]){
                        r[j] = true;
                    }
                }
            }
        }
        for (int i = 0; i < PCLs.size(); i++){
            if (!r[i]){
                System.out.println("");
                System.out.println(PCLs.get(i)[0] + " " + PCLs.get(i)[1] + " " + PCLs.get(i)[2] +" " + PCLs.get(i)[3]);
                ans += 1;
            }
        }

//        ArrayList<ArrayList<Integer>> num = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                int x = floodfill(0, i, j, grid, grid[i][j]);
//                char y = grid[i][j].charAt(0);
//                int z = y - 'a' + 32;
//                if (x != 0) {
//                    if (num.size() > 0) {
//                        boolean found = false;
//                        for (int k = 0; k < num.size(); k++) {
//                            if (num.get(k).get(0) == z) {
//                                int t = num.get(k).get(1);
//                                num.get(k).set(1, t + 1);
//                                found = true;
//                                break;
//                            }
//                        }
//                        if (found == false) {
//                            ArrayList<Integer> nu = new ArrayList<>();
//                            nu.add(z);
//                            nu.add(1);
//                            num.add(nu);
//                        }
//                    } else {
//                        ArrayList<Integer> nu = new ArrayList<>();
//                        nu.add(z);
//                        nu.add(1);
//                        num.add(nu);
//                    }
//                }
//            }
//        }
//        if (num.size() == 2) {
//            if (num.get(0).get(1) > 1 && num.get(1).get(1) == 1) {
//                ans += 1;
//            }
//        }
//
        out.println(ans);
        out.close();
        System.exit(0);
    }
}