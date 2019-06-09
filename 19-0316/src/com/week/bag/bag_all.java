package com.week.bag;

import java.util.*;

/**
 * @author week
 * @Title: bag_all
 * @ProjectName 19-0316
 * @Description:完全背包定义有N种物品和一个容量为V的背包，每种物品都有无限件可用。第i种物品的体积是c，价值是w。
 * 求解将哪些物品装入背包可使这些物品的体积总和不超过背包容量，且价值总和最大。
 * 本题要求是背包恰好装满背包时，求出最大价值总和是多少。如果不能恰好装满背包，输出NO
 * 第一行： N 表示有多少组测试数据（N<7）。
 * 接下来每组测试数据的第一行有两个整数M，V。 M表示物品种类的数目，V表示背包的总容量。(0<M<=2000，0<V<=50000)
 * 接下来的M行每行有两个整数c，w分别表示每种物品的重量和价值(0<c<100000，0<w<100000)
 * @date 2019/5/1122:40
 */
public class bag_all {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        for(int index=0;index<N;index++){
            int M=sc.nextInt();//种类
            int V=sc.nextInt();//背包的总重量
            int[] C=new int[M+1];//物品的重量
            int[] W=new int[M+1];//价值
            int[] dp=new int[V+1];//表示dp[i][j]表示前i件放入容量为j的背包时的最大评价

            for(int i=1;i<=M;i++){
                C[i]=sc.nextInt();
                W[i]=sc.nextInt();

            }
            Arrays.fill(dp,-1000000);
            dp[0]=0;
            for(int i=1;i<=M;i++){
                for(int j=C[i];j<=V;j++){
                            dp[j]=Math.max(dp[j],dp[j-C[i]]+W[i]);
                    }

            }
            System.out.println(dp[V]>0?dp[V]:"NO");
        }
    }
}
