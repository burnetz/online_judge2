package atcoder.abc366;

import java.util.*;

public class C {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int q = sc.nextInt();

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < q; i++) {
            int mode = sc.nextInt();

            switch (mode) {
                case 1 -> {
                    int tmp = sc.nextInt();
                    map.merge(tmp, 1, (num1, num2) -> num1 + 1);
                }
                case 2 -> {
                    int tmp = sc.nextInt();
                    map.merge(tmp, 1, (num1, num2) -> num1 - 1);
                    if(map.get(tmp) == 0) {
                        map.remove(tmp);
                    }
                }
                case 3 -> {
                    System.out.println(map.size());
                }
            }
        }
    }
}