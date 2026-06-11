package atcoder.abc458;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        long sum = 0;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == 'C') {
                int left = i;
                int right = str.length() - i - 1;

//                System.out.println(left + " " + right);

                sum += Math.max(0, Math.min(left, right)) + 1;
            }
        }

        System.out.println(sum);
    }
}