package atcoder.arc161;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int i = 0; i < t; i++){
            long num = sc.nextLong();
            char[] binary = Long.toBinaryString(num).toCharArray();
            int len = binary.length;
            int count = 0;

            if(num < 7){
                System.out.println(-1);
                continue;
            }

            int last1Index = 0;
            for(int j = 0; j < len; j++){
                if(binary[j] == '1'){
                    count++;
                    //もともと1が4個以上ある場合は最初の3個だけ残してほかを0にすればよい。
                    if(count >= 4){
                        binary[j] = '0';
                    }
                    last1Index = j;
                }
            }

            if(count >= 3){
                System.out.println(Long.parseLong(new String(binary), 2));
                continue;
            }
            //1が全部で2個ある場合
            //最後の1を011に変換できるか
            else if(count == 2 && last1Index < len - 2){
                binary[last1Index] = '0';
                binary[last1Index + 1] = '1';
                binary[last1Index + 2] = '1';
                System.out.println(Long.parseLong(new String(binary), 2));
                continue;
            }
            //上記までに該当しない場合は桁数を減らして1110000...にするしかない。
            else {
                Arrays.fill(binary, '0');
                for(int j = 1; j <= 3 ; j++){
                    binary[j] = '1';
                }
                System.out.println(Long.parseLong(new String(binary), 2));
            }
        }
    }
}
