package atcoder.abc386;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] str = sc.next().toCharArray();

        int count = 0;

        for(int i = 0; i < str.length; i++) {
            count++;
            if(i < str.length - 1 && str[i] == '0' && str[i + 1] == '0') {
                i++;
            }
        }

        System.out.println(count);
    }
}