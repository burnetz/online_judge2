package atcoder.abc430;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();

        String s = sc.next();

        int[] countA = new int[n + 1];
        int[] countB = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            countA[i] = countA[i - 1];
            countB[i] = countB[i - 1];

            if(s.charAt(i - 1) == 'a') {
                countA[i]++;
            }
            else {
                countB[i]++;
            }
        }

        long result = 0;

        //i番目を起点として条件を満たす区間の個数を求める。
        for(int i = 0; i < n; i++) {
            int keyA = countA[i] + a;
            int keyB = countB[i] + b;

            //区間内でaがA個になるインデックス（働きすぎ）
            int indexA = Arrays.binarySearch(countA, keyA);
            if(indexA < 0) {
                indexA++;
                indexA *= -1;
            }
            else {
                //lower_boundにするための処理
                while (indexA > 0 && countA[indexA] == countA[indexA - 1]) {
                    indexA--;
                }
            }
            //区間内でbがB個になるインデックス（十分な休息）
            int indexB = Arrays.binarySearch(countB, keyB);
            if(indexB < 0) {
                indexB++;
                indexB *= -1;
            }
            else {
                while (indexB > 0 && countB[indexB] == countB[indexB - 1]) {
                    indexB--;
                }
            }
            indexA--;
            indexB--;

            //indexB > indexAのときは「働きすぎかつ休養不足」の区間が存在する。
            //一方、関係が前後逆転しているときは上記のような区間が存在しない。
            if(indexB > indexA) {
                result += indexB - indexA;
            }
        }

        System.out.println(result);
    }
}