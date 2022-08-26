import java.io.*;
import java.util.*;
public class Main {

    public static class Cow {
        public int start;
        public int end;
        public Cow(int start, int end) {
            this.start = start;
            this.end = end;
        }
        public String toString() {
            return start + " " + end;
        }
    }
    public static void main(String[] args) throws Exception {
        // write your code here
        // System.out.println("Working Directory = " + System.getProperty("user.dir"));
        BufferedReader f = new BufferedReader(new FileReader("helpcross.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("helpcross.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        ArrayList<Integer> chickens = new ArrayList<>();
        for (int i = 0; i < C; i++) {
            st = new StringTokenizer(f.readLine());
            chickens.add(Integer.parseInt(st.nextToken()));
            // System.out.println(chickens.get(i));
        }

        Collections.sort(chickens);

        Cow[] cows = new Cow[N];
        for (int i = 0; i < N; i ++ ) {
            st = new StringTokenizer(f.readLine());
            cows[i] = new Cow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            // System.out.println(cows[i]);
        }
        Arrays.sort(cows, (x, y) -> x.end - y.end);
        int ans = 0;
        for (int i = 0; i < N; i ++) {
            int idx = Collections.binarySearch(chickens, cows[i].start);
            if (idx < 0) {
                idx = - idx - 1;
                if (idx >= chickens.size()) {
                    // System.out.println(" * " + " " + cows[i].start + " " + cows[i].end);
                    continue;
                }
            }
            if (cows[i].start <= chickens.get(idx) && chickens.get(idx) <= cows[i].end) {
                // System.out.println(chickens.get(idx) + " " + cows[i].start + " " + cows[i].end);
                chickens.remove(idx);

                ans += 1;
            }
            else {
                // System.out.println(" * " + " " + cows[i].start + " " + cows[i].end);
            }
        }
        out.println(ans);
        out.close();                                  // close the output file
        System.exit(0);                               // don't omit this!
    }
}
