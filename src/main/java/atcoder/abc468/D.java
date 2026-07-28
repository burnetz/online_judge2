
package atcoder.abc468;

import java.util.Arrays;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        int result = 0;

        //O(N^2)でも間に合う。軸を決めてから左右に伸ばす。
        //こちらは文字数が奇数になるパターン
        for(int i = 0; i < str.length(); i++) {
            int diffCount = 0;
            for(int j = 0; i - j >= 0 && i + j < str.length(); j++) {
                if(str.charAt(i - j) != str.charAt(i + j)) {
                    diffCount++;
                }

                if(diffCount <= 1) {
                    result++;
                }
                else {
                    break;
                }
            }
        }

        //こちらは文字数が偶数になるパターン
        for(int i = 0; i < str.length(); i++) {
            int diffCount = 0;
            for(int j = 0; i - j >= 0 && i + j + 1 < str.length(); j++) {
                if(str.charAt(i - j) != str.charAt(i + j + 1)) {
                    diffCount++;
                }

                if(diffCount <= 1) {
                    result++;
                }
                else {
                    break;
                }
            }
        }

        System.out.println(result);


    }
}