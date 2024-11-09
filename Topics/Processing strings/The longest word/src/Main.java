import java.util.Arrays;
import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        String dnaSequence = "ATCGCGATCGATCGATCG";
        int a = 0, c = 0, g = 0, t = 0;
        for(int i = 0; i < dnaSequence.length(); i++) {
            char nucleotide = dnaSequence.charAt(i);
            if (nucleotide == 'A') a++;
            else if (nucleotide == 'C') c++;
            else if (nucleotide == 'G') g++;
            else if (nucleotide == 'T') t++;
        }
        int total = dnaSequence.length();
        System.out.printf("A: %.2f%%\nC: %.2f%%\nG: %.2f%%\nT: %.2f%%\n",
                (double)a/total*100, (double)c/total*100, (double)g/total*100, (double)t/total*100);
    }
}