package atcoder.abc358;

import java.util.Scanner;

public class C {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        boolean exist[][] = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            String str = sc.next();
            for(int j = 0; j < m; j++) {
                exist[i][j] = str.charAt(j) == 'o';
            }
        }

        int result = Integer.MAX_VALUE;
        for(int i = 0; i < Math.pow(2, n); i++) {
            int mask = 1;
            boolean ok[] = new boolean[m];
            int count = 0;
            for(int j = 0; j < n; j++) {
                if((i & mask) != 0) {
                    count++;
//                    System.out.println(count);
                    for(int k = 0; k < m; k++) {
                        if(exist[j][k]) {
                            ok[k] = true;
                        }
                    }
                }

                mask *= 2;
            }

            boolean allOk = true;
            for(int j = 0; j < m; j++) {
                if(!ok[j]) {
                    allOk = false;
                    break;
                }
            }

            if(allOk) {
                result = Math.min(result, count);
            }
        }

        System.out.println(result);
    }
}