package atcoder.abc305;

import java.util.Arrays;
import java.util.Scanner;

public class D {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a[] = new int[n];

        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }

        Sleep [] sleeps = new Sleep[n];
        long [] sum = new long[n];

        //起きている時間もある程度対等に区間として扱った方がやりやすい。
        for(int i = 0; i < sleeps.length - 1; i++){
            sleeps[i] = new Sleep(a[i], a[i + 1], i);
            sum[i] += sleeps[i].sleepLength();
            if(i >= 1) {
                sum[i] += sum[i - 1];
            }
        }
        sleeps[n - 1] = new Sleep(a[n - 1], Integer.MAX_VALUE, n - 1);
        sum[n - 1] = sum[n - 2];

        int q = sc.nextInt();

        for(int i = 0; i < q; i++){
            int l = sc.nextInt();
            int r = sc.nextInt();

            //区間の検索は2分探索なら間に合う
            int leftIndex = index(l, a);
            int rightIndex = index(r, a);

            //区間内の中途半端な睡眠時間等に注意して計算する
            long result = sleeps[rightIndex].sleepBefore(r) - sleeps[leftIndex].sleepBefore(l);

            if(leftIndex > 0){
                result -= sum[leftIndex - 1];
            }

            if(rightIndex > 0){
                result += sum[rightIndex - 1];
            }

            System.out.println(result);
        }
    }

    static int index(int time, int array[]){
        int index = Arrays.binarySearch(array, time);

        if(index < 0){
            index++;
            index *= -1;
            index--;
        }

        return index;
    }
}

class Sleep implements Comparable<Sleep> {
    int begin;
    int end;
    boolean sleep;

    Sleep(int begin, int end, int index) {
        this.begin = begin;
        this.end = end;
        this.sleep = index % 2 == 1;
    }

    long sleepLength() {
        if(sleep) {
            return end - begin;
        }
        else {
            return 0;
        }
    }

    int sleepBefore(int time){
        if(!sleep) {
            return 0;
        }
        return time - begin;
    }

    @Override
    public int compareTo(Sleep sleep) {
        return Integer.compare(this.begin, sleep.begin);
    }
}