import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("berries.in"));
        String farmers = in.readLine();
        int farmerCount = Integer.parseInt(farmers);

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("berries.out")));
        out.println();
        out.close();
    }
}