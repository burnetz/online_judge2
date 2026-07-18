package atcoder.abc440;

import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        Vector<Integer> vec = new Vector<>();
        vec.add(-1);

        for(int i = 0; i < n; i++) {
            vec.add(sc.nextInt());
        }
        vec.add(Integer.MAX_VALUE);

        Collections.sort(vec);
        Range[] ranges = new Range[n + 1];

        for(int i = 0; i < n + 1; i++) {
            ranges[i] = new Range(vec.get(i), vec.get(i + 1));

            if(i != 0) {
                ranges[i].previousSumOfAllowedNumber = ranges[i - 1].previousSumOfAllowedNumber + ranges[i - 1].numOfAllowedNumbers();
            }
        }
        for(int i = n; i >= 0; i--) {

            if(ranges[i].numOfAllowedNumbers() > 0) {
                ranges[i].recentAllowedNumber = ranges[i].start + 1;
            }
            else {
                ranges[i].recentAllowedNumber = ranges[i + 1].recentAllowedNumber;
            }
        }

        for(int i = 0; i < q; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            int index = binarySearch(ranges, x);

            //x自体が禁止の場合、最も近くにあるより大きい数字に読み替えても答えは変わらない。
            if(x == ranges[index].start) {
                x = ranges[index].recentAllowedNumber;

                index = binarySearch(ranges, x);
            }

            int allowedIndexX = ranges[index].previousSumOfAllowedNumber + (x - ranges[index].start);
            //ここからはallowedIndexResult番目に有効な数字を探す問題になる。元々のxを気にする必要がなくなる。
            int allowedIndexResult = allowedIndexX + y - 1;
            //区間の特定
            int index2 = binarySearchByAllowedIndex(ranges, allowedIndexResult);

            int result = ranges[index2].start + allowedIndexResult - ranges[index2].previousSumOfAllowedNumber;

            System.out.println(result);
        }
    }

    static int binarySearch(Range[] ranges, int key) {
        int l = -1;
        int r = ranges.length;
        int index = 0;
        while(l <= r) {
            int mid = (l + r) / 2;

            if(key >= ranges[mid].start && key < ranges[mid].end) {
                index = mid;
                break;
            }
            else if(key >= ranges[mid].end ) {
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }

        return index;
    }

    //index番目の有効な数字を探すためのバイナリサーチ
    static int binarySearchByAllowedIndex(Range[] ranges, int index) {
        int l = -1;
        int r = ranges.length;
        int result = 0;

        while(true) {
            int mid = (l + r) / 2;

            //見ている区間内に有効な数字が1つもない場合はややこしいので別に処理する。
            if(ranges[mid].numOfAllowedNumbers() == 0) {
                if(ranges[mid].previousSumOfAllowedNumber >= index) {
                    r = mid - 1;
                }
                else {
                    l = mid + 1;
                }
                continue;
            }

            int startAllowedIndex = ranges[mid].previousSumOfAllowedNumber + 1;
            int lastAllowedIndex = startAllowedIndex + ranges[mid].numOfAllowedNumbers() - 1;

            if(index >= startAllowedIndex && index <= lastAllowedIndex) {
                result = mid;
                break;
            }
            else if(index > lastAllowedIndex ) {
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }

        return result;
    }
}

class Range {
    //半開区間なのでendは含まない。
    int start;
    int end;
    //startより大きく、かつ最も近くにある有効な数字
    int recentAllowedNumber;
    //直前の区間までにある有効な数字の登場回数
    int previousSumOfAllowedNumber;


    Range(int start, int end) {
        this.start = start;
        this.end = end;
    }

    int numOfAllowedNumbers() {
        return end - start - 1;
    }
}