import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("highcard.in"));
        String personCard = in.readLine();
        int n = Integer.parseInt(personCard);

        ArrayList<Integer> enemy = new ArrayList<>();
        Boolean[] you = new Boolean[2*n];
        for (int i = 0; i < 2 * n; i++){
            you[i] = false;
        }
        ArrayList<Integer> y = new ArrayList<>();
        for (int i = 0; i < n; i++){
            String input = in.readLine();
            int num = Integer.parseInt(input);
            enemy.add(num);
            you[num - 1] = true;
        }
        for (int i = 0; i < 2 * n; i++){
            if (!you[i]){
                y.add(i + 1);
            }
        }
        Collections.sort(enemy);
        System.out.println(y);
        System.out.println(enemy);
        int wins = 0;
        int j = 0;
        for (int i = 0; i < n; i++){
            if (y.get(i) < enemy.get(j)){
            } else {
                j += 1;
                wins += 1;
            }
        }

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("highcard.out")));
        out.println(wins);
        out.close();
    }
}