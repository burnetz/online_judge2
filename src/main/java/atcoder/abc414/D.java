package atcoder.abc414;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        Path[] paths = new Path[n - 1];
        long pos[] = Arrays.stream(new long[n]).map(e -> sc.nextLong()).sorted().toArray();

        for(int i = 0; i < n - 1; i++) {
            paths[i] = new Path(i, i + 1, pos[i + 1] - pos[i]);
        }

        Arrays.sort(paths, Comparator.comparingLong(e -> e.distance));

        long result = 0;
        //余裕があれば各地点に直接基地局を配置することを基本としつつ
        //距離が短い区間を優先的に隣の基地局に巻き込んでいく。
        //このとき、右と左どちらの基地局を残しても答えは変わらない。
        //また、基地局は区間の中心という設定はあるが実際は計算不要。
        for(int i = 0; i < n - m; i++) {
            result += paths[i].distance;
        }

        System.out.println(result);

    }
}

class Path {
    long distance;
    int leftId;
    int rightId;

    Path (int leftId, int rightId, long distance) {
        this.leftId = leftId;
        this.rightId = rightId;
        this.distance = distance;
    }
}