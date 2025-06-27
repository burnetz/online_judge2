package atcoder.abc404;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int c[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

        zoos = new Zoo[n];
        for(int i = 0; i < n; i++) {
            zoos[i] = new Zoo(c[i]);
        }

        for(int i = 0; i < m; i++) {
            int k = sc.nextInt();

            for(int j = 0; j < k; j++) {
                int tmp = sc.nextInt() - 1;
                zoos[tmp].animals.add(i);
            }
        }

        select = new int[n];

        solve(0, n, m);

        System.out.println(result);
    }

    static Zoo[] zoos;
    static int[] select;
    static long result = Long.MAX_VALUE;

    //やることは基本的には全探索。ただしそれぞれの動物園について
    //訪れる回数が0〜2まで有り得るので注意。（3回訪れる意味はない
    //O(3^N M)なので十分間に合う。
    static void solve(int currentDepth, int n, int m) {
        if(currentDepth == n) {

            int animalCount[] = new int[m];
            long tmpSum = 0;
            for(int i = 0; i < n; i++) {
                if(select[i] == 0) {
                    continue;
                }

                for(int j = 0; j < zoos[i].animals.size(); j++) {
                    animalCount[zoos[i].animals.get(j)] += select[i];
                }

                tmpSum += zoos[i].fee * select[i];
            }

            for(int i = 0; i < m; i++) {
                if(animalCount[i] < 2) {
                    return;
                }
            }
            result = Math.min(result, tmpSum);

            return;
        }

        for(int i = 0; i <= 2; i++) {
            select[currentDepth] = i;
            solve(currentDepth + 1, n, m);
        }
    }
}

class Zoo {
    Vector<Integer> animals = new Vector<>();
    int fee;

    Zoo(int fee) {
        this.fee = fee;
    }
}