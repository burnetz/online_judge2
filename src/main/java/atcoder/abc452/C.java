package atcoder.abc452;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] a = new int[n];
        int[] b = new int[n];

        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        String[] strings = new String[m];

        //exist[i][j][k] : 長さがiでj文字目がkである文字列が存在するか
        boolean[][][] exist = new boolean[11][10][256];

        for(int i = 0; i < m; i++) {
            strings[i] = sc.next();

            for(int j = 0; j < strings[i].length(); j++) {
                exist[strings[i].length()][j][strings[i].charAt(j)] = true;
            }
        }

        for(int i = 0; i < m; i++) {
            boolean isOk = true;

            String spine = strings[i];

            //肋骨の本数がnと決まっているので脊椎の長さがnでないなら論外
            if(spine.length() != n) {
                System.out.println("No");
                continue;
            }

            for(int j = 0; j < spine.length(); j++) {
                if (!exist[a[j]][b[j] - 1][spine.charAt(j)]) {
                    isOk = false;
                    break;
                }
            }

            System.out.println(isOk ? "Yes" : "No");
        }
    }
}