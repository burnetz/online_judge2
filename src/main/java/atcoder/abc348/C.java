package atcoder.abc348;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class C {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            int value = sc.nextInt();
            int color = sc.nextInt();

            map.merge(color, value, Math::min);
        }

        AtomicInteger result = new AtomicInteger(-1);
        map.keySet().stream().forEach(key -> {
            result.set(Math.max(result.get(), map.get(key)));
        });

        System.out.println(result);
    }
}