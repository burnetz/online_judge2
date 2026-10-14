
package atcoder.abc479;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String s = sc.next();
        String[] strArray = s.split("S");

        int result = 0;
        for(int i = 0; i < strArray.length; i++) {
            result = Math.max(result, strArray[i].length());
        }

        System.out.println(result);
    }
}