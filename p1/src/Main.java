/*
ID: larrzh3
LANG: JAVA
TASK: friday
*/
import java.util.*;
import java.io.*;

public class Main {
    public Main() throws IOException {
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader("src/friday.in"));
        String years = in.readLine();
        int amountOfYears = Integer.parseInt(years);

        var monday = 0;
        var tuesday = 0;
        var wednesday = 0;
        var thursday = 0;
        var friday = 0;
        var saturday = 0;
        var sunday = 0;
        var Normal_year = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        var Leap_Year = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        var theDay = 0;

        for (int YearsPassed = 0; YearsPassed < amountOfYears; YearsPassed++)
            if (leapLearChecker(1900 + YearsPassed) == 366) {
                for (int Month = 0; Month <= 11; Month++){
                    for (int i = 1; i <=Leap_Year[Month]; i++){
                        theDay += 1;
                        if (i == 13){
                            if (theDay % 7 == 1){
                                monday += 1;
                            }
                            if (theDay % 7 == 2){
                                tuesday += 1;
                            }
                            if (theDay % 7 == 3){
                                wednesday += 1;
                            }
                            if (theDay % 7 == 4){
                                thursday += 1;
                            }
                            if (theDay % 7 == 5){
                                friday += 1;
                            }
                            if (theDay % 7 == 6){
                                saturday += 1;
                            }
                            if (theDay % 7 == 0){
                                sunday += 1;
                            }
                        }
                    }
                }
            }
            else{
                for (int month = 0; month <= 11; month++){
                    for (int i = 1; i <=Normal_year[month]; i++){
                        theDay += 1;
                        if (i == 13){
                            if (theDay % 7 == 1){
                                monday += 1;
                            }
                            if (theDay % 7 == 2){
                                tuesday += 1;
                            }
                            if (theDay % 7 == 3){
                                wednesday += 1;
                            }
                            if (theDay % 7 == 4){
                                thursday += 1;
                            }
                            if (theDay % 7 == 5){
                                friday += 1;
                            }
                            if (theDay % 7 == 6){
                                saturday += 1;
                            }
                            if (theDay % 7 == 0){
                                sunday += 1;
                            }
                        }
                    }
                }
            }
var x = 0;
//        int days = 1900 + amountOfYears;
//        int amountOfDays = Days(days);
//        System.out.println(amountOfDays);
//        for (int i = 0; i < amountOfYears; i++){
//            int theYear = 1900 + i;
//            int amountOfDaysinYear = Days(theYear);
//            var DayNumber = 0;
//            for (int j = 1; j < amountOfDaysinYear; j++){
//                DayNumber += 1;
//                if (DayNumber % 13 == 0){
//
//                }
//            }

//        }


        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("src/friday.out")));
        out.println();
        out.close();
    }


    public static int leapLearChecker(int year) {
        var days = 365;
        if (year % 4 == 0) {
            if (year % 100 != 0){
                days += 1;
            }
            else{
                if (year % 400 == 0){
                    days += 1;
                }
            }
        }
        return days;
    }
}
