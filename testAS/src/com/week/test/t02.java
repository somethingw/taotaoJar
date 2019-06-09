package com.week.test;
import java.util.*;
/**
 * @author week
 * @Title: t02
 * @ProjectName testAS
 * @Description: TODO
 * @date 2019/4/520:56
 */
public class t02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int num[]=new int[n];
        for (int i=0;i<n;i++){
            num[i]=sc.nextInt();
        }
        Arrays.sort(num);

        if (num[0]!=1){
            System.out.println(-1);
        }else if(n==1){
            System.out.println(m);
        }
        int dp[][]=new int[n][m];
        for(int i=0;i<n;i++){
            dp[i][0]=1;
        }
        for(int i=0;i<m;i++){
            dp[0][i]=m;
        }
        for(int i=1;i<n;i++){
            for (int j=1;j<m;j++){
                dp[i][j]=dp[i-1][j];
                if(j+1<num[i]){
                    int temp=j-num[i]>=0?dp[i][j-num[i]]:0;
                    if(temp!=0){
                        dp[i][j]=temp;
                    }
                }
            }
        }



    }
}
