import java.io.*;
import java.util.*;

public class Main {
    public static int checkSubarraySum(long[] nums, int k) {
        Map<Integer, Integer> h = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < nums.length; i++){
            if (i > 0){
                nums[i] += nums[i - 1];
            }
            if (nums[i] % k == 0){
                //if (i + 1 >= 2){
                    ans = Math.max(ans, i + 1);
                //}
            }
            int t = (int) (nums[i] % k);
            if (h.containsKey(t)){
                //if ((i - h.get(nums[i] % k)) >= 2){
                    ans = Math.max(ans, (i - h.get(t)));
                //}
            } else{
                h.put(t, i);
            }
        }
        return ans;
    }

    public static void main(String[] args) throws Exception {
        // write your code here
        // System.out.println("Working Directory = " + System.getProperty("user.dir"));
        BufferedReader f = new BufferedReader(new FileReader("div7.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("div7.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        long[] num = new long[N];
        for (int j = 0; j < N; j++){
            num[j] = Integer.parseInt(f.readLine());
        }
        int ans = 0;
        ans = checkSubarraySum(num, 7);
        out.println(ans);
        out.close();
        System.exit(0);
    }
}