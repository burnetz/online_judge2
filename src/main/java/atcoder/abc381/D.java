package atcoder.abc381;

import java.util.*;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

        //インデックスが偶数スタートと奇数スタートの2パターンで試せば網羅できる。
        int result1 = solve(a, 0);
        int result2 = solve(a, 1);

        System.out.println(Math.max(result1, result2));
    }

    static int solve(int array[], int from) {
        int result = 0;

        Set<Integer> set = new HashSet<>();
        Queue<Integer> que = new ArrayDeque<>();
        for(int i = from; i < array.length - 1; i += 2) {
            //見ている2文字が一致しているとき
            if(array[i] == array[i + 1]) {
                if(!set.contains(array[i])) {
                    set.add(array[i]);
                    que.add(array[i]);
                }
                //見ている文字が既に含まれている文字なら
                //条件を満たすように前の部分を削除する。
                else {
                    while(!que.isEmpty()) {
                        int tmp = que.remove();
                        set.remove(tmp);
                        //見ている文字を再度addすることを忘れない。
                        if(tmp == array[i]) {
                            set.add(array[i]);
                            que.add(array[i]);
                            break;
                        }
                    }
                }
            }
            //見ている2文字が一致しないならクリア
            else {
                set.clear();
                que.clear();
            }

            result = Math.max(result, que.size() * 2);
        }

        return result;
    }
}