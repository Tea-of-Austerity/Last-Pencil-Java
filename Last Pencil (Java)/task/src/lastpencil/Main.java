package lastpencil;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String player1 = "John";
        String player2 = "Jack";
        System.out.println("How many pencils would you like to use:");
        int lineNum = takePencil();
        int remains = lineNum;
        String lines = calcLine(remains);
        System.out.printf("Who will be the first (%s, %s)%n",player1,player2);
        String pick = pickPlayer(player1,player2,lines);

        while (remains > 0) {
            if (pick.equals("John")) {
                System.out.println(pick + "'s turn!");
                remains = play(pick, remains);
                pick = pick.equals("John") ? "Jack" : "John";
            } else {
                System.out.println(pick + "'s turn!");
                remains = playAI(remains);
                pick = pick.equals("John") ? "Jack" : "John";
            }
            if (remains == 0) {
                System.out.printf("%s won!%n", pick);
            }
        }

        //picking(pick, remain);

        //scanner.close();
    }
    public static String calcLine(int lineNum){

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<lineNum;i++){
            sb.append("|");
        }
        String lines = sb.toString();
        return lines;
    }
    public static int play(String player, int numRemain){
        while(true) {
            //Scanner sc = new Scanner(System.in);
            //System.out.println(player + "'s turn:");
            int remain = numRemain-checkPencil();
            if (remain<0) {
                System.out.println("Too many pencils were taken");
                continue;
            }
            else{
                System.out.println(calcLine(remain));
            }
            return remain;
        }
    }
    public static int playAI(int numRemain){
        int remain = numRemain;
        boolean loosePosition = ((numRemain-1)%4==0);
        if (remain ==1){
            System.out.println(1);
            System.out.println(calcLine(remain - 1));
            return remain - 1;
        }
        if(loosePosition){
            Random random = new Random();
            int pickAI = random.nextInt(3)+1;
            System.out.println(pickAI);
            System.out.println(calcLine(remain - pickAI));
            return remain- pickAI;
        }
        else {
            if (remain % 4 == 0) {
                System.out.println(3);
                System.out.println(calcLine(remain - 3));
                return remain - 3;
            } else if (remain % 4 == 3) {
                System.out.println(2);
                System.out.println(calcLine(remain - 2));
                return remain - 2;
            } else if (remain % 4 == 2) {
                System.out.println(1);
                System.out.println(calcLine(remain - 1));
                return remain - 1;
            }
        }
        return remain;
    }
    public static String pickPlayer(String player1,String player2,String remains){
        while(true){
            Scanner scanner = new Scanner(System.in);
            String input = scanner.next();
            if(input.equals(player1)||input.equals(player2)){
                System.out.println(remains);
                return input;
            }
            else{
                System.out.printf("Choose between '%s' and '%s'%n",player1,player2);
            }
        }

    }
    public static int takePencil(){
        while(true) {
            Scanner scanner = new Scanner(System.in);
            int value = 0;
            String input = scanner.nextLine();
            if(!input.isEmpty()) {
                try {
                    value = Integer.parseInt(input);
                    if (value == 0) {
                        System.out.println("The number of pencils should be positive");
                    } else {
                        return value;
                    }
                }
                catch (Exception e){
                    System.out.println("The number of pencils should be numeric");
                }
            }
            else{
                System.out.println("The number of pencils should be numeric");
            }
        }
    }
    public static int checkPencil(){
        while(true){
            Scanner scanner = new Scanner(System.in);
            if(scanner.hasNextInt()){
                int value = scanner.nextInt();
                if((value <4) && (value > 0)){
                    return value;
                }
                else{
                    System.out.println("Possible values: '1', '2' or '3'");
                }
            }else {
                System.out.println("Possible values: '1', '2' or '3'");
            }
        }
    }
}
