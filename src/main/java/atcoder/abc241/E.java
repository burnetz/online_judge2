package atcoder.abc241;

import java.util.*;

public class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long k = sc.nextLong();
        int a[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

        Map<Integer, Integer> map = new HashMap<>();
        long cycleSum = 0;
        int cycleStartTime = 0;
        long sum[] = new long[2*n + 1];
        int cycleLen = Integer.MAX_VALUE;
        //あるタイミングからX mod Nの値が循環し始めるのでその長さと場所を求める。
        //本来はもっとループの回数を減らせると思うが
        //何故かうまくいかなかったので余裕を持って2N回ループを回している（必ずサイクルが見つかる）
        for(int i = 1; i <= 2*n; i++) {
            int tmp = (int)(sum[i - 1] % n);
            sum[i] = sum[i - 1] + a[tmp];

            int tmp2 = (int)(sum[i] % n);
            if(map.containsKey(tmp2)) {
                cycleLen = i - map.get(tmp2);
                cycleStartTime = map.get(tmp2);
            }
            map.put(tmp2, i);
        }

        //1サイクルあたりの総和
        cycleSum = sum[2*n] - sum[2*n - cycleLen];

        long tmpStart = cycleStartTime + 1;
        //サイクルが何回含まれるか
        long times = (k - (tmpStart)) / cycleLen;
        //Kまででサイクルが1回も含まれないときはそもそもK自体が常識的な回数なので
        //前のステップで求めた値をそのまま使える。
        if(times <= 0) {
            System.out.println(sum[(int)k]);
            return;
        }
        //最終的な答えは「サイクル前」「サイクル中」「サイクル後」の合計
        long result = times * cycleSum + sum[(int)tmpStart];
        int remain = (int)((k - (tmpStart)) % cycleLen);

        for(long i = 0; i < remain; i++) {
            int tmp = (int)(result % n);
            result += a[tmp];
        }

        System.out.println(result);
    }

}
