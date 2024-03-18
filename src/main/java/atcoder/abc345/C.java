package atcoder.abc345;

import java.util.Scanner;
import java.util.regex.Pattern;

public class C {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        //alpha[i][j] : iより前のアルファベットjの出現回数
        int alpha[][] = new int[str.length() + 1][26];

        for(int i = 1; i <= str.length(); i++) {
            for(int j = 0; j < 26; j++) {
                alpha[i][j] = alpha[i - 1][j];
            }
            int cIndex = str.charAt(i - 1) - 'a';
            alpha[i][cIndex]++;

        }

        long result = 0;
        int sameChar = 0;
        for(int i = 1; i < str.length(); i++) {
            int tmpSum = 0;
            for(int j = 0; j < 26; j++) {
                //新しい文字列が作られるパターン
                if(str.charAt(i) - 'a' != j ){
                    tmpSum += alpha[i][j];
                }
                //もともとと同じ文字列になるパターン。こちらは高々1回までしかカウントしない。
                else if(alpha[i][j] > 0) {
                    sameChar = 1;
                }
            }

            result += tmpSum;
        }

        System.out.println(result + sameChar);
    }
}