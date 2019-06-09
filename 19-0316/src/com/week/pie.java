package com.week;

import java.util.Scanner;

/**
 * @author week
 * @Title: pie
 * @ProjectName 19-0316
 * @Description: TODO
 * @date 2019/5/2716:40
 */
public class pie {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[][] graph;
        int n,m,k;
        n=sc.nextInt();
        m=sc.nextInt();
        k=sc.nextInt();
        graph=new int[n][m];
        for(int i=0;i<k;i++){
            int x=sc.nextInt();
            int y=sc.nextInt();
            graph[x][y]=graph[x][y]+1;
        }
    }
}
