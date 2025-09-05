package atcoder.arc191;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        char[] s = sc.next().toCharArray();
        char[] t = sc.next().toCharArray();
        int count[] = new int[128];
        for(int i = 0 ; i < m; i++) {
            count[t[i]]++;
        }

        boolean used[] = new boolean[128];
        //Sを前から見て行き、より大きな数字に置き換えられるなら置き換える。
        for(int i = 0; i < n; i++) {
            for(char j = '9'; j > s[i]; j--) {
                if(count[j] > 0) {
                    s[i] = j;
                    count[j]--;
                    break;
                }
            }
            //置き換えた文字ではなく含まれる文字を全て記録する。
            //これが分からなくてずっとドツボにはまっていた。
            //多分引っかかっていたケースは119と111みたいなものか？
            used[s[i]] = true;
        }

        //Tの末尾は必ず使わなければならない。
        //Tの末尾と同じ文字が変更後のSで使われていない場合
        //Sの末尾に割り当てるのが最適。
        if(!used[t[m - 1]]) {
            s[n - 1] = t[m - 1];
        }

        System.out.println(s);
    }
}