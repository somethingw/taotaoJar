/**
 * @author week
 * @Title: test4
 * @ProjectName 19-0316
 * @Description: TODO
 * @date 2019/5/820:56
 */
import java.util.*;
public class test4 {

    static int min=Integer.MAX_VALUE;
    static String str;
    static int len;

    public static int minCut(String s) {
        str=s;
        len=s.length()-1;
        find(0,0);
        return 0;
    }
    //主函数
    public static void find(int count,int index) {
        if(index==len+1){
            if(count==0){
                min=0;
            }
            if(count>=1){
                min=Math.min(count-1,min);
            }
            return;
        }
        int i=index;
        while(i<=len){
            if(isRever(index,i)){
                find(count+1,i+1);
                if(count>=min) return;
            }
            i++;
        }
    }
    //判断是否是回文字符串
    public static boolean isRever(int i,int j){
        while(i<=j){
            if(str.charAt(i)!=str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        str="apjesgpsxoeiokmqmfgvjslcjukbqxpsobyhjpbgdfruqdkeiszrlmtwgfxyfostpqczidfljwfbbrflkgdvtytbgqalguewnhvvmcgxboycffopmtmhtfizxkmeftcucxpobxmelmjtuzigsxnncxpaibgpuijwhankxbplpyejxmrrjgeoevqozwdtgospohznkoyzocjlracchjqnggbfeebmuvbicbvmpuleywrpzwsihivnrwtxcukwplgtobhgxukwrdlszfaiqxwjvrgxnsveedxseeyeykarqnjrtlaliyudpacctzizcftjlunlgnfwcqqxcqikocqffsjyurzwysfjmswvhbrmshjuzsgpwyubtfbnwajuvrfhlccvfwhxfqthkcwhatktymgxostjlztwdxritygbrbibdgkezvzajizxasjnrcjwzdfvdnwwqeyumkamhzoqhnqjfzwzbixclcxqrtniznemxeahfozp";
        System.out.println(minCut(str)+"");
    }

}
