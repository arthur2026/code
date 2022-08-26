import java.io.BufferedReader;
import java.io.FileReader;
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
            for(int j=0; j<cows.size(); j++) {
                Cow cow = cows.get(j);
                if(cow.start <= T[i] && T[i] <= cow.end) {
                    if(cow.end < smallest) {
                        smallest = cow.end;
                        smallestInd = j;
                    }
                }
            }
            if(smallestInd == -1) continue;
            cows.remove(smallestInd);
            ans++;
        }
        System.out.println(ans);
    }
}