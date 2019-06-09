package com.week.bag;

/**
 * @author week
 * @Title: bag_0_1
 * @ProjectName 19-0316
 * @Description: 问题描述：
 *         有n件物品和一个容量为v的背包。放入第i件物品的占的空间为Ci,得到的价值是Wi,求解将哪些物品装入背包可以
 *          使得总价值最大；
 * @date 2019/5/1121:38
 */
import java.util.*;
public class bag_0_1 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int C=sc.nextInt();
            int N=sc.nextInt();
            int[] V=new int[N+1];//评价
            int[] P=new int[N+1];//价格
            int[][] dp=new int[N+1][C+1];//表示dp[i][j]表示前i件放入容量为j的背包时的最大评价

            for(int i=1;i<=N;i++){
                P[i]=sc.nextInt();
                V[i]=sc.nextInt();
            }

            //第一行都为0，java里省去初始化
            for(int i=1;i<=N;i++){
                for(int j=0;j<=C;j++){
                    if(j-P[i]>=0){
                        dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-P[i]]+V[i]);
                    }else{
                        dp[i][j]=dp[i-1][j];
                    }
                }
            }
            System.out.println(dp[N][C]);

        }
    }


}
