package atcoder.abc461;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a[] = Arrays.stream(new int[n]).map(e -> sc.nextInt() - 1).toArray();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            map.put(sc.nextInt() - 1, i);
        }

        boolean isOk = true;
        for(int i = 0; i < n; i++) {
            if(a[i] != map.get(i)) {
                isOk = false;
                break;
            }
        }

        System.out.println(isOk ? "Yes" : "No");
    }
}