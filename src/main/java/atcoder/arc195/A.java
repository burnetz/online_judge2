package atcoder.arc195;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int a[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();
        int b[] = Arrays.stream(new int[m]).map(e -> sc.nextInt()).toArray();

        int index = 0;
        int indexArray[] = new int[m];
        //前から作った場合の各文字のインデックスを記録
        for(int i = 0; i < n && index < m; i++) {
            if(a[i] == b[index]) {
                indexArray[index] = i;
                index++;
            }
        }

        //前から作れないなら後ろからも作れないので以後チェック不要
        if(index != m) {
            System.out.println("No");
            return;
        }

        index = m - 1;
        int indexArray2[] = new int[m];
        //後ろから作った場合のインデックスを記録
        for(int i = n - 1; i >= 0 && index >= 0; i--) {
            if(a[i] == b[index]) {
                indexArray2[index] = i;
                index--;
            }
        }

        //前から作っても後ろから作っても全く同じなら
        //作り方は1パターンしかない。
        for(int i = 0; i < m; i++) {
            if(indexArray[i] != indexArray2[i]) {
                System.out.println("Yes");
                return;
            }
        }

        System.out.println("No");
    }
}
