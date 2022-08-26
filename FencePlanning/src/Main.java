import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {
    static ArrayList<ArrayList<Integer>> NETWORKS = new ArrayList<>();
    public static void dfs(int x, boolean[] seen, ArrayList<ArrayList<Integer>> g, ArrayList<ArrayList<Integer>> cows, int[] b){
        // If already seen, ignore
        if (seen[x]){
            return;
        }
        //minX
        b[0] = Math.min(b[0], cows.get(x).get(0));
        //maxX
        b[1] = Math.max(b[1], cows.get(x).get(0));
        //minY
        b[2] = Math.min(b[2], cows.get(x).get(1));
        //maxY
        b[3] = Math.max(b[3], cows.get(x).get(1));

        // Mark as seen
        seen[x] = true;

        // Go through neighboors dfs
        for (Integer n: g.get(x)){
            dfs(n, seen, g, cows, b);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("fenceplan.in"));
        String personCard = in.readLine();
        String[] inp = personCard.split(" ");
        int n = Integer.parseInt(inp[0]);
        int m = Integer.parseInt(inp[1]);

        ArrayList<ArrayList<Integer>> cows = new ArrayList<>();
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        // initiate cows
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
        // initiate g
        for (int i = 0; i < m; i++){
            ArrayList<Integer> idiot = new ArrayList<>();
            String cowCoord = in.readLine();
            String[] coord = cowCoord.split(" ");
            idiot.add(Integer.parseInt(coord[0]));
            idiot.add(Integer.parseInt(coord[1]));
            connec.add(idiot);
            g.get(Integer.parseInt(coord[0]) - 1).add(Integer.parseInt(coord[1]) - 1);
            g.get(Integer.parseInt(coord[1]) - 1).add(Integer.parseInt(coord[0]) - 1);
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
        boolean[] seen = new boolean[n];
        int ans = 1000000000;

        // start dfs
        for (int i = 0; i < n; i++) {
            if (seen[i]){
                continue;
            }
            int[] b = new int[] {1000000000, -1000000000, 1000000000, -1000000000};
            dfs(i, seen, g, cows, b);
            ans = Math.min(ans, 2*(b[3] - b[2]) + 2*(b[1] - b[0]));
        }

        // ans
        System.out.println(cows);
        System.out.println(g);
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("fenceplan.out")));
        out.println(ans);
        out.close();

//        int netCount = 1;
//        // commence search
//        boolean[] Globalseen = new boolean[g.size()];
//        for (int i = 0; i < n; i++){
//            if (!Globalseen[i]){
//                boolean[] seen = new boolean[g.size()];
//                dfs(i, seen, g);
//                ArrayList<Integer> network = new ArrayList<>();
//                for (int j = 0; j < g.size(); j++){
//                    if (seen[j]){
//                        Globalseen[j] = true;
//                        network.add(j + 1);
//                    }
//                }
//                NETWORKS.add(network);
//            }
//        }
//        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("fenceplan.out")));
//
//        ArrayList<Integer> minINDEX = new ArrayList<>();
//        minINDEX.add(1);
//        int minSize = 1000000000;
//        for (int i = 0; i < NETWORKS.size(); i++){
//            if (NETWORKS.get(i).size() < minSize){
//                minSize = NETWORKS.get(i).size();
//                minINDEX.removeAll(minINDEX);
//                minINDEX.add(i);
//            }
//            if (NETWORKS.get(i).size() == minSize){
//                minINDEX.add(i);
//            }
//        }
//        for (int i = 0; i < minINDEX.size(); i++){
//            PriorityQueue<Integer> xC = new PriorityQueue<>();
//            PriorityQueue<Integer> yC = new PriorityQueue<>();
//            PriorityQueue<Integer> xCmin = new PriorityQueue<>();
//            PriorityQueue<Integer> yCmin = new PriorityQueue<>();
//            for (int j = 0; j < NETWORKS.get(minINDEX.get(i)).size(); j++){
//                int x = cows.get(NETWORKS.get(minINDEX.get(i)).get(j) - 1).get(0);
//                int y = cows.get(NETWORKS.get(minINDEX.get(i)).get(j) - 1).get(1);
//                xC.add(-x);
//                yC.add(-y);
//                xCmin.add(x);
//                yCmin.add(y);
//            }
//            int maxX = -xC.poll();
//            int maxY = -yC.poll();
//            int minX = xCmin.poll();
//            int minY = yCmin.poll();
//            int num = (2*(maxX - minX) + 2*(maxY - minY));
//            out.println(num);
//            out.close();


//        for (int j = 0; j < g.size(); j++){
//            NETWORKS.add(new ArrayList<Integer>());
//        }
//        for (int j = 0; j < g.size(); j++){
//            if (Globalseen[j] == true){
//                NETWORKS.get(netCount - 1).add(j);
//            }
//        }
//        for (int i = 0; i < g.size(); i++){
//            boolean[] seen = new boolean[g.size()];
//            if (seen[i] == false){
//                netCount += 1;
//                dfs(i, seen, g);
//            }
//            for (int j = 0; j < g.size(); j++){
//                if (seen[j] == true){
//                    NETWORKS.get(netCount - 1).add(j);
//                }
//            }
//        }
        System.out.println();
    }
}