import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String line = br.readLine();
        StringTokenizer st2 = new StringTokenizer(line);
        ArrayList<Integer> recentTower = new ArrayList<>();
        for (int i = 0; i < n; i++){
            int numbers = Integer.parseInt(st2.nextToken());
            if (i == 0){
                recentTower.add(numbers);
                continue;
            }
            Collections.sort(recentTower);
            int point = Collections.binarySearch(recentTower, numbers);
            if (point < 0) {
                if (recentTower.size() > -point - 1) {
                    recentTower.set(-point - 1, numbers);
                } else {
                    recentTower.add(numbers);
                }
            }
            else{
                while (point + 1 < recentTower.size() && recentTower.get(point + 1) == numbers){
                    point += 1;
                }
                if (recentTower.size() - 1 > point) {
                    recentTower.set(point+1, numbers);
                } else {
                    recentTower.add(numbers);
                }
            }
        }
        System.out.println(recentTower.size());

//        ArrayList<Integer> towerRecent = new ArrayList<>();
//        for (int i = 0; i < n; i++){
//            int numbers = Integer.parseInt(st2.nextToken());
//            System.out.printf("checking %d to tower %d\n", i, numbers);
//            if (i == 0){
//                System.out.printf("0 adding %d to tower %d\n", numbers, i);
//                towerRecent.add(numbers);
//                continue;
//            }
//            int towerAmount = towerRecent.size();
////            PriorityQueue<Integer> minDiff = new PriorityQueue<>();
//            int cubePlaced = 0;
//            for (int j = 0; j < towerAmount; j++){
//                if (cubePlaced == 1){
//                    continue;
//                }
//                int max = towerRecent.get(j);
//                if (numbers < max){
////                    minDiff.add(numbers - max);
//                    System.out.printf("adding %d to tower %d\n", numbers, j);
//                    towerRecent.set(j, numbers);
//                    cubePlaced = 1;
//                }
//            }
//            if (cubePlaced == 0){
//                System.out.printf("adding %d to tower %d\n", numbers, towerRecent.size());
//                towerRecent.add(numbers);
//            }
//        }
//        System.out.println(towerRecent.size());
    }
}