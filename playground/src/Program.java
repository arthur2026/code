import java.io.*;
import java.util.*;

public class Program
{
    public static void main(String[] args) {
        int x = 1;
        int num = 0;
        for (int i = 1; i < 81; i++){
            x *= i;
            if (x % 45 == 0){
                x /= 45;
                num += 1;
            }
        }
        System.out.println(num);
    }
}