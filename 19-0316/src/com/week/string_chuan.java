package com.week;

/**
 * @author week
 * @Title: string_chuan
 * @ProjectName 19-0316
 * @Description: 查找两个字符串a,b中的最长公共子串。若有多个，输出在较短串中最先出现的那个。
 * @date 2019/6/317:53
 */
import java.util.*;
public class string_chuan {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String strA=sc.nextLine();
        String strB=sc.nextLine();
        //保证a比b小，好处理
        if(strA.length()>strB.length()){
            String tmp=strB;
            strB=strA;
            strA=tmp;
        }
        int max=-1;

        int m=strA.length();
        int n=strB.length();
        int dp=0;
        int i=0,j=n;
        int start=m+1;
        while(i<=m&&j>=0){
            dp=0;
            int p=i+1,q=j+1;
            while(p<=m&&q<=n){
                if(strA.charAt(p-1)==strB.charAt(q-1)){
                    dp=dp+1;
                    if(dp>max||(dp==max&&p<start)){
                        max=dp;
                        start=p;
                    }
                }else{
                    dp=0;
                }
                p++;
                q++;
            }
            if(j>0){
                j--;
            }else{
                i++;
            }

        }
        System.out.println(strA.substring(start-max,start));
    }
}
