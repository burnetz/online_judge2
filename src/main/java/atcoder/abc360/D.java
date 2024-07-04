package atcoder.abc360;

import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class D {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int t = sc.nextInt();

        String str = sc.next();

        Vector<Long> pos = new Vector<>();
        Vector<Long> neg = new Vector<>();

        for(int i = 0; i < n; i++) {
            if(str.charAt(i) == '1') {
                pos.add(sc.nextLong());
            }
            else {
                neg.add(sc.nextLong());
            }
        }

        neg.sort(Long::compareTo);

        long result = 0;
        for(int i = 0; i < pos.size(); i++) {
            long x = pos.get(i);
            long leftLimit = x + 1;
            long rightLimit = x + 2*t + 1;

            int leftIndex = Collections.binarySearch(neg, leftLimit);
            if(leftIndex < 0) {
                leftIndex = -(leftIndex + 1);
            }
            int rightIndex = Collections.binarySearch(neg, rightLimit);
            if(rightIndex < 0) {
                rightIndex = -(rightIndex + 1);
            }

            result += rightIndex - leftIndex;
        }

        System.out.println(result);
    }
}