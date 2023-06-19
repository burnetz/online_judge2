package atcoder.abc306;

import java.math.BigInteger;
import java.util.Scanner;

public class B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        BigInteger result = BigInteger.ZERO;
        BigInteger geta = BigInteger.ONE;
        for(int i = 0; i < 64; i++){
            result = result.add(new BigInteger(sc.next()).multiply(geta));
            geta = geta.multiply(new BigInteger("2"));
        }

        System.out.println(result);
    }
}
