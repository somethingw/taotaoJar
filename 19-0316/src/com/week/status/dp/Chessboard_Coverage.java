package com.week.status.dp;

/**
 * @author week
 * @Title: Chessboard_Coverage
 * @ProjectName 19-0316
 * @Description:
 * 【例1】有一个N*M(N<=5,M<=1000)的棋盘，现在有1*2及2*1的小木块无数个，要盖满整个棋盘，有多少种方式？答案只需要mod1,000,000,007即可。
 * 例如：对于一个2*2的棋盘，有两种方法，一种是使用2个1*2的，一种是使用2个2*1的。
 * 算法分析】
 *
 * 在这道题目中,N和M的范围本应该是一样的，但实际上，N和M的范围却差别甚远，对于这种题目，首先应该想到的就是，正确算法与这两个范围有关！
 * N的范围特别小，因此可以考虑使用状态压缩动态规划的思想
 * 假设第一列已经填满，则第二列的摆设方式，只与第一列对第二列的影响有关。同理，第三列的摆设方式也只与第二列对它的影响有关。那么，使用一个长度为N的二进制数state来表示这个影响，例如：4(00100)就表示了图上第二列的状态。
 *
 * 因此，本题的状态可以这样表示：
 *
 * dp[i][state]表示该填充第i列，第i-1列对它的影响是state的时候的方法数。i<=M,0<=state<2N
 *
 * 对于每一列，情况数也有很多，但由于N很小，所以可以采取搜索的办法去处理。对于每一列，搜索所有可能的放木块的情况，并记录它对下一列的影响，之后更新状态。状态转移方程如下：
 *
 * dp[i][state]=∑dp[i-1][pre]每一个pre可以通过填放成为state

 * @date 2019/5/1117:37
 */
import java.util.*;
public class Chessboard_Coverage {

    static int N, M;
    static long dp[][]=new long[1005][34];

    public static void dfs(int i,int j,int state,int nex)
    {
        if (j==N)
        {
            dp[i+1][nex]+=dp[i][state];
            return;
        }
        //如果这个位置已经被上一列所占用,直接跳过
        if (((1<<j)&state)>0)
            dfs(i,j+1,state,nex);
        //如果这个位置是空的，尝试放一个1*2的
        if (((1<<j)&state)==0)
            dfs(i,j+1,state,nex|(1<<j));
        //如果这个位置以及下一个位置都是空的，尝试放一个2*1的
        if (j+1<N && ((1<<j)&state)==0 && ((1<<(j+1))&state)==0)
            dfs(i,j+2,state,nex);
        return;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            N=sc.nextInt();
            M=sc.nextInt();
            if (N == 0 && M == 0) break;
            dp[1][0] = 1;
            for (int i = 1; i <= M; i++) {
                for (int j = 0; j < (1 << N); j++)
                    if (dp[i][j]>0) {
                        dfs(i, 0, j, 0);
                    }
            }
            System.out.println(dp[M + 1][0]);
        }
    }


}
