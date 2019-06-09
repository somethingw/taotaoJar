package com.week;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author week
 * @Title: A_Simple_Task
 * @ProjectName 19-0316
 * @Description: https://blog.csdn.net/fangzhenpeng/article/details/49078233
 * @date 2019/5/2715:47
 */

public class A_Simple_Task {
    static double eps=1000000;
    static long INF64=10000000000000000L;
    //节点
    static final  int N_NODE=20;
    //边
    static final int N_EDGE=400;
    static long cnt=0;
    static long[][] dp=new long[1<<N_NODE][N_NODE];
    static int[] tail=new int[N_NODE];
    static int es=0;
    static int[] pre=new int[N_EDGE];
    static int[] e=new int[N_EDGE];

    static void add(int s,int t){
        ++es;
        pre[es]=tail[s];
        tail[s]=es;
        e[es]=t;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n,m,s,t;
        n=sc.nextInt();
        m=sc.nextInt();
        Arrays.fill(tail,-1);
        Arrays.fill(pre,-1);
        Arrays.fill(e,-1);
        for(int i=0;i<m;++i){
            s=sc.nextInt();
            t=sc.nextInt();
            add(s-1,t-1);
            add(t-1,s-1);
        }
        //初始化dp表
        for(int i=0;i<n;++i){
            dp[1<<i][i]=1;
        }
        for(int ST=1;ST<(1<<n);++ST){
            for(int i=0;i<n;++i){
                //当前状态无效
                if(dp[ST][i]==0) continue;
                for(int edge=tail[i];edge!=-1;edge=pre[edge]){
                    int j=e[edge];
                    if((ST&(-ST))>(1<<j))continue;
                    //在集合中
                    if(((1<<j)&ST)!=0){
                        if((ST&(-ST))==(1<<j)){
                            cnt+=dp[ST][i];
                        }
                    }else{
                        dp[ST|(1<<j)][j]+=dp[ST][i];
                    }
                }
            }
        }
        cnt=(cnt-m)/2;
        System.out.println(cnt);
    }
}
