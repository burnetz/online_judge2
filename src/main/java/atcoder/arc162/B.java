package atcoder.arc162;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;
import java.util.stream.Collectors;

public class B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int a[] = Arrays.stream(new int[n]).map(e -> sc.nextInt() - 1).toArray();

        //問題で指定されている操作は偶置換なので、奇置換の数列はNO。
        //偶置換の数列であれば手数を重ねれば作れる。
        //選択ソートの要領で頭から揃えていくのが最速。
        Vector<String> result = new Vector<>();
        for(int i = 0; i < n ; i++) {
            if(i == a[i]) {
                continue;
            }

            int index = -1;
            for(int j = i + 1; j < n; j++) {
                if(a[j] == i) {
                    index = j;
                    break;
                }
            }

            //頭の方に持っていきたい数字が最後にある場合は特別な処理が必要。
            if(index == n - 1) {
                //未ソートの要素が2個でこの状況の場合は手詰まり。
                if(i == n - 2) {
                    System.out.println("No");
                    return;
                }

                result.add((n - 1) + " " + (n - 3));
                //末尾2個の要素を1つずつ前にすらすことで後続の処理がそのままできる。
                int tmp = a[n - 3];
                a[n - 3] = a[n - 2];
                a[n - 2] = a[n - 1];
                a[n - 1] = tmp;
                index--;
            }

            //以下の処理でi番目までは完成していることが保証される、
            result.add((index + 1) + " " + i);
            int tmp = a[index + 1];
            for(int j = index + 1; j >= i + 2; j--) {
                a[j] = a[j - 2];
            }
            a[i + 1] = tmp;
        }

        //証明はしていないが最速の方法であれば必ずN回以下になるらしい。

//        if(result.size() > 2000) {
//            System.out.println("No");
//            return;
//        }

        System.out.println("Yes");
        System.out.println(result.size());
        System.out.println(result.stream().collect(Collectors.joining("\n")));
    }
}
