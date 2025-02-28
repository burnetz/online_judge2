package atcoder.abc394;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] str = sc.next().toCharArray();

        for(int i = str.length - 2; i >= 0; i--) {
            if(str[i] == 'W' && str[i + 1] == 'A') {
                str[i] = 'A';
                str[i + 1] = 'C';
            }
        }

        System.out.println(str);

    }
}