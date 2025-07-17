package atcoder.abc413;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
loop:        for(int i = 0; i < t; i++) {
            int n = sc.nextInt();

            long a[] = Arrays.stream(new long[n]).map(e -> sc.nextInt()).toArray();

            //N=2のときは必ず等比数列になる。
            if(n == 2) {
                System.out.println("Yes");
                continue;
            }

            //元の数字とその絶対値を両方持つクラス。絶対値基準でソートする。
            NumAbs[] numAbsArray = new NumAbs[n];
            for(int j = 0; j < n; j++){
                numAbsArray[j] = new NumAbs(a[j]);
            }

            Arrays.sort(numAbsArray, Comparator.comparingLong(e -> e.abs));

            //r = 1
            for(int j = 0; j < n - 1; j++) {
                if(numAbsArray[j].original != numAbsArray[j + 1].original) {
                    break;
                }

                if(j == n - 2) {
                    System.out.println("Yes");
                    continue loop;
                }
            }

            //r = -1
            int neg = 0;
            int pos = 0;
            if(numAbsArray[0].original > 0) {
                pos++;
            }
            else {
                neg++;
            }
            boolean sameAbs = true;
            for(int j = 0; j < n - 1; j++) {
                if(numAbsArray[j].abs != numAbsArray[j + 1].abs) {
                    sameAbs = false;
                    break;
                }

                if(numAbsArray[j + 1].original > 0) {
                    pos++;
                }
                else {
                    neg++;
                }
            }

            if(sameAbs && Math.abs(pos - neg) <= 1) {
                System.out.println("Yes");
                continue;
            }

            //rが1でも-1でもない場合。
            for(int j = 2; j < n; j++) {
                //rが有理数の場合でも使える条件にする。
                if(numAbsArray[j - 2].original * numAbsArray[j].original
                        != numAbsArray[j - 1].original * numAbsArray[j - 1].original) {
                    break;
                }

                if(j == n - 1) {
                    System.out.println("Yes");
                    continue loop;
                }
            }

            System.out.println("No");
        }
    }
}

class NumAbs {
    long original;
    long abs;

    NumAbs(long original) {
        this.original = original;
        this.abs = Math.abs(original);
    }
}