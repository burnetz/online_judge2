package atcoder.arc170;

import java.util.Scanner;

public class A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String s = sc.next();
        String t = sc.next();

        int firstA = n;
        int lastB = -1;
        //T内で最初にAが出る場所と最後にBが出る場所を探す。
        for(int i = 0; i < n; i++) {
            char c = t.charAt(i);

            if(c == 'A') {
                firstA = Math.min(firstA, i);
            }
            else {
                lastB = Math.max(lastB, i);
            }
        }

        int stockB = 0;
        int result = 0;
        for(int i = 0; i < n; i++) {
            //BからAに変えなければいけないパターン
            if(s.charAt(i) == 'B' && t.charAt(i) == 'A') {
                //ここよりあとにT内のBが存在しない場合は変更不可。
                if(i >= lastB) {
                    System.out.println(-1);
                    return;
                }
                //i番目をBからAに変更できるパターン。
                //この場合、j番目をどこにするかはまだ考えない。
                else {
                    result++;
                    stockB++;
                }
            }
            if(s.charAt(i) == 'A' && t.charAt(i) == 'B') {
                //ここより前にT内にAが存在しない場合不可。
                if(i <= firstA) {
                    System.out.println(-1);
                    return;
                }
                else {
                    //i番目をBからAに変更したときの未処理分が残っているならそれを使う。
                    if(stockB > 0) {
                        stockB--;
                    }
                    //未処理分が無いならここより前のどこかでAからAへの変更をしたことにする。
                    else {
                        result++;
                    }
                }
            }
        }

        System.out.println(result);
    }
}
