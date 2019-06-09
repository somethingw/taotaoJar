package com.week.class_04;

/**
 * @author week
 * @Title: Make_Palindrome
 * @ProjectName 19-0316
 * @Description: TODO
 * @date 2019/6/610:48
 */
import java.util.*;
public class Make_Palindrome {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        char c[]="abcdefghijklmnopqrstuvwxyz".toCharArray();
        while (sc.hasNext()){
            String str=sc.nextLine();
            int[] num=new int[26];
            int n=str.length();
            char[] strRes=new char[n];
            //收集所有的字符出现的个数
            for(int i=0;i<n;i++){
                int index=(int)str.charAt(i)-'a';
                num[index]=num[index]+1;
            }
            int L=0,R=25;
            while (L<R){
                //右侧查找奇数次
                if(num[R]%2==0){
                    R--;
                    continue;
                }
                //左侧查找奇数次
                while (L<R&&num[L]%2==0){
                    L++;
                }
                if(L==R) break;
                num[R]=num[R]-1;
                num[L]=num[L]+1;
                R--;
                L++;
            }
            int flag=-1;
            int k=0;
            for(int i=0;i<26;i++){
                if(num[i]%2!=0){
                    flag=i;
                }
                for(int j=0;j<num[i]/2;j++){
                    strRes[k]=strRes[n-k-1]=c[i];
                    k++;
                }

            }
            if(flag!=-1){
                strRes[k]=c[flag];
            }
            System.out.println(String.valueOf(strRes));
        }
    }
}
