/*
ID: larrzh3
LANG: JAVA
TASK: beads
*/
import java.util.*;
import java.io.*;

public class Main {
    public Main() throws IOException {
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader("src/beads.in"));
        String Length = in.readLine();
        int amountOfBeads = Integer.parseInt(Length);
        String beads = in.readLine();
        var A = new ArrayList<String>();
        PriorityQueue<Integer> rightSide = new PriorityQueue<Integer>();
        PriorityQueue<Integer> leftSide = new PriorityQueue<Integer>();
        PriorityQueue<Integer> T = new PriorityQueue<Integer>();


        T.add(0);

        
        for (int i = 0; i < amountOfBeads; i++){
            var one = beads.substring(0, i);
            var two = beads.substring(i, amountOfBeads);
            var newString = two + one;
            A.add(newString);
        }
        for (int i = 0; i < A.size(); i++){
            var x = A.get(i);

            var leftNum = A.size() - 1;
            var rightNum = 0;
            var charEnd = x.charAt(leftNum);
            var charStart = x.charAt(rightNum);

            var rightBeadsCollected = 0;
            var leftBeadsCollected = 0;

            // first check cycle (first and last)
            var leftColor = 0;
            var rightColor = 0;

            // r right side
            if (charStart == 'r'){
                rightNum += 1;
                rightBeadsCollected += 1;
                for (int j = 0; j < amountOfBeads; j++){
                    var charLeft = x.charAt(leftNum);
                    var charRight = x.charAt(rightNum);
                    if (charRight == 'r' || charRight == 'w'){
                        rightBeadsCollected += 1;
                        rightNum += 1;
                    }
                    else{
                        break;
                    }
                }
            }
            if (charStart == 'b'){
                rightNum += 1;
                rightBeadsCollected += 1;
                for (int j = 0; j < amountOfBeads; j++){
                    var charLeft = x.charAt(leftNum);
                    var charRight = x.charAt(rightNum);
                    if (charRight == 'b' || charRight == 'w'){
                        rightBeadsCollected += 1;
                        rightNum += 1;
                    }
                    else{
                        break;
                    }
                }
            }
            if (charStart == 'w'){
                continue;
            }

            if (x.charAt(amountOfBeads - 1) == 'r'){
                leftNum -= 1;
                leftBeadsCollected += 1;
                for (int k = 0; k < amountOfBeads; k++){
                    var charLeft = x.charAt(leftNum);
                    var charRight = x.charAt(rightNum);
                    if (charLeft == 'r' || charLeft == 'w'){
                        leftBeadsCollected += 1;
                        leftNum -= 1;
                    }
                }

            }

            if (x.charAt(amountOfBeads - 1) == 'b'){
                leftNum -= 1;
                leftBeadsCollected += 1;
                for (int k = 0; k < amountOfBeads; k++){
                    var charLeft = x.charAt(leftNum);
                    var charRight = x.charAt(rightNum);
                    if (charLeft == 'b' || charLeft == 'w'){
                        leftBeadsCollected += 1;
                        leftNum -= 1;
                    }
                }

            }

            if (x.charAt(amountOfBeads - 1) == 'w'){
                continue;
            }

            rightSide.add(-rightBeadsCollected);
            leftSide.add(-leftBeadsCollected);
            var sum = rightBeadsCollected + leftBeadsCollected;
            T.add(-sum);
        }
        var right = -rightSide.poll();
        var left = -leftSide.poll();
        var res = -T.poll();

        System.out.println(res);

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("src/beads.out")));
        out.println();
        out.close();
    }


    public static int findMaxFromStart(String beadChain, int amountOfBeads) {
        var neighboors = 0;

        return neighboors;
    }
}