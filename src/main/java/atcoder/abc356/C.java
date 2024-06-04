package atcoder.abc356;

import java.util.Scanner;

public class C {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        int testCases[][] = new int[m][n];
        boolean testSuccess[] = new boolean[m];

        for(int i = 0; i < m; i++) {
            int tmp = sc.nextInt();
            for(int j = 0; j < tmp; j++) {
                testCases[i][sc.nextInt() - 1] = 1;
            }
            testSuccess[i] = sc.next().equals("o");
        }

        int result = 0;
        //N <= 15なので全パターン試せる。
        for(int i = 0; i < Math.pow(2, n); i++) {

            boolean ok = true;
            for(int j = 0; j < m; j++) {
                int mask = 1;
                int correctKey = 0;
                for(int l = 0; l < n; l++) {
                    if(testCases[j][l] == 1 && (i&mask) != 0) {
                        correctKey++;
                    }
                    mask *= 2;
                }
                if((correctKey >= k) == (testSuccess[j])) {
                }
                else {
                    ok = false;
                    break;
                }
            }
            if(ok) {
                result++;
            }
        }

        System.out.println(result);
    }
}