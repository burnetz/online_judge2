package atcoder.abc301;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class D {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String tmpStr = sc.next();
        while(tmpStr.length() != 64) {
            tmpStr = "0" + tmpStr;
        }
        char[] str = tmpStr.toCharArray();
        long n = sc.nextLong();
        String nStrTmp = Long.toBinaryString(n);
        while(nStrTmp.length() != 64) {
            nStrTmp = "0" + nStrTmp;
        }
        //この時点で2つの文字列の長さは64固定
        char[] nStr = nStrTmp.toCharArray();

        //?の場所を記録しておく
        ArrayList<Integer> wilds = new ArrayList<Integer>();
        for(int i = 0; i < str.length; i++) {
            if(str[i] == '?') {
                wilds.add(i);
            }
        }

        Stack<Integer> stack = new Stack<Integer>();
        boolean smaller = false;

        //Nより大きくなってしまったらロールバックする。
        //「確実に小さくなる」ことが確定した後はロールバックしないので十分早く終わる。
        for(int i = 0; i < str.length; i++){
            char c1 = str[i];
            char c2 = nStr[i];

            if(c1 == '0' && c2 == '0'){
                //none
            }
            //この分岐に入った後は「確実に小さい」ことが確定なので下の桁を全部1にしても大丈夫
            else if(c1 == '0' && c2 == '1'){
                smaller = true;
            }
            else if(c1 == '1' && c2 == '0'){
                if(smaller) {
                    continue;
                }
                //ここまで来たということは対象の数字よりも大きくなってしまったということ。
                //ロールバックが必要。
                if(stack.isEmpty()){
                    System.out.println(-1);
                    return;
                }
                int lastSetOneIndex = stack.pop();
                //最後に1で置き換えた箇所を0にする必要がある。
                str[lastSetOneIndex] = '0';

                //それ以降で置き換えた箇所も一旦?に戻す
                for(int j = 0; j < wilds.size(); j++){
                    int tmp = wilds.get(j);
                    if(tmp > lastSetOneIndex){
                        str[tmp] = '?';
                    }
                }
                i = lastSetOneIndex;
                if(nStr[lastSetOneIndex] == '1') {
                    smaller = true;
                }
            }
            else if(c1 == '1' && c2 == '1') {
                //none
            }
            else if(c1 == '?' && c2 == '0') {
                //確実に小さいことが確定しているなら1にしてもOK
                if(smaller) {
                    str[i] = '1';
                    stack.push(i);
                }
                else {
                    str[i] = '0';
                }
            }
            else { // c1 == '?' && c2 == '1'
                //対象の数字側が1ならロールバック以外で0にする理由はない。
                str[i] = '1';
                stack.push(i);
            }

        }

        System.out.println(Long.parseLong(new String(str), 2));
    }
}
