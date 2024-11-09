import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next();
        char[] wordArr = word.toCharArray();
        char[] vowel = {'a', 'e', 'i' ,'o', 'u','y'};
        boolean[] containVowel= new boolean[word.length()];
        for (int i= 0;i < wordArr.length;i++) {
            for (int j=0; j< vowel.length;j++) {
                if (wordArr[i]== vowel[j]) {
                    containVowel[i] = true;
                    break;
                }
                else{
                    containVowel[i]=false;
                }
            }
        }
        int count = 0;
        for (int k = 0; k<containVowel.length-2;k++) {
            if((containVowel[k]==containVowel[k+1]) && (containVowel[k+1]==containVowel[k+2])){
                count++;
                k++;
            }
        }
        System.out.println(count);
    }

    }