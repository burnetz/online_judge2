package atcoder.abc346;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int w = sc.nextInt();
        int b = sc.nextInt();

        String octave = "wbwbwwbwbwbw";
        String keys = "";
        for(int i = 0; i < 30; i++) {
            keys += octave;
        }

        for(int i = 0; i < 12; i++) {
            int wCount = 0;
            int bCount = 0;
            for(int j = 0; j < w + b; j++) {
                if(keys.charAt(i + j) == 'w') {
                    wCount++;
                }
                else {
                    bCount++;
                }
            }

            if(wCount == w) {
                System.out.println("Yes");
                return;
            }
        }


        System.out.println("No");
    }
}