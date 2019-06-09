package com.week.Dijkstra;
import org.omg.PortableInterceptor.INACTIVE;

import java.lang.reflect.Array;
import  java.util.*;
/**
 * @author week
 * @Title: dijkstra
 * @ProjectName 19-0316
 * @Description: Input Format
 * 第1行：n m start end //正整数n ，代表图中结点的数量。非负整数m代表要图中有向边的数量。
 *
 * 第2行到第1+m行: a b p //每行两个整数：代表结点a到结点b有一条有向边（a->b），权值为p
 * input:
 * 7 12 4 6
 * 1 2 2
 * 3 1 4
 * 1 4 1
 * 2 4 3
 * 4 5 2
 * 2 5 10
 * 3 6 5
 * 4 6 8
 * 4 7 4
 * 5 7 6
 * 7 6 1
 * 4 3 2
 *
 * output:
 *5                      //P382的例子
 * 4 7 6
 * @date 2019/5/2515:57
 */
public class dijkstra {
    static int END;
    static int[] pre;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int start=sc.nextInt()-1;
        int end=sc.nextInt()-1;
        END=end;
        int[][] graph=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(graph[i],Integer.MAX_VALUE);
            graph[i][i]=0;
        }
        for(int i=0;i<m;i++){
            int a=sc.nextInt()-1;
            int b=sc.nextInt()-1;
            int p=sc.nextInt();
            if(a!=b){
                graph[a][b]=p;
            }
        }
        //距离的保存数组
        int[] dis=new int[n];
        pre=new int[n];
        //表示哪个已经找到了
        boolean[] visited=new boolean[n];
        //从零开始，很显然，0已经找到了
        visited[start]=true;
        //初始化距离数组
        for(int i=0;i<n;i++){
            dis[i]=graph[start][i];
            pre[i]=start;
        }
        pre[start]=-1;
        dijkstra(graph, dis, visited);
        System.out.println(dis[end]);
        Stack<Integer> stack=new Stack<>();
        stack.push(end+1);
        while (pre[end]!=-1){
            stack.push(pre[end]+1);
            end=pre[end];
        }
        while(stack.size()>1){
            System.out.print(stack.pop()+" ");
        }

        System.out.print(stack.pop());
    }
    public static void  dijkstra(int[][] graph,int[] dis,boolean[] visited){
        while(true){
            //首先确定最小值
            int min=Integer.MAX_VALUE;
            int index=-1;
            for(int i=0;i<dis.length;i++){
                if(visited[i])
                    continue;
                else{
                    if(dis[i]<min){
                        index=i;
                        min=dis[i];
                    }
                }
            }
            if(index==-1) break;
            //找到了
            visited[index]=true;
            //找到的是index.谁和index有关，index到起点的最小值是min，更新谁的值
            for(int i=0;i<graph.length;i++){
                if(graph[index][i]!=Integer.MAX_VALUE&&(min+graph[index][i]<dis[i])){
                        dis[i]=min+graph[index][i];
                        pre[i]=index;
                }
            }
            if(index==END) break;
        }
    }


}
