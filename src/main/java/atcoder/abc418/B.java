package atcoder.abc418;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        double result = 0;

        for(int i = 0; i < s.length() ; i++) {
            if(s.charAt(i) != 't') {
                continue;
            }

            int count = 1;
            for(int j = i + 1; j < s.length(); j++) {
                if(s.charAt(j) == 't') {
                    count++;

                    int len = j - i + 1;

                    if(len <= 2) {
                        continue;
                    }

                    double tmp = (double)(count - 2) / ((j - i + 1) - 2);

                    result = Math.max(tmp, result);
                }
            }
        }

        System.out.println(result);

    }
}