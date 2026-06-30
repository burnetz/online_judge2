
package atcoder.abc464;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        int countW = 0;
        int countE = 0;

        for(int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case 'W' -> {
                    countW++;
                }
                default -> {
                    countE++;
                }
            }
        }

        System.out.println(countW > countE ? "West" : "East");
    }
}