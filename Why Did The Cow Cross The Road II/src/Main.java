import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new FileReader("maxcross.in"));
        BufferedWriter out = new BufferedWriter(new FileWriter("maxcross.out"));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[] stops = new int[B];
        for (int i = 0; i < B; i++){
            int s = Integer.parseInt(in.readLine());
            stops[i] = s;
        }



    }
}