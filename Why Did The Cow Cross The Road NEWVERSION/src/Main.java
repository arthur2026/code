import java.io.*;
import java.util.*;

public class Main {
    public Main() throws IOException {
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader("helpcross.in"));
        String ins = in.readLine();
        String[] nums = ins.split(" ");
        int c = Integer.parseInt(nums[0]);
        int n = Integer.parseInt(nums[1]);

        ArrayList<Integer> chickenWorktimes = new ArrayList<>();
        ArrayList<ArrayList<Integer>> cowsWorktimes = new ArrayList<>();

        int ans = 0;

        for (int i = 0; i < c; i++){
            String ins2 = in.readLine();
            int worktime = Integer.parseInt(ins2);
            chickenWorktimes.add(worktime);
        }
        Collections.sort(chickenWorktimes);
        for (int i = 0; i < n; i++){
            ArrayList<Integer> cowAvailability = new ArrayList<>();
            String ins3 = in.readLine();
            String[] nums2 = ins3.split(" ");
            int start = Integer.parseInt(nums2[0]);
            int end = Integer.parseInt(nums2[1]);
            cowAvailability.add(start);
            cowAvailability.add(end);
            cowsWorktimes.add(cowAvailability);
        }
        Collections.sort(cowsWorktimes, (x1, x2) -> x1.get(1) - x2.get(1));
        int j = 0;
        System.out.println(chickenWorktimes);
        System.out.println(cowsWorktimes);
        for (int i = 0; i < n; i ++) {
            int x = cowsWorktimes.get(i).get(0);
            int y = cowsWorktimes.get(i).get(1);
            int idx = Collections.binarySearch(chickenWorktimes, x);
            if (idx < 0) {
                idx = - idx - 1;
                if (idx >= chickenWorktimes.size()) {
                    // System.out.println(" * " + " " + cows[i].start + " " + cows[i].end);
                    continue;
                }
            }
            if (x <= chickenWorktimes.get(idx) && chickenWorktimes.get(idx) <= y) {
                // System.out.println(chickens.get(idx) + " " + cows[i].start + " " + cows[i].end);
                chickenWorktimes.remove(idx);

                ans += 1;
            }
            else {
                // System.out.println(" * " + " " + cows[i].start + " " + cows[i].end);
            }
        }

//        for (int i = 0; i < n; i++) {
//            int x = cowsWorktimes.get(i).get(0);
//            int y = cowsWorktimes.get(i).get(1);
//            if (chickenWorktimes.size() != 0) {
//                int k = Collections.binarySearch(chickenWorktimes, x);
//                if (k >= 0) {
//                    if (chickenWorktimes.get(k) >= x) {
//                        System.out.println(chickenWorktimes.get(k) + " + " + x + " " + y + " case 1");
//                        chickenWorktimes.remove(k);
//                        ans += 1;
//                    }
//                } else if (-k - 1 < chickenWorktimes.size()) {
//                    if (chickenWorktimes.get(-k - 1) >= x && chickenWorktimes.get(-k - 1) <= y) {
//                        System.out.println(chickenWorktimes.get(-k - 1) + " + " + x + " " + y);
//                        chickenWorktimes.remove(-k - 1);
//                        ans += 1;
//                    }
//                }
//            }
//            } else{
//                break;
//            }
//            while (j < chickenWorktimes.size() && x > chickenWorktimes.get(j)) {
//                j += 1;
//            }
//            if (j == chickenWorktimes.size()) {
//                if (i < cowsWorktimes.size()) {
//                    System.out.println(x + " " + y);
//                    //ans += 1;
//                }
//                continue;
//            }
//            if (x <= chickenWorktimes.get(j) && chickenWorktimes.get(j) <= y) {
//                System.out.println(chickenWorktimes.get(j) + " + " + x + " " + y);
//                ans += 1;
//                j += 1;
//            } else {
//                System.out.println(x + " " + y);
//            }
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("helpcross.out")));
        out.println(ans);
        out.close();
        }
}