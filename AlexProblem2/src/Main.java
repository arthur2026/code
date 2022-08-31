import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());

        String[] arr = new String[n];
        for (int i = 0; i < n; i++){
            arr[i] = in.readLine();
        }
        String x = in.readLine();
        for (int i = 0; i < n; i++){
            String str = "";
            // arr[i] is the string
            for (int j = 0; j < arr[i].length(); j++){
                String str2 = "";
                for (int k = j; k < j + x.length(); k++){
                    if (k < arr[i].length()){
                        str2 += arr[i].charAt(k);
                    }
                }
                if (str2.equals(x)){
                    int temp = Integer.parseInt(str2) + 1;
                    str += String.valueOf(temp);
                    j += str2.length() - 1;
                } else {
                    str += arr[i].charAt(j);
                }
            }
            System.out.println(str);
        }
//        int x = Integer.parseInt(in.readLine());
//        String t = String.valueOf(x);
//        String[] temp = t.split("");
//        int size = temp.length;
//        for (int i = 0; i < n; i++){
//            String str = "";
//            String y = String.valueOf(arr[i]);
//            String[] z = y.split("");
//            for (int j = 0; j < z.length - size; j++){
//                String str2 = "";
//                for (int k = j; k < j + size; k++){
//                    str2 += z[k];
//                }
//                if (str2.equals(t)){
//                    int tempor = Integer.parseInt(str2);
//                    tempor += 1;
//                    str2 = String.valueOf(tempor);
//                    str += str2;
//                    j += size - 1;
//                } else{
//                    str += z[j];
//                }
//            }
//            System.out.println(str);
//        }im b
    }
}