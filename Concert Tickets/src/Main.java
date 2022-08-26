import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        TreeMap<Integer, Integer> prices = new TreeMap<>();
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            int t = Integer.parseInt(st2.nextToken());
            prices.put(t, prices.getOrDefault(t, 0) + 1);
        }

        ArrayList<Integer> max = new ArrayList<>();
        StringTokenizer st3 = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++){
            max.add(Integer.parseInt(st3.nextToken()));
        }

        for (int i = 0; i < m; i++){
            int y = max.get(i);
            if (prices.containsKey(y)){
                System.out.println(y);
                prices.put(y, prices.get(y) - 1);
                if (prices.get(y) == 0){
                    prices.remove(y);
                }
                continue;
            }

            Integer x = prices.lowerKey(y);
            if (x == null){
                System.out.println(-1);
            } else{
                System.out.println(x);
                prices.put(x, prices.get(x) - 1);
                if (prices.get(x) == 0){
                    prices.remove(x);
                }
                prices.remove(x);
            }
        }
    }
}