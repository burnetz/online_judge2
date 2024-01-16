package atcoder.abc336;

import java.util.Scanner;

public class B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int count = 0;
        while (n % 2 == 0) {
            count++;
            n /= 2;
        }

        System.out.println(count);
    }
}
