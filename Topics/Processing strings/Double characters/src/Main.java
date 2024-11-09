import java.util.Arrays;
import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String original = scanner.next();
        char[] originalArr = original.toCharArray();
        char[] newArr = new char[originalArr.length*2];
        int j = 0;
        for (int i=0;i< newArr.length;i+=2){
            newArr[i]= originalArr[j];
            newArr[i+1]=originalArr[j];
            j++;
        }
        String newString = String.valueOf(newArr);
        System.out.println(newString);
    }
}