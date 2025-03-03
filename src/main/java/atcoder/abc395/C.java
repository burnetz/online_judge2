package atcoder.abc395;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

        Vector<Integer>[] vectors = new Vector[1000001];
        for(int i = 0; i < vectors.length; i++) {
            vectors[i] = new Vector<>();
        }

        for(int i = 0; i < n; i++) {
            vectors[a[i]].add(i);
        }

        int result = Integer.MAX_VALUE;
        for(int i = 0; i < vectors.length; i++) {
            Vector<Integer> tmpVec = vectors[i];
            for(int j = 0; j < tmpVec.size() - 1; j++) {
                result = Math.min(result, tmpVec.get(j + 1) - tmpVec.get(j) + 1);
            }
        }

        System.out.println(result != Integer.MAX_VALUE ? result : -1);
    }
}