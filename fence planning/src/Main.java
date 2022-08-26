import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    static ArrayList<boolean[]> seens = new ArrayList<>();
    static void dfsU(int x, boolean[] seen) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("fenceplan.in"));
        String personCard = in.readLine();
        String[] inp = personCard.split(" ");
        int n = Integer.parseInt(inp[0]);
        int m = Integer.parseInt(inp[1]);

        ArrayList<ArrayList<Integer>> cows = new ArrayList<>();
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();

        for (int i = 0; i < n; i++){
            ArrayList<Integer> c = new ArrayList<>();
            String cowCoord = in.readLine();
            String[] coord = cowCoord.split(" ");
            c.add(Integer.parseInt(coord[0]));
            c.add(Integer.parseInt(coord[1]));
            cows.add(c);
            g.add(new ArrayList<>());
        }

        ArrayList<ArrayList<Integer>> connec = new ArrayList<>();

        for (int i = 0; i < m; i++){
            ArrayList<Integer> idiot = new ArrayList<>();
            String cowCoord = in.readLine();
            String[] coord = cowCoord.split(" ");
            idiot.add(Integer.parseInt(coord[0]));
            idiot.add(Integer.parseInt(coord[1]));
            connec.add(idiot);
            g.get(Integer.parseInt(coord[0]) - 1).add(Integer.parseInt(coord[1]));
            g.get(Integer.parseInt(coord[1]) - 1).add(Integer.parseInt(coord[0]));
//            if (y.get(Integer.parseInt(coord[0]) - 1) == false || y.get(Integer.parseInt(coord[1]) - 1) == true) {
//                y.set(Integer.parseInt(coord[0]) - 1, true);
//                y.set(Integer.parseInt(coord[1]) - 1, true);
//            }
//            if (y.get(Integer.parseInt(coord[0]) - 1) == true || y.get(Integer.parseInt(coord[1]) - 1) == false) {
//                y.set(Integer.parseInt(coord[0]) - 1, true);
//                y.set(Integer.parseInt(coord[1]) - 1, true);
//            }
//            if (y.get(Integer.parseInt(coord[0]) - 1) == false || y.get(Integer.parseInt(coord[1]) - 1) == false) {
//                y.set(Integer.parseInt(coord[0]) - 1, true);
//                y.set(Integer.parseInt(coord[1]) - 1, true);
//            }
        }
        seen[x] = true;
        int z = 0;
        for (int i = 0; i < g.get(x).size(); i++){
            z = g.get(x).get(i);
            if (!seen[z]){
                dfsU(z, seen);
                seens.add(seen);
            }
        }
    }
    static void dfs(int x) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("fenceplan.in"));
        String personCard = in.readLine();
        String[] inp = personCard.split(" ");
        int n = Integer.parseInt(inp[0]);
        //        ArrayList<Integer> seen = new ArrayList<>();
        //        if (Collections.binarySearch(seen, x) > 0){
        //            for (int i = 0; i < seen.size(); i++){
        //                return seen.get(i);
        //            }
        //        }
        //        ArrayList<Integer> y = g.get(x-1);
        //        seen.add(x);
        //        for (int i = 0; i < seen.size(); i++) {
        //            int z = dfs(seen.get(i), g);
        //        }
        //        return seen.get(0);
        boolean seen[] = new boolean[n];
        dfsU(x, seen);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("fenceplan.in"));
        String personCard = in.readLine();
        String[] inp = personCard.split(" ");
        int n = Integer.parseInt(inp[0]);
        int m = Integer.parseInt(inp[1]);

        ArrayList<ArrayList<Integer>> cows = new ArrayList<>();
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();

        for (int i = 0; i < n; i++){
            ArrayList<Integer> c = new ArrayList<>();
            String cowCoord = in.readLine();
            String[] coord = cowCoord.split(" ");
            c.add(Integer.parseInt(coord[0]));
            c.add(Integer.parseInt(coord[1]));
            cows.add(c);
            g.add(new ArrayList<>());
        }

        ArrayList<ArrayList<Integer>> connec = new ArrayList<>();

        for (int i = 0; i < m; i++){
            ArrayList<Integer> idiot = new ArrayList<>();
            String cowCoord = in.readLine();
            String[] coord = cowCoord.split(" ");
            idiot.add(Integer.parseInt(coord[0]));
            idiot.add(Integer.parseInt(coord[1]));
            connec.add(idiot);
            g.get(Integer.parseInt(coord[0]) - 1).add(Integer.parseInt(coord[1]));
            g.get(Integer.parseInt(coord[1]) - 1).add(Integer.parseInt(coord[0]));
//            if (y.get(Integer.parseInt(coord[0]) - 1) == false || y.get(Integer.parseInt(coord[1]) - 1) == true) {
//                y.set(Integer.parseInt(coord[0]) - 1, true);
//                y.set(Integer.parseInt(coord[1]) - 1, true);
//            }
//            if (y.get(Integer.parseInt(coord[0]) - 1) == true || y.get(Integer.parseInt(coord[1]) - 1) == false) {
//                y.set(Integer.parseInt(coord[0]) - 1, true);
//                y.set(Integer.parseInt(coord[1]) - 1, true);
//            }
//            if (y.get(Integer.parseInt(coord[0]) - 1) == false || y.get(Integer.parseInt(coord[1]) - 1) == false) {
//                y.set(Integer.parseInt(coord[0]) - 1, true);
//                y.set(Integer.parseInt(coord[1]) - 1, true);
//            }
        }


        System.out.println(cows);
        System.out.println(g);
        dfs(1);
        for (int i = 0; i < seens.size(); i++){
            System.out.println(seens.get(i));
        }
        // commence search

    }

//        for (int i = 0; i < seen.size(); i++){
//            if (Collections.binarySearch(seen, seen.get(i)) <= 0){
//                x = dfs(i, g);
//                return x;
//            }
//        }
    }
