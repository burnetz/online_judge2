package atcoder.abc324;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class E {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String t = sc.next();
        String s[] = new String[n];

        int maxLen = 500001;
        //前方i文字が一致する文字列数
        int preCount[] = new int[maxLen];
        //後方i文字が一致する文字列数
        int sufCount[] = new int[maxLen];
        for(int i = 0; i < n; i++) {
            s[i] = sc.next();

            int tmpIndex = 0;
            for(int j = 0; j < s[i].length(); j++) {
                if(s[i].charAt(j) == t.charAt(tmpIndex)) {
                    tmpIndex++;
                    if(tmpIndex == t.length()) {
                        break;
                    }
                }
            }
            preCount[tmpIndex]++;

            tmpIndex = t.length() - 1;
            for(int j = s[i].length() - 1; j >= 0; j--) {
                if(s[i].charAt(j) == t.charAt(tmpIndex)) {
                    tmpIndex--;
                    if(tmpIndex == -1) {
                        break;
                    }
                }
            }
            sufCount[t.length() - tmpIndex - 1]++;
        }

        //後方一致について累積和を求める
        int sufSum[] = new int[maxLen];
        sufSum[0] = sufCount[0];
        for(int i = 1; i < maxLen; i++) {
            sufSum[i] = sufSum[i - 1] + sufCount[i];
        }

        long result = 0;
        for(int i = 0; i < maxLen; i++) {
            if(preCount[i] == 0) {
                continue;
            }

            int tmp = t.length() - i - 1;
            if(tmp >= 0) {
                result += (long) (n - sufSum[tmp]) * preCount[i];
            }
            else {
                result += (long)n * preCount[i];
            }
        }

        System.out.println(result);
    }
}
