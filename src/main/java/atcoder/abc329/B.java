package atcoder.abc329;

import java.util.*;

public class B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Vector<Integer> vec = new Vector<Integer>();
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < n; i++) {
            int tmp = sc.nextInt();
            if(!set.contains(tmp)) {
                vec.add(tmp);
                set.add(tmp);
            }
        }
        Collections.sort(vec);
        System.out.println(vec.get(vec.size() - 2));
    }
}
