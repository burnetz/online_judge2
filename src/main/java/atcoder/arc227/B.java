package atcoder.arc227;

import java.util.*;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();
        int[] result = new int[n];
        Arrays.fill(result, -1);

        int[] count = new int[n + 1];
        for(int i = 0; i < n; i++) {
            count[a[i]]++;
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i <= n; i++) {
            if(count[i] > 0) {
                //できるだけi番目にiが来るように配列を構築する
                result[i] = i;
                count[i]--;

                if (count[i] > 0) {
                    map.put(i, count[i]);
                }
            }
        }

        //空いている場所に入れる数字について考える。
        //i番目にiより大きい数字を入れられないのは明らか（i - 1番目までの値にかかわらず要素数が足りない）。
        //加えて余っているものを昇順に入れると後ろの方で矛盾するので
        //余りの中からその時点で許されている範囲で最も大きい数字を順に埋めるのが最適。
        for(int i = 0; i < n; i++) {
            if(map.isEmpty()) {
                break;
            }
            if(result[i] != -1) {
                continue;
            }

            Integer x = map.lowerKey(i);
            if(x == null) {
                System.out.println("No");
                return;
            }
            else {
                result[i] = x;
                if(map.get(x) == 1) {
                    map.remove(x);
                }
                else {
                    map.put(x, map.get(x) - 1);
                }
            }
        }

        System.out.println("Yes");
        for(int i = 0; i < n; i++) {
            System.out.print(result[i] + " ");
        }
    }

}
