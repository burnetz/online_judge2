package atcoder.abc397;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        boolean in = false;
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            switch (c) {
                case 'i' -> {
                    if(in) {
                        count++;
                    }
                    else {
                        in = true;
                    }
                }
                case 'o' -> {
                    if(!in) {
                        count++;
                    }
                    else {
                        in = false;
                    }
                }
            }
        }

        if(in) {
            count++;
        }

        System.out.println(count);
    }
}