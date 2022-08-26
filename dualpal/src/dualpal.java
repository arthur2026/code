/*
ID: larrzh3
LANG: JAVA
TASK: dualpal
*/
import java.io.*;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;

public class dualpal {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("dualpal.in"));
        String dualpal = in.readLine();
        String[] dual = (dualpal.split(" "));
        int N = Integer.parseInt(dual[0]);
        int S = Integer.parseInt(dual[1]);

//        String str = "100001";
//        String splits[] = str.split("", 1000000);

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));
        out.println();
        out.close();

    }
    public static ArrayList<Integer> changeBases(int num) {
        ArrayList<Integer> convertedNumbers= new ArrayList<>();
        return convertedNumbers;
    }
    public static int checkPal(ArrayList<Integer> n){
        // 0 = not palindrome
        // 1 = palindrome
        int palTrue = 0;
        int numbers = n.size();
        for (int i = 0; i < numbers; i++){
            int x = n.get(i);
            String str = Integer.toString(x);
            int amount = str.length();
            if (amount % 2 == 0){
                int split = amount/2;
                String splited[] = str.split(str, split);
            }
            else{

            }
        }

        return palTrue;
    }
}
