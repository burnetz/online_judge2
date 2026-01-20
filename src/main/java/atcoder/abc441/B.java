package atcoder.abc441;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        boolean[] takahashiAlphabet = new boolean[128];
        boolean[] aokiAlphabet = new boolean[128];

        String s = sc.next();
        for(int i = 0; i < n; i++) {
            takahashiAlphabet[s.charAt(i)] = true;
        }

        String t = sc.next();
        for(int i = 0; i < m; i++) {
            aokiAlphabet[t.charAt(i)] = true;
        }

        int q = sc.nextInt();

        for(int i = 0; i < q; i++) {
            String w = sc.next();

            for(int j = 0; j < w.length(); j++) {
                char c = w.charAt(j);
                if(takahashiAlphabet[c] && !aokiAlphabet[c]) {
                    System.out.println("Takahashi");
                    break;
                }
                if(aokiAlphabet[c] && !takahashiAlphabet[c]) {
                    System.out.println("Aoki");
                    break;
                }

                if(j == w.length() - 1) {
                    System.out.println("Unknown");
                }
            }
        }


    }
}