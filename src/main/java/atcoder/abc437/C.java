package atcoder.abc437;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int i = 0; i < t; i++) {
            solve(sc);
        }
    }

    static void solve(Scanner sc) {
        int n = sc.nextInt();

        Deer[] deer = new Deer[n];
        long totalPower = 0;

        for(int i = 0; i < n; i++) {
            int w = sc.nextInt();
            int p = sc.nextInt();

            deer[i] = new Deer(w, p);
            totalPower += p;
        }

        //体重が軽くて力の無いトナカイも優先的にソリに乗せて良いのはもちろん
        //直感に反するが体重が重くて力が弱いトナカイと体重が軽くて力が強いトナカイの優先度は同じ。
        //残されるトナカイにとっては同じこと。
        Arrays.sort(deer, Comparator.comparingInt(e -> e.power + e.weigh));

        int result = 0;
        long totalWeigh = 0;

        for(int i = 0; i < n ; i++) {
            if(totalPower - deer[i].power >= totalWeigh + deer[i].weigh) {
                result++;
                totalPower -= deer[i].power;
                totalWeigh += deer[i].weigh;
            }
            else {
                break;
            }
        }

        System.out.println(result);
    }
}

class Deer {
    int weigh;
    int power;

    public Deer(int weigh, int power) {
        this.weigh = weigh;
        this.power = power;
    }
}