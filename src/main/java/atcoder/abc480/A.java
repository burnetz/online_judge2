
package atcoder.abc480;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] inputs = {sc.next(), sc.next()};

        int aR = 0;
        int aC = 0;
        int dR = 0;
        int dC = 0;

        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++) {
                char c = inputs[i].charAt(j);

                switch (c) {
                    case 'A' -> {
                        aR = i;
                        aC = j;
                    }
                    case 'D' -> {
                        dR = i;
                        dC = j;
                    }
                }
            }
        }

        if(aR == dR || aC == dC) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }
}