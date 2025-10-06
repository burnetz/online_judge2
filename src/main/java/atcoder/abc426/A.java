package atcoder.abc426;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String names[] = {"Ocelot", "Serval", "Lynx"};

        String inputs[] = {sc.next(), sc.next()};

        int indexes[] = new int[2];

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 2; j++) {
                if(names[i].equals(inputs[j])) {
                    indexes[j] = i;
                }
            }
        }

        if(indexes[0] >= indexes[1]) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }
}