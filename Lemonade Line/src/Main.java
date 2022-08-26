import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("lemonade.in"));
        String cow = in.readLine();
        int n = Integer.parseInt(cow);
        String line = in.readLine();
        StringTokenizer st2 = new StringTokenizer(line);
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < n; i++){
            int num = Integer.parseInt(st2.nextToken());
            numbers.add(num);
        }
        Collections.sort(numbers);
        Collections.reverse(numbers);
        int cowsInLine = 0;
        for (int i = 0; i < numbers.size(); i++){
            int cowLimit = numbers.get(i);
            if (cowLimit >= cowsInLine){
                cowsInLine += 1;
            }
            else{
                break;
            }
        }

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lemonade.out")));
        out.println(cowsInLine);
        out.close();

    }
}