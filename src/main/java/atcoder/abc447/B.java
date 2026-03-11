package atcoder.abc447;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        int count[] = new int[128];

        int maxCount = 0;
        for(int i = 0; i < str.length(); i++) {
            int tmpIndex = str.charAt(i);
            count[tmpIndex]++;

            if(count[tmpIndex] > maxCount) {
                maxCount = count[tmpIndex];
            }
        }

        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if(count[c] != maxCount) {
                System.out.print(c);
            }
        }
        System.out.println();
    }
}