package com.week.class_05;


import java.util.*;
import java.io.*;
import java.math.*;
public class test {
    static long fact[];
    static long invFact[];
    static long perm(int n,int r){
        long mod = 1000*1000*1000 + 7;
//	System.out.println(n + " " + r);
        return ((fact[n]*invFact[r]) % mod)*invFact[n - r] % mod;
    }
    public static void main(String [] args)throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        long mod = 1000*1000*1000 + 7;

        Pair [] array = new Pair[n + 1];
        for(int i = 0;i < n;i++){
            st  = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            array[i] = new Pair(x,y);
        }
        array[n] = new Pair(h,w);
        Arrays.sort(array);
        fact = new long[h + w + 1];
        invFact = new long[h + w + 1];
        fact[0] = 1;
        for(int i = 1;i <= h + w ;i++){
            fact[i] = fact[i - 1]*i % mod;
            System.out.print(fact[i]+"-");
        }

        System.out.println();
        System.out.println();
        invFact[h + w] = BigInteger.valueOf(fact[h + w]).modInverse(BigInteger.valueOf(mod)).longValue();
        for(int i = h + w - 1;i >= 0;i--){
            invFact[i] = invFact[i + 1]*(i + 1) % mod;
            System.out.print(invFact[i]+"-");
        }
        long ans [] = new long [n + 1];
        for(int i = 0;i < array.length;i++){
            long tot = perm(array[i].x + array[i].y - 2,array[i].x - 1);
            long temp = 0;
            for(int j = 0;j < i;j++){
                if(array[i].x < array[j].x || array[i].y < array[j].y || j == i)continue;
                temp += perm(array[i].x - array[j].x + array[i].y - array[j].y,array[i].x - array[j].x)*ans[j] % mod;
                while(temp >= mod)temp -= mod;
            }
            ans[i] = (tot - temp + mod) % mod;
        }
        System.out.println(Arrays.toString(ans));
        System.out.print(ans[n]);
    }
    static class Pair implements Comparable<Pair>{
        int x;
        int y;
        public Pair(int x,int y){
            this.x = x;
            this.y = y;
        }
        public int compareTo(Pair other){
            return (x + y) - (other.x + other.y);
        }
    }
}