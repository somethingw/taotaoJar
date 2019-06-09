/**
 * @author week
 * @Title: cicleSum
 * @ProjectName 19-0316
 * @Description:
 * 1.简单无向图即：无自环(单个点成环)，无重边（两个点之间多条边）的无向图。
 * 2.
 * @date 2019/5/1116:00
 */
import java.util.*;
public class cicleSum {


    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        //n为顶点的数量，m为边的数量
        int n=sc.nextInt();
        int m=sc.nextInt();

        boolean[][] adj = new boolean[n][n];
        long res = 0;
        for (int i = 0; i < m; ++i) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            adj[x - 1][y - 1] = true;
            adj[y - 1][x - 1] = true;
        }
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (adj[i][j]) {
                    --res;
                }
            }
        }
        for (int i = 0; i < n; ++i) {
            long[][] dp = new long[n - i][1 << (n - i)];
            dp[0][0] = 1;
            for (int mask = 0; mask < (1 << (n - i)); ++mask) {
                for (int j = 0; j < n - i; ++j) {
                    if (dp[j][mask] != 0) {
                        for (int k = 0; k < n - i; ++k) {
                            if (((mask >> k) & 1) == 0 && adj[j + i][k + i]) {
                                dp[k][mask | (1 << k)] += dp[j][mask];
                            }
                        }
                    }
                }
                if (((mask >> 0) & 1) != 0) {
                    res += dp[0][mask];
                }
            }
        }
        System.out.println(res / 2);

    }

}
