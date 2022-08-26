import java.io.*;
import java.util.*;

class Cow {
    int start, end;
    public Cow(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
public class Main {
    public static void main(String[] args) throws Exception {
        var reader =  new Scanner(new BufferedReader(new FileReader("helpcross.in")));
        int C = reader.nextInt();
        int N = reader.nextInt();
        int[] T = new int[C];
        for(int i=0; i<C; i++) {
            T[i] = reader.nextInt();
        }
        Arrays.sort(T);
        ArrayList<Cow> cows = new ArrayList<Cow>();
        for(int i=0; i<N; i++) {
            var c = new Cow(reader.nextInt(), reader.nextInt());
            cows.add(c);
        }

        int ans = 0;
        for(int i=0; i<C; i++) {
            //find smallest end cow that works
            int smallest = Integer.MAX_VALUE;
            int smallestInd = -1;
            int cowStart = -1, cowEnd = -1;
            for(int j=0; j<cows.size(); j++) {
                Cow cow = cows.get(j);
                if(cow.start <= T[i] && T[i] <= cow.end) {
                    if(cow.end < smallest) {
                        smallest = cow.end;
                        smallestInd = j;
                        cowStart = cow.start;
                        cowEnd = cow.end;
                    }
                }

            }
            if(smallestInd == -1) continue;
            System.out.println(T[i] + " + " + cowStart + " " + cowEnd);
            cows.remove(smallestInd);
            ans++;
        }
        for (int i = 0; i < cows.size(); i++){
            System.out.println(cows.get(i).start + " " + cows.get(i).end);
        }
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("helpcross.out")));
        out.println(ans);
        out.close();
    }
}