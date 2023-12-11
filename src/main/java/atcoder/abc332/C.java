package atcoder.abc332;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String str = sc.next();

        int logoTMax = 0;
        int logoTCurrent = 0;
        int mujiTCurrent = m;
        for(int i = 0; i < n; i++) {
            switch (str.charAt(i)) {
                case '0' -> {
                    logoTCurrent = logoTMax;
                    mujiTCurrent = m;
                }
                case '1' -> {
                    if(mujiTCurrent > 0) {
                        mujiTCurrent--;
                    }
                    else {
                        logoTCurrent--;
                        if(logoTCurrent < 0) {
                            logoTMax++;
                        }
                    }
                }
                case '2' -> {
                    logoTCurrent--;
                    if(logoTCurrent < 0) {
                        logoTMax++;
                    }
                }
            }

        }

        System.out.println(logoTMax);

    }
}
