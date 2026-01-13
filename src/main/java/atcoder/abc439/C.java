package atcoder.abc439;

import java.util.Scanner;
import java.util.Vector;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int count[] = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            for(int j = i + 1; j <= n; j++) {
                long tmp = (long)i * i + (long)j * j;

                if(tmp <= n) {
                    count[(int)tmp]++;
                }
                else {
                    break;
                }
            }
        }

        Vector<Integer> vec = new Vector<>();
        for(int i = 1; i <= n; i++) {
            if(count[i] == 1) {
                vec.add(i);
            }
        }

        System.out.println(vec.size());
        for(int i = 0; i < vec.size(); i++) {
            System.out.print(vec.elementAt(i) + " ");
        }
        System.out.println();
    }
}