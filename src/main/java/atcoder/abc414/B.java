package atcoder.abc414;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String s = "";

        for(int i = 0; i < n; i++) {
            String tmpS = sc.next();
            long times = sc.nextLong();

            for(int j = 0; j < times; j++) {
                s += tmpS;
                if(s.length() > 100) {
                    System.out.println("Too Long");
                    return;
                }
            }


        }

        System.out.println(s);


    }
}