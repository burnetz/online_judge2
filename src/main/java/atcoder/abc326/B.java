package atcoder.abc326;

import java.util.Scanner;

public class B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for(int i = n ; i <= 999; i++) {
            int d1 = i / 100;
            int d2 = (i % 100) / 10;
            int d3 = i % 10;

            if(d1 * d2 == d3) {
                System.out.println(i);
                return;
            }
        }

    }
}
