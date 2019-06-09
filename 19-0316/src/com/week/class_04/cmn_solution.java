package com.week.class_04;

import java.util.Scanner;

/**
 * @author week
 * @Title: cmn_solution
 * @ProjectName 19-0316
 * @Description: TODO
 * @date 2019/6/620:05
 */

public class cmn_solution {
    static int N=1000000007;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        System.out.println(solution(m,n));
    }
    public static int solution(int m,int n){
        int up=1;
        int down=1;
        while(m>n){
            up=(up*m)%N;
            m--;
        }
        while(n>1){
            down=(down*n)%N;
            n--;
        }
        System.out.println(up);
        System.out.println(down);
        return up/down;
    }
}
