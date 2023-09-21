package atcoder.abc320;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] strings = new String[3];
        strings = Arrays.stream(strings).map(s -> {String s1 = sc.next(); return s1 + s1 + s1;}).toArray(String[]::new);

        //普通にやるとmodを考えなければならないので大変だが
        //同じリールを3回繰り返したものを考えればmodを無視して素直にループで確かめられる。
        //一方、リールを前のボタン押下から1周分無視する理由が無いので3回で十分。
        int limit = 3*n;
        int result = Integer.MAX_VALUE;
        for(int i = 0; i < limit; i++) {
            for(int j = 0; j < limit; j++) {
                if(i == j) {
                    continue;
                }
                for(int k = 0; k < limit; k++) {
                    if(i == k || j == k) {
                        continue;
                    }

                    if(strings[0].charAt(i) == strings[1].charAt(j) && strings[1].charAt(j) == strings[2].charAt(k)) {
                        result = Math.min(result, Math.max(i, Math.max(j, k)));
                    }
                }
            }
        }

        System.out.println(result == Integer.MAX_VALUE ? -1 : result);

    }
}
