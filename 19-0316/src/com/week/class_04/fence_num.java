package com.week.class_04;

/**
 * @author week
 * @Title: fence_num
 * @ProjectName 19-0316
 * @Description: TODO
 * @date 2019/6/619:36
 */
import java.util.*;
public class fence_num {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            int k=sc.nextInt();
            int num[]=new int[n];
            for(int i=0;i<n;i++){
                num[i]=sc.nextInt();
            }

            int sum=0;
            int index=0;
            for(int i=0;i<k;i++){
                sum=sum+num[i];
            }
            int min=sum;
            for(int i=k;i<n;i++){
                sum=sum-num[i-k]+num[i];
                if(sum<min){
                    min=sum;
                    index=i-k+1;
                }
            }
            System.out.println(index+1);
        }
    }
}
