package atcoder.arc205;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        char[][] matrix = new char[n][n];

        for(int i = 0; i < n; i++) {
            matrix[i] = sc.next().toCharArray();
        }

        dp = new int[n + 1][n + 1];

        for(int i = 1; i <= n - 1; i++) {
            for(int j = 1; j <= n - 1; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];

                boolean isOk = true;
                for(int k = 0; k < 2; k++) {
                    for(int p = 0; p < 2; p++) {
                        if(matrix[i + k - 1][j + p - 1] == '#') {
                            isOk = false;
                            break;
                        }
                    }
                }

                if(isOk) {
                    dp[i][j]++;
                }

            }
        }

        for(int i = 0; i < q; i++) {
            int u = sc.nextInt();
            int d = sc.nextInt() - 1;
            int l = sc.nextInt();
            int r = sc.nextInt() - 1;
            int result = dp[d][r] - dp[u - 1][r] - dp[d][l - 1] + dp[u - 1][l - 1];

            System.out.println(result);
        }
    }

    static int dp[][];
}
