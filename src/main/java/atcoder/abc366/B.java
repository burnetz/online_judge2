package atcoder.abc366;

import java.util.Scanner;

public class B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String inputs[] = new String[n];
        int maxLen = 0;
        for(int i = 0; i < n; i++) {
            inputs[i] = sc.next();
            maxLen = Math.max(inputs[i].length(), maxLen);
        }

        char[][] matrix = new char[n][maxLen];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < inputs[i].length(); j++) {
                matrix[i][j] = inputs[i].charAt(j);
            }

            for(int j = inputs[i].length(); j < maxLen; j++) {
                matrix[i][j] = '*';
            }
        }

        for(int i = 0; i < maxLen; i++) {
            String tmpStr = "";
            for(int j = 0; j < n; j++) {
                tmpStr += matrix[n - j - 1][i];
            }

            while(tmpStr.charAt(tmpStr.length() - 1) == '*') {
                tmpStr = tmpStr.substring(0, tmpStr.length() - 1);
            }

            System.out.println(tmpStr);
        }
    }
}