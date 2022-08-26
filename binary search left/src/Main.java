import java.io.*;
import java.util.*;

public class Main {
    public static int binarySearchRight(int[] nums, int target){
        int l = 0;
        int r = nums.length - 1;
        while (l < r){
            int mid = (l + r + 1)/2;
            if (nums[mid] <= target){
                l = mid;
            } else{
                r = mid - 1;
            }
        }
        return r;
    }
    public static int binarySearchLeft(int[] nums, int target){
        int l = 0;
        int r = nums.length - 1;
        while (l < r){
            int mid = (l + r)/2;
            if (nums[mid] >= target){
                r = mid;
            } else{
                l = mid + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) throws Exception {
        // write your code here
        // System.out.println("Working Directory = " + System.getProperty("user.dir"));
        BufferedReader f = new BufferedReader(new FileReader("bsearch.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("bsearch.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int num = st.countTokens();
        int target = 19;

        int[] nums = new int[num];

        ArrayList<Integer> l = new ArrayList<>();
        for (int i = 0; i < num; i++){
            int N = Integer.parseInt(st.nextToken());
            nums[i] = N;
        }
        System.out.println(binarySearchRight(nums, target));
        System.out.println(binarySearchLeft(nums, target));

        int ans = 0;
        out.println(ans);
        out.close();
        System.exit(0);
    }
}