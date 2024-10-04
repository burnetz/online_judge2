package atcoder.abc369;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int result = 0;
        int left = -1;
        int right = -1;
        for(int i = 0; i < n ; i++) {
            int key = sc.nextInt();
            String hand = sc.next();

            switch (hand) {
                case "L" -> {
                    if(left != -1) {
                        result += Math.abs(left - key);
                    }
                    left = key;
                }
                case "R" -> {
                    if(right != -1) {
                        result += Math.abs(right - key);
                    }
                    right = key;
                }
            }
        }

        System.out.println(result);
    }
}