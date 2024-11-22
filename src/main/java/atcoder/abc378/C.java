package atcoder.abc378;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            if(map.containsKey(a[i])) {
                System.out.print(map.get(a[i]) + " ");
            }
            else {
                System.out.print(-1 + " ");
            }
            map.put(a[i], i + 1);
        }
    }
}