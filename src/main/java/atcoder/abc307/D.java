package atcoder.abc307;

import java.util.Scanner;
import java.util.Stack;

public class D {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String str = sc.next();

        //'('の出現箇所を記録
        Stack<Integer> stack = new Stack<>();

        StringBuffer sb = new StringBuffer(str);
        //その時点までで削除した文字数。インデックスの再計算に必要
        int removedLength = 0;
        //同じことをStringでやると間に合わないがStringBufferなら大丈夫
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);

            if(c == '('){
                stack.add(i - removedLength);
            }
            else if(c == ')'){
                if(!stack.isEmpty()){
                    //削除があったとしても記録済みの'('の位置は変わらない
                    int deleteBegin = stack.pop();
                    //')'の場所はこれまでの削除数を考慮して計算する必要がある
                    int deleteEnd = i - removedLength + 1;
                    removedLength += deleteEnd - deleteBegin;
                    sb.delete(deleteBegin, deleteEnd);
                }
            }
        }

        System.out.println(sb);
    }
}
