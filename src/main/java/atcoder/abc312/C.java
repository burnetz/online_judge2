package atcoder.abc312;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        double seller[] = new double[n];
        for(int i = 0; i < n; i++){
            seller[i] = sc.nextInt();
        }
        double buyer[] = new double[m];
        for(int i = 0; i < m; i++){
            buyer[i] = sc.nextInt();
        }

        Arrays.sort(seller);
        Arrays.sort(buyer);

        int r = 0;
        int l = Integer.MAX_VALUE;
        //売り手と買い手の差は値段に対して単調に変化するので2分探索が可能
        while(l + 1 < r){
            int mid = (l + r) / 2;
            //double型にしてわざと狙いを外すと探しやすい
            int indexS = Arrays.binarySearch(seller, mid + 0.5);
            indexS = -(indexS + 1);

            int indexB = Arrays.binarySearch(buyer, mid - 0.5);
            indexB = -(indexB + 1);

            int numOfSeller = indexS;
            int numOfBuyer = m - indexB;

            if(numOfSeller >= numOfBuyer) {
                r = mid;
            }
            else {
                l = mid;
            }
        }

        System.out.println(r);
    }
}
