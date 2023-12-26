package atcoder.abc333;

import java.util.Scanner;
import java.util.Vector;

public class C {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Vector<Long> repunit = new Vector<>();

        String seed = "1";
        for(int i = 0; i < 12; i++) {
            repunit.add(Long.parseLong(seed));
            seed += "1";
        }

        Vector<Long> sum = new Vector<>();
        for(int i = 0; i < repunit.size(); i++) {
            for(int j = i; j < repunit.size(); j++) {
                for(int k = j; k < repunit.size(); k++) {
                    sum.add(repunit.get(i) + repunit.get(j) + repunit.get(k));
                }
            }
        }

        sum.sort(Long::compare);

        System.out.println(sum.get(n - 1));

    }
}
