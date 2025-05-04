package algorithm.solution.smileDK.baejoon.solvedac.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S9498 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int dividedNum = Integer.parseInt(br.readLine()) / 10;

        char result = ' ';

        switch(dividedNum) {
            case 10:
            case 9:
                result = 'A';
                break;
            case 8:
                result = 'B';
                break;
            case 7:
                result = 'C';
                break;
            case 6:
                result = 'D';
                break;
            default :
                result = 'F';
                break;
        }


        System.out.println(result);
    }
}
