package atcoder.abc314;

import java.util.Scanner;

public class C {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[] str = sc.next().toCharArray();

        StringBuffer[] strByColor = new StringBuffer[m];
        for (int i = 0; i < m; i++){
            strByColor[i] = new StringBuffer();
        }
        int color[] = new int[n];
        int countByColor[] = new int[n];
        for(int i = 0; i < n; i++){
            int c = sc.nextInt() - 1;

            color[i] = c;
            countByColor[i] = strByColor[c].length();
            strByColor[c].append(str[i]);
        }

        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < n; i++){
            sb.append(strByColor[color[i]].charAt((countByColor[i] - 1 + strByColor[color[i]].length()) % strByColor[color[i]].length()));
        }
        System.out.println(sb);
    }
}
