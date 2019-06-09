package com.week.test;
import java.util.*;
/**
 * @author week
 * @Title: t01
 * @ProjectName testAS
 * @Description: TODO
 * 4
 * 1100
 * @date 2019/4/518:25
 */
public class t01 {
    private static int[] d;
    private static int[] p;
    private static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        d=new int[n];
        p=new int[n];
        for(int i = 0; i < n; i++){
           d[i]=sc.nextInt();
        }
        for(int i = 0; i < n; i++){
            p[i]=sc.nextInt();
        }
        System.out.println(find(0,0));

    }
    //从i开始最少多少钱,当前武力值多少
    public static int find(int i,int WL){
        if(i==n-1){
            if(WL>=d[i]){return 0;}
            else{
                return p[i];
            }
        }
        //武力总值小于当前怪兽,只能花钱手收买
        if(WL<d[i]){
            return p[i]+find(i+1,WL+d[i]);
        }else{//否则，收买，或者不收买，选个最小值
            return Math.min(find(i+1,WL),p[i]+find(i+1,WL+d[i]));
        }
    }
}
