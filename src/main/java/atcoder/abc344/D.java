package atcoder.abc344;

import java.util.Arrays;
import java.util.Scanner;

public class D {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String strT = sc.next();

        int n = sc.nextInt();

        String[][] strArray = new String[100][10];

        for(int i = 0; i < n; i++) {
            int m = sc.nextInt();

            for(int j = 0; j < m; j++) {
                strArray[i][j] = sc.next();
            }
            for(int j = m; j < 10; j++) {
                strArray[i][j] = "";
            }
        }

        //dp[i][j] : i番目までの袋まで見たときにj文字目まで一致させる最小コスト
        int dp[][] = new int[n + 1][strT.length() + 1];
        int INF = 1_000_000_000;
        for(int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], INF);
        }
        dp[0][0] = 0;

        for(int i = 1; i <= n; i++) {
            for(int j = 0; j <= strT.length(); j++) {
                dp[i][j] = dp[i - 1][j];
            }
            for(int j = 0; j < strT.length(); j++) {
                for(int k = 0; k < 10; k++) {
                    if(strArray[i - 1][k].equals("")) {
                        break;
                    }
                    int tmpLen = j + strArray[i - 1][k].length();
                    if(tmpLen > strT.length()) {
                        continue;
                    }

                    if(strT.substring(j, tmpLen).equals(strArray[i - 1][k])) {
                        //何もしないパターンをきちんと反映させること（ループ中に最良の結果が上書きされてしまうことがある）
                        dp[i][tmpLen] = Math.min(Math.min(dp[i - 1][tmpLen], dp[i - 1][j] + 1), dp[i][tmpLen]);
                    }
                }
            }
        }

        System.out.println(dp[n][strT.length()] < INF ? dp[n][strT.length()] : -1);
    }
}