import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
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
        Collections.sort(cowsWorktimes, (x1, x2) -> x1.get(0) - x2.get(0));
        int j = 0;
        System.out.println(chickenWorktimes);
        System.out.println(cowsWorktimes);
//        for (int i = 0; i < n; i++){
//            int x = cowsWorktimes.get(j).get(0);
//            int y = cowsWorktimes.get(j).get(1);
//            if (x <= chickenWorktimes.get(i) && chickenWorktimes.get(i) <= y){
//                ans += 1;
//                j += 1;
//            }
//        }

        for (int i = 0; i < n; i++){
            int x = cowsWorktimes.get(i).get(0);
            int y = cowsWorktimes.get(i).get(1);
            while (j < chickenWorktimes.size() && x > chickenWorktimes.get(j)){
                j += 1;
            }
            if (j == chickenWorktimes.size()){
                if (i < cowsWorktimes.size()){
                    System.out.println(x + " " + y);
                    //ans += 1;
                }
                continue;
            }
            if (x <= chickenWorktimes.get(j) && chickenWorktimes.get(j) <= y) {
                System.out.println(chickenWorktimes.get(j) + " + " + x + " " + y);
                ans += 1;
                j += 1;
            }
            else{
                System.out.println(x + " " + y);
            }
//            while (true){
//                if (x >= chickenWorktimes.get(j)){
//                    j += 1;
//                } else if (x <= chickenWorktimes.get(j)) {
//                    break;
//                } else{
//                    ans += 1;
//                    break;
//                }
//            }
        }

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("helpcross.out")));
        out.println(ans);
        out.close();
    }
}