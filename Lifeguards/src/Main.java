import java.io.*;
import java.util.*;

public class Main {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (x1, x2) -> (int) (x1[0] - x2[0]));
        ArrayList<int[]> d = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++){
            int l = d.size();
            if (l == 0 || intervals[i][0] > d.get(l - 1)[1]) {
                d.add(intervals[i].clone());
            } else {
                d.get(l - 1)[1] = Math.max(d.get(l - 1)[1], intervals[i][1]);
            }
        }

        return d.toArray(new int[0][2]);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader f = new BufferedReader(new FileReader("lifeguards.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lifeguards.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int ans = 0;

        int[][] hours = new int[n][2];
        for (int i = 0; i < n; i++){
            StringTokenizer str = new StringTokenizer(f.readLine());
            hours[i][0] = Integer.parseInt(str.nextToken());
            hours[i][1] = Integer.parseInt(str.nextToken());
        }
        int[][] x = merge(hours);
        for (int i = 0; i < x.length; i++){
            int start = x[i][0];
            int end = x[i][1];
            ans += (end - start);
        }
        boolean found = false;
        for (int i = 1; i < hours.length; i++){
            int start = hours[i - 1][0];
            int end = hours[i - 1][1];
            int start2 = hours[i][0];
            int end2 = hours[i][1];
            if (start <= start2 && start2 <= end && start <= end2 && end2 <= end){
                found = true;
                break;
            }
        }

        if (!found) {
            ArrayList<Integer> o = new ArrayList<>();
            if (hours[0][1] > hours[1][0]){
                o.add(hours[0][1] - hours[0][0] - (hours[0][1] - hours[1][0]));
            } else{
                o.add(hours[0][1] - hours[0][0]);
                o.add(hours[0][1] - hours[0][0]);
            }
            if (hours[hours.length - 2][0] > hours[hours.length - 1][1]){
                o.add(hours[hours.length - 2][1] - hours[hours.length - 2][0] - (hours[hours.length - 2][0] - hours[hours.length - 1][1]));
            } else{
                o.add(hours[hours.length - 2][1] - hours[hours.length - 2][0]);
            }
            for (int i = 1; i < hours.length - 1; i++){
                int start = hours[i - 1][0];
                int end = hours[i - 1][1];
                int start2 = hours[i][0];
                int end2 = hours[i][1];
                int start3 = hours[i + 1][0];
                int end3 = hours[i + 1][1];
                o.add(Math.min(start3, end2) - Math.max(end, start2));
            }
            Collections.sort(o);
            ans -= o.get(0);
        }

        out.println(ans);
        out.close();
        System.exit(0);
    }
}