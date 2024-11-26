package atcoder.abc381;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt() + 1;
        String str = sc.next() + '3';

        int result = 0;

        if(str.contains("/")) {
            result = 1;
        }
loop:        for(int i = 0; i < n; i++) {
            int phase = 0;

            int ones = 0;
            int twoes = 0;
            for(int j = i; j < n; j++) {
//                System.out.println("j = " + j);
                char c = str.charAt(j);
                switch (phase) {
                    case 0 -> {
//                        System.out.println("phase " + phase);
                        if(c != '1') {
                            continue loop;
                        }
                        else {
                            phase = 1;
                            ones++;
                        }

                    }
                    case 1 -> {
//                        System.out.println("phase " + phase);
                        if(c == '1') {
                            ones++;
                        }
                        else if(c == '/') {
                            phase = 2;
                        }
                        else {
                            i = j;
                            continue loop;
                        }

                    }
                    /*
                    case 2 -> {
                        System.out.println("phase " + phase);
                        if(c == '/') {
                            phase = 3;
                        }
                        else {
                            i = j;
                            continue loop;
                        }

                    }*/
                    case 2 -> {
//                        System.out.println("phase " + phase);
                        if(c == '2') {
                            twoes++;
                        }
                        else {
//                            System.out.println("1 : " + ones + " 2 : " + twoes);
                            result = Math.max(result, Math.min(ones, twoes) * 2 + 1);
                            i = j - 1;
                            continue loop;
                        }

                    }
                }
            }
        }

        System.out.println(result);
    }
}