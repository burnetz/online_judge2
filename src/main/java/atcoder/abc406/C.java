package atcoder.abc406;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int p[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

        //最初の山と谷の場所を調べておく
        int firstTop = n;
        for(int i = 1; i < n - 1; i++) {
            if(p[i - 1] < p[i] && p[i] > p[i + 1]) {
                firstTop = i;
                break;
            }
        }

        int firstBottom = n;
        for(int i = 1; i < n - 1; i++) {
            if(p[i - 1] > p[i] && p[i] < p[i + 1]) {
                firstBottom = i;
                break;
            }
        }

        Vector<Integer> vec = new Vector<>();

        //山と谷の場所を同じvectorに保存する。
        //このとき先頭が山になるようにする。
        for(int i = firstTop; i < n - 1; i++) {
            if(vec.size() % 2 == 0) {
                if(p[i - 1] < p[i] && p[i] > p[i + 1]) {
                    vec.add(i);
                }
            }
            else {
                if(p[i - 1] > p[i] && p[i] < p[i + 1]) {
                    vec.add(i);
                }
            }
        }

        long result = 0;
        for(int i = 0; i < vec.size() - 1; i += 2) {
            int top = vec.get(i);
            int bottom = vec.get(i + 1);
            //山より前かつギリギリ谷を含まないようなインデックス
            int left;
            if(i == 0) {
                //最初の山より前に谷が存在する場合は特別扱い
                if(firstBottom < firstTop) {
                    left = firstBottom;
                }
                else {
                    left = 0;
                }
            }
            else {
                left = vec.get(i - 1);
            }

            //谷より後でギリギリ山を含まないインデックス
            int right;
            if(i + 1 == vec.size() - 1) {
                right = n - 1;
            }
            else {
                right = vec.get(i + 2);
            }

            //山と谷の間は調節不可だが両脇は長さを変えられる。
            result += ((long)top - left) * (right - bottom);

        }

        System.out.println(result);
    }
}